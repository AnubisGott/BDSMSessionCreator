package bitsAndBytes.wishes;

import java.util.ArrayList;

import filesReadAndWrite.Settings;
import hilfsklassen.Logger;
import hilfsklassen.ZZGenerator;

public class WishTypesCreator {
	public final static int INDEX_WISH_NAKED          = 0;
	public final static int INDEX_WISH_WEAR_FETISCH   = 1;
	public final static int INDEX_WISH_WEAR_WYW       = 2;
	public final static int INDEX_WISH_COLLAR         = 3;
	public final static int INDEX_WISH_HANDFESSELN    = 4;
	public final static int INDEX_WISH_FUSSFESSELN    = 5;
	public final static int INDEX_WISH_HANDCUFF       = 6;
	public final static int INDEX_WISH_BIND_FOOT_HAND = 7;
	public final static int INDEX_WISH_BIG_TOES       = 8;
	public final static int INDEX_WISH_THUMBS         = 9;
	public final static int INDEX_WISH_CAGE           = 10;
	public final static int INDEX_WISH_FETISH_GLOVES  = 11;
	public final static int INDEX_WISH_DOWN_KNEES     = 12;
	public final static int INDEX_WISH_KNEBEL         = 13;
	public final static int INDEX_WISH_BRUSTKLAMMERN  = 14;
	public final static int INDEX_WISH_GO_CORNER      = 15;
	public final static int INDEX_WISH_GEWICHTE       = 16;
	public final static int INDEX_WISH_KG             = 17;
	public final static int INDEX_WISH_DILDO          = 18;
	public final static int INDEX_WISH_MASKE          = 19;
	public final static int INDEX_WISH_TELEVISION     = 20;
	public final static int INDEX_WISH_ADORE_K_M      = 21;
	public final static int INDEX_WISH_GERTE          = 22;
	public final static int INDEX_WISH_CUST1          = 23;
	public final static int INDEX_WISH_CUST2          = 24;
	public final static int INDEX_WISH_CUST3          = 25;
	public final static int INDEX_WISH_CUST4          = 26;
	
	
	private ArrayList<Wish> wishes = new ArrayList<Wish>();
	private Wish halsbandwish = null;
	
	private int allowedCombinations[][] = { 
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1 },
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1 },
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1 },
			{ 0, 0,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,  1,	1,	1 },
			{ 0, 0,	0,	1,	0,	1,	0,	0,	1,	0,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	0,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0, 0,  1,	0,	1,	0,	0,	1,	0,	1,	0,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0, 0,	1,	0,	0,	0,	0,	0,	0,	1,	0,	0,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	0,	0,	0,	0 },
			{ 0, 0, 0,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	0,	0,	1,	0,	1,	0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	0,	1,	1,	0,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	1,	0,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	0,	1,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	0,	1,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	1,	0,	1,	1,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	1,	0,	1,	1,	1,	1,	1,	0,	0,	1,	1,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 },
			{ 0, 0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0 }
	}; 
	
	
	private static WishTypesCreator wtcInstance = null;
	
	public static WishTypesCreator getInstance() {
		if(wtcInstance == null) wtcInstance = new WishTypesCreator();
		
		return wtcInstance;
	}
	
	private WishTypesCreator() {
		createWishTypes();
	}
	
	
	public int getSize() {
		return wishes.size();
	}
	
	public Wish getWish(int index) {
		if(index < 0) {
			Logger.log(Logger.severe, "index ouf of bounds: " + index, this.getClass());
			return null;
		}
		if(index >=  this.wishes.size()) {
			Logger.log(Logger.severe, "index ouf of bounds: " + index, this.getClass());
			return null;
		}
		
		return wishes.get(index);
	}


	private void createWishTypes() {

		// nackt dress 
		wishes.add(new WishWholeSessionDuration(INDEX_WISH_NAKED,        "Nackig", "Ausziehen!", "Anziehen",                                                         true, 200));

		// Fetisch Dress
		wishes.add(new WishWholeSessionDuration(INDEX_WISH_WEAR_FETISCH, "Latexdress", "Latexoutfit anziehen!", "Normale Klamotten anziehen",                        true, 500));

		// was du tragen moechtest
		wishes.add(new WishWholeSessionDuration(INDEX_WISH_WEAR_WYW,     "WasImmerDuTragenMoechtest", "Ziehe ein passendes Outfit an", "Normale Klamotten anziehen", true, 200));


		// Halsband tragen (max spielzeit, maxspielzeit, untilEndOfSessionPossibleYesNo=yes, cooldown=0)
		halsbandwish = new WishDurationType(INDEX_WISH_COLLAR,           "Halsband", "Halsband anlegen!", "Halsband ablegen!",                            true, 1000 /* weigt */, 7*60*24 /* min duration */, 7*60*24 /* max duration */,  true,  60*24 /* cool down */);
		wishes.add(halsbandwish); //! Wahrscheinlichkeit, dass es genommen wird ist 100%

		// Handfesseln vorne (min Zeit 10 min, max zeit = max spielzeit, cooldown 15 min)		
		wishes.add(new WishDurationType(INDEX_WISH_HANDFESSELN,          "HandschellenEvent", "Handschellen anlegen!", "Handschellen abnehmen!",          true, 500,  10, 10, false, 15));

		// Fussfesseln 		
		wishes.add(new WishDurationType(INDEX_WISH_FUSSFESSELN,          "FussfesselEvent", "Füsse fesseln", "Füsse losmachen!",                          true, 500,  10, 60, false, 60));

		// Handfesseln (min Zeit 10 min, max zeit 50 min, cooldown 4 h)
		wishes.add(new WishDurationType(INDEX_WISH_HANDCUFF,             "HandfesselEvent", "Hände fesseln!", "Hände losmachen!",                         true, 1000, 10, 50, false, 60*4));

		// Verbinde Fuss und Hand (min Zeit 10 min, maxzeit 50 min)(4 h)
		wishes.add(new WishDurationType(INDEX_WISH_BIND_FOOT_HAND,       "HandfesselHandFussEvent", "Hände an Füsse fesseln!", "Hände und Füße losmachen!",  false, 100,  10, 50, false, 60*4));

		// Gro?e Zehen mit d?nnem Seil zusammen binden (min 15, max 2 h, cooldown 24 h)
		wishes.add(new WishDurationType(INDEX_WISH_BIG_TOES,             "ZehenfesselEvent", "Zehen fesseln!", "Zehen losmachen!",                        false, 100,  15,120, false, 60*24*7));

		// Daumenschellen
		wishes.add(new WishDurationType(INDEX_WISH_THUMBS,               "DaumenschellenEvent", "Daumen fesseln!", "Daumen losmachen!",                   false, 100,  10, 50, false, 60*24*7));

		// Zeit im K?fig verbringen (min Zeit 10 min, max zeit 50 min, cooldown 24 h)
		wishes.add(new WishDurationType(INDEX_WISH_CAGE,                 "Kaefig", "Ab in den Käfig!", "Raus aus dem Käfig!",                             false, 100,  10, 50, false, 60*4));

		// Latex Handschuhe (min 10 min, max Zeit 50 min, cooldown 4 h)
		wishes.add(new WishDurationType(INDEX_WISH_FETISH_GLOVES,        "Latexhandschuhe", "Handschuhe anziehen!", "Handschuhe ausziehen!",              true, 500,  10, 50, false, 60*4));

		// auf die Knie gehen (min 10, max 50 min, cooldown 4 h)
		wishes.add(new WishDurationType(INDEX_WISH_DOWN_KNEES,           "RunterKnie", "Auf die Knie!", "Aufstehen!",                                     true, 100,  10, 50, false, 60*4));

		// Sprechverbot (min 10 min, max 50 min, cooldown 8 h) 
		wishes.add(new WishDurationType(INDEX_WISH_KNEBEL,               "Knebel", "Knebel anlegen!", "Knebel ablegen!",                                  true, 800,  10, 50, false, 60*8));

		// Brustklammern setzen (min 10 min, max 50 min, cooldown 24 h)
		wishes.add(new WishDurationType(INDEX_WISH_BRUSTKLAMMERN,        "Brustklammern", "Brustklammern setzen!", "Brustklammern abnehmen!",             true, 800,  10, 50, false, 60*24));

		// In die Ecke stellen mit dem Gesicht zur Wand ( min 8, max 15, cooldown 24h)
		wishes.add(new WishDurationType(INDEX_WISH_GO_CORNER,            "InDieEcke", "Stell dich in die Ecke!", "Raus aus der Ecke!",                    true, 100,  8, 15, false, 60*24));

		// Gewichte( min 8, max 15, cooldown 4h)
		wishes.add(new WishDurationType(INDEX_WISH_GEWICHTE,             "Gewichte", "Gewichte anbringen!", "Gewichte abnehmen!",                         false, 100,  8, 15, false, 60*24*7));

		// KG (30 min, max spielzeit, cooldown spielzeit)
		wishes.add(new WishDurationType(INDEX_WISH_KG,                   "KG", "Keuschheitsgürtel anlegen!", "Keuschheitsgürtel abnehmen!",               false, 500,  30, 30, false, 60*24));

		// Dildo tragen (45 min, 1,5h, 1T)
		wishes.add(new WishDurationType(INDEX_WISH_DILDO,                "Dildo", "Dildo benutzen!", "Dildo weglegen!",                                   false, 100, 45, 90, false, 60*24));

		// Haube/Maske/Kopft?te (min 20 min, max 60 min, cooldown 24 h)
		wishes.add(new WishDurationType(INDEX_WISH_MASKE,                "Haube", "Haube benutzen!", "Haube weglegen",                                    false, 100, 20, 60, false, 60*24));

		// Fernsehsender einschalten und fernbedienung au?er Reichweite Programmnummer ist die Minute der aktuelle Stunde
		// ist der dort kein Programm solange Program +1 bet?tigen, bis man einen g?ltiges Programm hat) (min 15 min, max 2h, cooldown, 24h)
		wishes.add(new WishDurationType(INDEX_WISH_TELEVISION,           "Fernsehen", "Schau fernsehen!", "Fernseher aus!",                               false, 100, 15, 120, false, 60*24*7));

		// Kleidungsst?ck von Herrin k?ssen (min 5, max 15 min, cooldown 24 h)
		wishes.add(new WishSingleOrderType(INDEX_WISH_ADORE_K_M,          "Stiefel", "Runter zum Stiefel!", "Genug Stiefel!",                             false, 100, 10, 20, 60*24));

		// Gerte 15 Schl?ge selbst auf den Po (15 St?ck, cooldown 24 h)
		wishes.add(new WishSingleOrderType(INDEX_WISH_GERTE,              "GerteEvent", "Gerte rausholen!", "Genug Gerte!",                               true, 100, 10, 20, 60*24));

		//! strom
		//! wachs
		//! vibrator
		//! blindfold
		//! leine

		wishes.add(new WishSingleOrderType(INDEX_WISH_CUST1,              "Custom1", "Starte Custom1!", "Stop Custom1!",                 false, 100, 0, 0, 0));
		wishes.add(new WishSingleOrderType(INDEX_WISH_CUST2,              "Custom2", "Starte Custom2!", "Stop Custom2!",                 false, 100, 0, 0, 0));
		wishes.add(new WishSingleOrderType(INDEX_WISH_CUST3,              "Custom3", "Starte Custom3!", "Stop Custom3!",                 false, 100, 0, 0, 0));
		wishes.add(new WishSingleOrderType(INDEX_WISH_CUST4,              "Custom4", "Starte Custom4!", "Stop Custom4!",                 false, 100, 0, 0, 0));
	}


	public ArrayList<Wish> getAllWishesAllowedAdditionalInParallel(ArrayList<Wish> runningWishes) {
		int combinedResult [] = new int[allowedCombinations.length];
		for(int i=0; i<allowedCombinations.length; i++) {
			combinedResult[i] = 1;
			for(int wishIndex=0; wishIndex<runningWishes.size(); wishIndex++) {
				int indexToWish = runningWishes.get(wishIndex).getId();
				combinedResult[i] = combinedResult[i] & allowedCombinations[indexToWish][i];
			}
		}
		
		ArrayList<Wish> result = new ArrayList<Wish>();
		for(int i=0; i<combinedResult.length; i++) {
			if(combinedResult[i] == 1) result.add(this.getWish(i));
		}
		
		return result;
	}

	
	public Wish pickAWishRandom(ArrayList<Wish> wishList, boolean testMode) {
		if (wishList == null)     { Logger.log(Logger.severe, " pickAWishRandom wishlist empty ", this.getClass()); return null; }
		if (wishList.size() == 0) { Logger.log(Logger.severe, " pickAWishRandom wishlist empty ", this.getClass()); return null; }
		
		int sum = 0;
		for(int i=0; i<wishList.size(); i++) {
			Wish w = wishList.get(i);
			sum = sum + w.getWeight();
			Logger.log(Logger.all, "wish " + w.getWishName() + "   weight: " + w.getWeight(), this.getClass());
		}
		Logger.log(Logger.all, "  sum: " + sum, this.getClass());
		
		ZZGenerator zzG = new ZZGenerator(testMode);
		int rn = zzG.getIntBordersIncluded(0, sum);
		Logger.log(Logger.all, "  rn: " + rn, this.getClass());
		
		Wish w = wishList.get(0);
		
		for(int i=0; i<wishList.size(); i++) {
			w = wishList.get(i);
			sum = sum + w.getWeight();
			if(rn <= sum) {
				Logger.log(Logger.all, "  wish: " + w.getWishName(), this.getClass());
				return w;
			}
		}
		return w;
	}
	

	public ArrayList<Wish> getAllEnabledWishes(ArrayList<Wish> potentialWishes) {
		ArrayList<Wish> result = new ArrayList<Wish>();

		for(int i=0; i<potentialWishes.size(); i++) {
			Wish w = potentialWishes.get(i);
			if (Settings.getInstance().getWishSetting(w.getId())) result.add(w);
		}		
		
		return result;
	}

	public void replaceMaxDurationAttributesWithSessionDuration(int timeForSessionInMinutes) {
		for(int i=0; i<wishes.size(); i++) {
			int maxDur = wishes.get(i).getMaxDuration();
			if(maxDur == 0) wishes.get(i).setMaxDuration(timeForSessionInMinutes);
		}
	}

}




