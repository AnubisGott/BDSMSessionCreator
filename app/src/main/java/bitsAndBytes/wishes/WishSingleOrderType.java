package bitsAndBytes.wishes;

import hilfsklassen.ZZGenerator;

public class WishSingleOrderType extends Wish {
	int minEventDurationMinutes = 0; 
	int maxEventDurationMinutes = 0;
	int cooldown                = 0;
	
	public WishSingleOrderType(int wishId, String wishName, String startText, String endText, boolean initState, int gewicht, int minDuration, int maxDuration, int cooldown) {
		super(wishId, wishName, startText, endText, initState, gewicht);
		
		this.minEventDurationMinutes = minDuration;     
		this.maxEventDurationMinutes = maxDuration;
		this.cooldown                = cooldown;
	}

	@Override
	public int getDuration(int startpoint, int sessionDuration, boolean testMode) {
		ZZGenerator zzG = new ZZGenerator(testMode);
		
		int remainingTime = sessionDuration - startpoint; 
		int obereGrenze = Math.min(maxEventDurationMinutes, remainingTime);
		int duration = zzG.getIntBordersIncluded(minEventDurationMinutes, obereGrenze);
		
		return duration;
	}

	@Override
	public int getCoolDown() {
		return cooldown;
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
		this.maxEventDurationMinutes = duration;
	}


}
