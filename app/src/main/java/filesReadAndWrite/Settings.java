package filesReadAndWrite;


import android.content.Context;

import java.util.*;

import bitsAndBytes.wishes.WishTypesCreator;
import bitsAndBytes.wishes.Wishes;
import hilfsklassen.Logger;

public class Settings {
	public final static String settingsFileName = "settings.txt";
	private static Settings settingsSingleton = null;
	private ArrayList<Boolean> wishEnabled = null;
	public static final int START_LEVEL = 1;
	private int level = START_LEVEL;

	public int getLevel() {
		return level;
	}
	
	public static Settings getInstance() {
		if (settingsSingleton == null) settingsSingleton = new Settings();
		return settingsSingleton;
	}
	
	
	private Settings() {
		wishEnabled = new ArrayList<Boolean>();
		setStartSettings();
	}
	
	public void setStartSettings() {
		level = START_LEVEL;
		
	    wishEnabled.add(WishTypesCreator.INDEX_WISH_NAKED,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_NAKED).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_WEAR_FETISCH,   new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_WEAR_FETISCH).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_WEAR_WYW,       new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_WEAR_WYW).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_COLLAR,         new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_COLLAR).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_HANDFESSELN,    new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_FUSSFESSELN,    new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_FUSSFESSELN).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_HANDCUFF,       new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_HANDCUFF).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND, new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_BIG_TOES,       new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_BIG_TOES).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_THUMBS,         new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_THUMBS).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_CAGE,           new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_CAGE).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_FETISH_GLOVES,  new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_FETISH_GLOVES).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_DOWN_KNEES,     new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_KNEBEL,         new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_KNEBEL).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN,  new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_GO_CORNER,      new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_GO_CORNER).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_GEWICHTE,       new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_GEWICHTE).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_KG,             new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_KG).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_DILDO,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_DILDO).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_MASKE,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_MASKE).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_TELEVISION,     new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_TELEVISION).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_ADORE_K_M,      new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_ADORE_K_M).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_GERTE,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_GERTE).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_CUST1,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST1).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_CUST2,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST2).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_CUST3,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST3).getInitState()));
		wishEnabled.add(WishTypesCreator.INDEX_WISH_CUST4,          new Boolean(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST4).getInitState()));
	}
	
	public Boolean getWishSetting(int i) {
		if(i < 0) return null;
		if(i >= Wishes.getSize()) return null;
		
		return wishEnabled.get(i);
	}
	
	public void enableWish(int i) {
		if(i < 0) return;
		if(i >= Wishes.getSize()) return;

		wishEnabled.set(i, new Boolean(true));

		// Logger.log(Logger.info, "enableWish " + i, Settings.class);

	}
	
	public void disableWish(int i) {
		if(i < 0) return;
		if(i >= Wishes.getSize()) return;
		
		wishEnabled.set(i, new Boolean(false));
		// Logger.log(Logger.info, "enableWish " + i, Settings.class);
	}
	
	public void saveSettings(Context context) {
		String saveString = computeSaveString();
		
		WriteAndReadFileUtil.writeStringToFile(settingsFileName, saveString, context);
	}

	private String computeSaveString() {
		String result = "";
		Logger.log(Logger.all, "saveString: " + result, this.getClass());
		
		for(int i=0; i<Wishes.getSize(); i++) {
			Boolean bB = wishEnabled.get(i);
			boolean b = bB.booleanValue();
			
			if(b) result = result.concat("1");
			else result = result.concat("0");
			Logger.log(Logger.all, "saveString: " + result, this.getClass());
		}
		
		result = result.concat("" + this.level);
		Logger.log(Logger.all, "saveString: " + result, this.getClass());
		
		return result;
	}

	private int computeLoadString(String loadString) {
		for(int i=0; i<Wishes.getSize(); i++) {
			char c = loadString.charAt(i);
			if(c == '0') wishEnabled.set(i, new Boolean(false));  
			else if(c == '1') wishEnabled.set(i, new Boolean(true));
			else return -1;
		}

		try {
			String levelString = loadString.substring(Wishes.getSize());
			int levelInt = Integer.parseInt(levelString);
			level = levelInt;
		}
		catch(java.lang.StringIndexOutOfBoundsException e) {
			Logger.log(e);
			return -2;
		}

		catch(java.lang.NumberFormatException e) {
			Logger.log(e);
			return -3;
		}

	
		return 0;
	}

	public void loadSettings(Context context) {
		String readString = WriteAndReadFileUtil.readStringFromFile(settingsFileName, context);
		if(readString == null) { 
			setStartSettings();
			return;
		}
		
		int errorCode = computeLoadString(readString);
		if(errorCode != 0) setStartSettings();  
	}


}
