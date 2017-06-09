package bitsAndBytes;

import java.util.ArrayList;

import bitsAndBytes.wishes.Wish;
import hilfsklassen.Logger;

public class ActionPlan {
	private ArrayList<ActionItem> actionPlan = new ArrayList<ActionItem>();


	public int getRemainingCooldownTime(Wish wish, int zeitpunkt) {
		if(wish == null) {
			Logger.log(Logger.warning, "wish is null", this.getClass());
			return -1;
		}

		int cooldown = -1;
		int maxCooldown = cooldown;
		for(int i=0; i<actionPlan.size(); i++) {
			if(actionPlan.get(i).getWish().getId() == wish.getId()) {
				// int startTime = actionPlan.get(i).getStartPointInMinutes();
				int endTime   = actionPlan.get(i).getEndPointInMinutes();
				int wishCooldown = actionPlan.get(i).getWish().getCoolDown();
				
				cooldown = endTime + actionPlan.get(i).getWish().getCoolDown() - zeitpunkt;
						
				if(zeitpunkt < endTime) cooldown = -1;
				if(endTime + wishCooldown < zeitpunkt) cooldown = -1;
				
				if(cooldown > maxCooldown) maxCooldown = cooldown;
			}
		}
		
		return maxCooldown;
	}


	public void add(ActionItem actionItem) {
		actionPlan.add(actionItem);
	}

	public int size() {
		return actionPlan.size();
	}

	public ActionItem get(int actionItemIndex) {
		return actionPlan.get(actionItemIndex);
	}


	public ArrayList<Wish> getAllWishesNotInCooldown(ArrayList<Wish> wishList, int zeitpunkt) {
		ArrayList<Wish> result = new ArrayList<Wish>();
		if(wishList == null) return result;
		
		for(int i=0; i<wishList.size(); i++) {
			if(getRemainingCooldownTime(wishList.get(i), zeitpunkt) <= 0) {
				result.add(wishList.get(i));
			}
		}
		
		return result;
	}


}
