package bitsAndBytes.wishes;

import hilfsklassen.Logger;
import hilfsklassen.ZZGenerator;

public class WishDurationType extends Wish {
	int minEventDurationMinutes = 0; 
	int maxEventDurationMinutes = 0;
	boolean untilEndOfSessionPossibleYesNo = false;
	int cooldownTime = 0;
	
	public WishDurationType (int wishId, String wishName, String startText, String endText, boolean initState, int gewicht, int minEventDurationMinutes, int maxEventDurationMinutes, boolean untilEndOfSessionPossibleYesNo, int cooldownMinutes) {
		super(wishId, wishName, startText, endText, initState, gewicht);

		this.minEventDurationMinutes        = minEventDurationMinutes;     
		this.maxEventDurationMinutes        = Math.max(minEventDurationMinutes, maxEventDurationMinutes);
		this.untilEndOfSessionPossibleYesNo = untilEndOfSessionPossibleYesNo;
		this.cooldownTime                   = cooldownMinutes;
	}

	@Override
	public int getDuration(int startpoint, int sessionDuration, boolean testMode) {
		if(untilEndOfSessionPossibleYesNo) return sessionDuration - startpoint;
		
		ZZGenerator zzG = new ZZGenerator(testMode);
		
		int remainingTime = sessionDuration - startpoint; 
		int obereGrenze = Math.min(maxEventDurationMinutes, remainingTime);
		Logger.log(Logger.all, "remainingTime: " + remainingTime + "   sessionDuration: " + sessionDuration + "   startpoint: " + startpoint + "    obereGrenze: " + obereGrenze, this.getClass());
		int duration = zzG.getIntBordersIncluded(minEventDurationMinutes, obereGrenze);
		
		return duration;
	}

	@Override
	public int getCoolDown() {
		return cooldownTime;
	}

	@Override
	public int getMinDuration() {
		return minEventDurationMinutes;
	}

	@Override
	public int getMaxDuration() {
		return maxEventDurationMinutes;
	}

	@Override
	public void setMaxDuration(int duration) {
		maxEventDurationMinutes = duration;
	}



}
