package hilfsklassen;

import junit.framework.Assert;

import java.util.Random;

public class ZZGenerator {
	private Random random = null;

	public ZZGenerator (boolean runInTestMode) {
		if(runInTestMode) random = new Random(0);
		else              random = new Random();		
	}

	public int getIntBordersIncludedLong(int untereGrenze, int obereGrenze) {
		if(untereGrenze == obereGrenze) return untereGrenze;

		long uG = untereGrenze;
		long oG = obereGrenze;

		if(uG == oG) return (int)uG;

		if(uG > oG) {
			System.out.println("in method getIntBordersInlcuded in class ZZGenerator untereGrenze > obereGrenze   untereGrenze: "+ uG + "   obere Grenze: " + oG);
            Assert.fail();
            return obereGrenze;
		}

		long rangeLong = oG - uG + 1;
		int rangeInt = (int) rangeLong;
		if(rangeInt < 0) {
			System.out.println("in method getIntBordersInlcuded in class ZZGenerator obereGrenze-untereGrenze +1 ist negativ    uG: "+ uG + "   oG: " + uG);
			System.out.println("in method getIntBordersInlcuded in class ZZGenerator obereGrenze-untereGrenze +1 ist negativ    untereGrenze: "+ untereGrenze + "   obere Grenze: " + obereGrenze);
			System.out.println("uG == oG: "+ (uG == oG));
			System.out.println("uG: "+ uG);
			System.out.println("oG: "+ oG);
			System.out.println("rangeLong: "+ rangeLong);
			System.out.println("rangeInt: "+ rangeInt);
		}

		int r = random.nextInt(rangeInt) + (int)uG;
		return r;
	}


	public int getIntBordersIncluded(int untereGrenze, int obereGrenze) {
		if(untereGrenze == obereGrenze) return untereGrenze;

		if(untereGrenze > obereGrenze) {
			System.out.println("in method getIntBordersInlcuded in class ZZGenerator untereGrenze > obereGrenze   untereGrenze: "+ untereGrenze + "   obere Grenze: " + obereGrenze);
			return obereGrenze;
		}

		int  rangeInt = obereGrenze - untereGrenze + 1;
		if(rangeInt < 0) {
			System.out.println("in method getIntBordersInlcuded in class ZZGenerator obereGrenze-untereGrenze +1 ist negativ    untereGrenze: "+ untereGrenze + "   obere Grenze: " + obereGrenze);
			System.out.println("rangeInt: "+ rangeInt);
		}

		int r = random.nextInt(rangeInt) + untereGrenze;
		return r;
	}
}
