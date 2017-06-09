package bitsAndBytes;

import org.mindmistress4.SessionActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import bitsAndBytes.wishes.Wish;
import hilfsklassen.ZZGenerator;

public class ActionItem {
	private Wish wish = null;
	private int startPointInMinutes = 0;
	private int endPointInMinutes   = 0;
	private enum states { beforeEvent, duringEvent, afterEvent };
	private states actionItemState = states.beforeEvent;
	private boolean runInTestMode = false;
	
	public Wish getWish() {
		return wish;
	}

	public int getStartPointInMinutes() {
		return startPointInMinutes;
	}

	public int getEndPointInMinutes() {
		return endPointInMinutes;
	}

	public ActionItem(Wish wish, int startPointInMinutes, int endPointInMinutes, boolean runInTestMode) {
		this.wish = wish;
		this.startPointInMinutes = startPointInMinutes;
		this.endPointInMinutes   = endPointInMinutes;
		this.runInTestMode       = runInTestMode;
	}


	public ActionItem(Wish w, int zeitpunkt, boolean runInTestMode, int sessionDuration) {
		this.wish = w;
		this.startPointInMinutes = zeitpunkt;
		this.runInTestMode = runInTestMode;

		ZZGenerator zzG = new ZZGenerator(runInTestMode);

		int endPointProposal = zeitpunkt + zzG.getIntBordersIncluded(w.getMinDuration(), w.getMaxDuration());
		this.endPointInMinutes = Math.min(endPointProposal, sessionDuration);
	}


	public long performToStart(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		long b = -1;
		if(actionItemState == states.beforeEvent) b = performBeforeEvent(time, timeInMilliSeconds, sessionActivity);
		return b;
	}


	public long performToEnd(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		long b = -1;
		if(actionItemState == states.duringEvent) return performDuringEvent(time, timeInMilliSeconds, sessionActivity);
		if(actionItemState == states.afterEvent)  return performAfterEvent (time, timeInMilliSeconds, sessionActivity);
		return b;
	}


	private long performBeforeEvent(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		long b = -1;
		if(time <  startPointInMinutes) return (startPointInMinutes * 60 * 1000) - timeInMilliSeconds;
		if(time >= startPointInMinutes) b = startEvent(time, timeInMilliSeconds, sessionActivity);
		actionItemState = states.duringEvent;
		return b;
	}


	private long performDuringEvent(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		long b = -1;
		if(time <  endPointInMinutes) return (endPointInMinutes * 60 * 1000) - timeInMilliSeconds;
		if(time >= endPointInMinutes) b = stopEvent(time, timeInMilliSeconds, sessionActivity);
		actionItemState = states.afterEvent;
		return b;
	}


	private long performAfterEvent(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		return -1;
	}


	private long startEvent(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		if(sessionActivity == null) System.out.println("Start (" + time + " min): " + this.wish.getWishName());
		else {
			if(!runInTestMode) sessionActivity.playSound();
			// sessionActivity.addTextLine("Start (" + time + " min): " + this.wish.getWishName() + getCurrentTimeStamp());
			sessionActivity.addTextLine(this.wish.getStartText(sessionActivity) + getCurrentTimeStamp());
		}

		return 0;
	}


	private long stopEvent(long time, long timeInMilliSeconds, SessionActivity sessionActivity) {
		if("Start (" + time + " min): " + this.wish.getWishName() == null) System.out.println("End (" + time + " min): " + this.wish.getWishName());
		else {
			if(!runInTestMode) sessionActivity.playSound();
			// sessionActivity.addTextLine("End (" + time + " min): " + this.wish.getWishName());
			sessionActivity.addTextLine(this.wish.getEndText(sessionActivity) + getCurrentTimeStamp());
		}

		return 0;
	}

	public String getCurrentTimeStamp() {
		// return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		return "(" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + ")";
	}
}
