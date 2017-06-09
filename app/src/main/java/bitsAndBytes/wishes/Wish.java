package bitsAndBytes.wishes;

import android.content.Context;
import android.content.res.Resources;

import org.mindmistress4.R;

import filesReadAndWrite.Settings;

public abstract class Wish {
    public final static int MAX_WISH_DURATION = 480;

    private int id;
    private String wishName;
    private String startText;
    private String endText;
    private boolean initState = false;
    private int gewicht = 0;

    public Wish(int id, String wishName, String startText, String endText, boolean initState, int gewichtWahrscheinlichkeit) {
        this.id = id;
        this.wishName = wishName;
        this.startText = startText;
        this.endText = endText;
        this.initState = initState;
        this.gewicht = gewichtWahrscheinlichkeit;
    }

    public String getWishName() {
        return wishName;
    }

    public String getStartText(Context context) {
        Resources res = context.getResources();
        String[] startCommands = res.getStringArray(R.array.startCommands);
        return startCommands[id];
    }

    public String getEndText(Context context) {
        Resources res = context.getResources();
        String[] startCommands = res.getStringArray(R.array.endCommands);
		return startCommands[id];
    }

	public boolean getInitState() {
		return initState;
	}
	
	public int getId() {
		return this.id;
	}	
	
	public int getWeight() {
		return this.gewicht;
    }

    public boolean isWishEnabled() {
        return Settings.getInstance().getWishSetting(id);
    }
	
	public abstract int getDuration(int startpoint, int sessionDuration, boolean testMode);
	public abstract int getCoolDown();
	public abstract int getMinDuration();
	public abstract int getMaxDuration();
	public abstract void setMaxDuration(int duration);
}
