package bitsAndBytes;

import java.util.ArrayList;

import bitsAndBytes.wishes.Wish;
import bitsAndBytes.wishes.WishTypesCreator;
import bitsAndBytes.wishes.Wishes;
import filesReadAndWrite.Settings;
import hilfsklassen.HilfsKlasse;
import hilfsklassen.Logger;
import hilfsklassen.ZZGenerator;

public class Session {
	private int  initialSessionDuration = 0;
	private int  sessionDuration = 0;
	private ActionPlan actionPlan = new ActionPlan();
	boolean runInTestMode = false;
	
	private Wish wearingDuringSession = null;
	
	// clothCode: 0=nackt, 1=Fetisch, 2=was du willst
	public Session(int wishedTimeForSessionInMinutes, int level, boolean runInTestMode) {
		this.runInTestMode = runInTestMode;
		WishTypesCreator.getInstance().replaceMaxDurationAttributesWithSessionDuration(wishedTimeForSessionInMinutes);
		
		int allowedSessionDuration = this.getMaxDurationForLevel(level);
		sessionDuration = Math.min(wishedTimeForSessionInMinutes, allowedSessionDuration);
		initialSessionDuration = sessionDuration;
		
		setClothCode();
		if(sessionDuration <= 0) return;
		
		// liste der Actions Kleidung und Halsband kommen immer an position eins und zwei mit dem Zeitpunkt Minute -2 und Minute -1
		ActionItem wearingDuringSessionAI = new ActionItem(this.wearingDuringSession, -2, sessionDuration, runInTestMode);
		actionPlan.add(wearingDuringSessionAI);
		
		ActionItem collarAI = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR), -1, sessionDuration, runInTestMode);
		actionPlan.add(collarAI);
	
		createActionPlan(runInTestMode);
		cutActionPlanToTheLastAction();
		
		if(runInTestMode) printActionPlan();
	}


	private void printActionPlan() {
		System.out.println("Action Plan: " + this.sessionDuration + "(min)");
		for(int i=0; i<actionPlan.size(); i++) {
			System.out.println("  Start: " + actionPlan.get(i).getStartPointInMinutes()
					+ "  Ende: " + actionPlan.get(i).getEndPointInMinutes() + "   " 
					+ actionPlan.get(i).getWish().getWishName());
			
		}
	}
	
	
	private void cutActionPlanToTheLastAction() {
		int countActions = actionPlan.size();
		
		if(countActions >= 1) {
			ActionItem lastActionItem = actionPlan.get(actionPlan.size()-1);
			
			int lastActionEndsAt = lastActionItem.getEndPointInMinutes();
			
			this.sessionDuration = lastActionEndsAt;
		}
	}
	
	private void createActionPlan(boolean testMode) {
		if(this.getNumberTryToCreateActionItems() == 0) return;
		ArrayList<Integer> zeitPunkte = HilfsKlasse.getTimepoints(new ZZGenerator(testMode), this.getNumberTryToCreateActionItems(), sessionDuration);
		
		Logger.log(Logger.all, "zeitpunkte: ", this.getClass());
		for(int zeitpunktIndex=0; zeitpunktIndex<zeitPunkte.size(); zeitpunktIndex++) {
			Logger.log(Logger.all, "zeitpunkt: " + zeitPunkte.get(zeitpunktIndex).intValue(), this.getClass());
			int zeitpunkt = zeitPunkte.get(zeitpunktIndex).intValue();
			
			ArrayList<Wish> wuenscheRunning  = wasLauftAllesZumZeitpunktParallel(zeitpunkt);
			Logger.log(Logger.all, "wuenscheRunning: " + wuenscheRunning.size(), this.getClass());

			// collect wishes, that are not allowed to run in addition to the already running ones
			// this routine omits the already running wishes at this point in time
			ArrayList<Wish> potentialWishes  = WishTypesCreator.getInstance().getAllWishesAllowedAdditionalInParallel(wuenscheRunning); 
			Logger.log(Logger.all, "potentialWishes: " + potentialWishes.size(), this.getClass());
			
			// this removes the disabled wishes in the settings
			ArrayList<Wish> potentialWishesWithoutDisabledWishes = WishTypesCreator.getInstance().getAllEnabledWishes(potentialWishes);
			Logger.log(Logger.all, "potentialWishesWithoutDisabledWishes: " + potentialWishesWithoutDisabledWishes.size(), this.getClass());
					
			// remove wishes in cooldown
			ArrayList<Wish> potentialWishesWithoutDisabledWishesWithoutCooldownWishes = actionPlan.getAllWishesNotInCooldown(potentialWishesWithoutDisabledWishes, zeitpunkt);
			Logger.log(Logger.all, "potentialWishesWithoutDisabledWishesWithoutCooldownWishes: " + potentialWishesWithoutDisabledWishesWithoutCooldownWishes.size(), this.getClass());

			// remove wishes with minDuration > remainingSessionDuration
			ArrayList<Wish> solidWishes = removeWishesMinSmallerRemainnigSessionTime(zeitpunkt, potentialWishesWithoutDisabledWishesWithoutCooldownWishes);
			Logger.log(Logger.all, "solidWishes: " + solidWishes.size(), this.getClass());
			
			
			if(solidWishes.size() > 0) {
				Wish w = WishTypesCreator.getInstance().pickAWishRandom(solidWishes, testMode);
				Logger.log(Logger.all, w.getWishName() + "  zeitpunkt: " + zeitpunkt, this.getClass());
				ActionItem ai = new ActionItem(w, zeitpunkt, testMode, this.sessionDuration);
				actionPlan.add(ai);
			}
		}
	}

	public ArrayList<Wish> removeWishesMinSmallerRemainnigSessionTime(int zeitpunkt, ArrayList<Wish> wishList) {
		ArrayList<Wish> resultWuensche = new ArrayList<Wish>();
		if(wishList == null) return resultWuensche;
		
		for(int i=0; i<wishList.size(); i++) {
			if(zeitpunkt + wishList.get(i).getMinDuration() < this.sessionDuration) resultWuensche.add(wishList.get(i)); 
		}
		
		return resultWuensche;
	}


	public ArrayList<Wish> wasLauftAllesZumZeitpunktParallel(int zeitpunkt) {
		ArrayList<Wish> resultWuensche = new ArrayList<Wish>();
		for(int actionItemIndex=0; actionItemIndex<actionPlan.size(); actionItemIndex++) {
			ActionItem actionItem = actionPlan.get(actionItemIndex);
			Wish wish = actionItem.getWish();
			boolean b = liegtZeitPunktImActionItemZeitraum(zeitpunkt, actionItem);
			
			Logger.log(Logger.all, "wish number: " + actionItemIndex + "  startpoint " + actionItem.getStartPointInMinutes() 
			    + "  endpoint: " + actionItem.getEndPointInMinutes() + "  zeitpunkt liegt im Wunsch: " + b, this.getClass());
			
			if(b) resultWuensche.add(wish);
		}
		
		return resultWuensche;
	}
	
	
	public boolean liegtZeitPunktImActionItemZeitraum(int zeitpunkt, ActionItem actionItem) {
		int beginActionItem = actionItem.getStartPointInMinutes();
		int endActionItem = actionItem.getEndPointInMinutes();
		
		if(zeitpunkt < beginActionItem) return false;
		if(zeitpunkt > endActionItem)   return false;
		
		return true;
	}

	public ActionItem getActionItem(int index) {
		return actionPlan.get(index);
	}
	
	public int getSessionDuration() {
		return sessionDuration;
	}
	
	public int getCountActionItemsDepToDuration() {
		if(initialSessionDuration <= 10) return 0; 
		if(initialSessionDuration <= 15) return 1; 
		if(initialSessionDuration <= 20) return 2; 
		if(initialSessionDuration <= 30) return 3; 
		if(initialSessionDuration <= 45) return 4; 
		if(initialSessionDuration <= 60) return 5; 
		if(initialSessionDuration <= 90) return 6; 
		if(initialSessionDuration <=120) return 7; 
		
		return (initialSessionDuration / 30) + 3;
	}

	public int getMaxDurationForLevel(int level) {
		if(level <= 0) return 0;
		return level * 15 + 15;
	}
	
	public int getNumberTryToCreateActionItems() {
		return getCountActionItemsDepToDuration(); 
	}
	
	public int getNumberDroppedActionItems() {
		return getNumberTryToCreateActionItems() - getCountActionPlanItems();
	}
	
	public int getCountActionPlanItems() {
		if(actionPlan.size() == 0) return 0;
		
		return actionPlan.size() -2;
	}
	
	public int getCountActionItemsPlannedToExecute() {
		return actionPlan.size();
	}
	
	private void setClothCode() {
		if(Settings.getInstance().getWishSetting(WishTypesCreator.INDEX_WISH_WEAR_FETISCH) == true) {
			ZZGenerator zzG = new ZZGenerator(runInTestMode);
			int rn = zzG.getIntBordersIncluded(0, 2);
			
			if(rn == 0) wearingDuringSession = Wishes.getWish(WishTypesCreator.INDEX_WISH_NAKED);
			if(rn == 1) wearingDuringSession = Wishes.getWish(WishTypesCreator.INDEX_WISH_WEAR_FETISCH);
			if(rn == 2) wearingDuringSession = Wishes.getWish(WishTypesCreator.INDEX_WISH_WEAR_WYW);
		}
		else {
			wearingDuringSession = Wishes.getWish(WishTypesCreator.INDEX_WISH_NAKED);
		}
	}

	public Wish getWearing() {
		return wearingDuringSession;
	}
	
	
}


