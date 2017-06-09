package hilfsklassen;

import java.util.ArrayList;
import java.util.Collections;

public class HilfsKlasse {

    public static ArrayList<Integer> getTimepoints(ZZGenerator zzGenerator, int numberOfActions, int sessionDurationInMinutes) {
		if(sessionDurationInMinutes <= 0) return null;
		if(numberOfActions <= 0)          return null;
		if(numberOfActions > sessionDurationInMinutes) {
			Logger.log(Logger.severe, "numberOfActions > sessionDurationInMinutes " + numberOfActions + " " + sessionDurationInMinutes, HilfsKlasse.class);
			return null;
		}
		
		ArrayList<Integer> zeitpunkteActionItems = new ArrayList<Integer>();
		zeitpunkteActionItems.add(0);
		
		if(numberOfActions == 1) return zeitpunkteActionItems;
		
		for(int i=1; i<numberOfActions; i++) {
			int zeitpunkt = zzGenerator.getIntBordersIncluded(1, sessionDurationInMinutes - 1);
			
			int maxTries = 7;
			while(isSchonEnthalten(zeitpunkteActionItems, zeitpunkt) && maxTries>0) {
				zeitpunkt = zzGenerator.getIntBordersIncluded(1, sessionDurationInMinutes - 1);
				maxTries--;
			}
			
			if(!isSchonEnthalten(zeitpunkteActionItems, zeitpunkt)) {
				zeitpunkteActionItems.add(zeitpunkt);
			}
			else
			{ // takeTheNextFreeNumber
				for(int ersatzZeitpunkt=1; ersatzZeitpunkt<=sessionDurationInMinutes-1; ersatzZeitpunkt++) {
					if(!isSchonEnthalten(zeitpunkteActionItems, ersatzZeitpunkt)) {
						zeitpunkteActionItems.add(ersatzZeitpunkt);
						break;
					}
				}
			}
		}
		
		Collections.sort(zeitpunkteActionItems);
		
		return zeitpunkteActionItems;
	}
	
	static private boolean isSchonEnthalten(ArrayList<Integer> zeitpunkte, int zeitpunkt) {
		for(int i=0; i<zeitpunkte.size(); i++) {
			if((int)zeitpunkte.get(i) == zeitpunkt) return true;
		}
		
		return false;
	}
}
