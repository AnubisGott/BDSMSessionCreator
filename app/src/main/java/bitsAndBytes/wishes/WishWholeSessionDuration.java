package bitsAndBytes.wishes;

public class WishWholeSessionDuration extends Wish {
	public WishWholeSessionDuration (int wishId, String wishName, String startText, String endText, boolean initState, int gewicht) {
		super(wishId, wishName, startText, endText, initState, gewicht);
		
	}
	
	@Override
	public int getDuration(int startpoint, int sessionDuration, boolean testMode) {
		int remainingTime = sessionDuration - startpoint; 
		
		return remainingTime;
	}

	@Override
	public int getCoolDown() {
		return -1;
	}
	
	@Override
	public int getMinDuration() {
		return -1;
	}

	@Override
	public int getMaxDuration() {
		return Wish.MAX_WISH_DURATION;
	}

	@Override
	public void setMaxDuration(int duration) {
	}

	
}
