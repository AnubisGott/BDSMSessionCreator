package org.mindmistress4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bitsAndBytes.ActionItem;
import bitsAndBytes.Session;
import bitsAndBytes.SlaveLevel;
import bitsAndBytes.wishes.Wish;
import bitsAndBytes.wishes.WishTypesCreator;
import bitsAndBytes.wishes.Wishes;
import filesReadAndWrite.Settings;
import hilfsklassen.ZZGenerator;



public class SessionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		setSettings();
	}

	@After
	public void tearDown() throws Exception {
		unsetSettings();
	}

	private void setSettings() {
		Settings.getInstance().setStartSettings();
		Settings.getInstance().enableWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
	}
	
	private void unsetSettings() {
		Settings.getInstance().setStartSettings();
	}
	
	private void enableMostSettings() {
		Settings.getInstance().enableWish(0);
		Settings.getInstance().enableWish(1);
		Settings.getInstance().disableWish(2); // INDEX_WISH_WEAR_WYW
		Settings.getInstance().enableWish(3);
		Settings.getInstance().enableWish(4);
		Settings.getInstance().enableWish(5);
		Settings.getInstance().enableWish(6);
		Settings.getInstance().enableWish(7);
		Settings.getInstance().enableWish(8);
		Settings.getInstance().enableWish(9);
		Settings.getInstance().enableWish(10);
		Settings.getInstance().enableWish(11);
		Settings.getInstance().enableWish(12);
		Settings.getInstance().disableWish(13); // INDEX_WISH_KNEBEL
		Settings.getInstance().enableWish(14);
		Settings.getInstance().enableWish(15);
		Settings.getInstance().enableWish(16);
		Settings.getInstance().enableWish(17);
		Settings.getInstance().enableWish(18);
		Settings.getInstance().enableWish(19);
		Settings.getInstance().enableWish(20);
		Settings.getInstance().enableWish(21);
		Settings.getInstance().disableWish(22); // INDEX_WISH_GERTE
		Settings.getInstance().enableWish(23);
		Settings.getInstance().enableWish(24);
        Settings.getInstance().enableWish(25);
        Settings.getInstance().enableWish(26);
	}
	

	
	@Test
	public void testWishesAreCreated() {
		assertThat("Nackig",                    equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_NAKED).getWishName()));
		assertThat("Latexdress",                equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_WEAR_FETISCH).getWishName()));
		assertThat("WasImmerDuTragenMoechtest", equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_WEAR_WYW).getWishName()));
		assertThat("Halsband",                  equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_COLLAR).getWishName()));
		assertThat("HandschellenEvent",         equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN).getWishName()));
		assertThat("FussfesselEvent",           equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_FUSSFESSELN).getWishName()));
		assertThat("HandfesselEvent",           equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_HANDCUFF).getWishName()));
		assertThat("HandfesselHandFussEvent",   equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND).getWishName()));
		assertThat("ZehenfesselEvent",          equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_BIG_TOES).getWishName()));
		assertThat("DaumenschellenEvent",       equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_THUMBS).getWishName()));
		assertThat("Kaefig",                    equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_CAGE).getWishName()));
		assertThat("Latexhandschuhe",           equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_FETISH_GLOVES).getWishName()));
		assertThat("RunterKnie",                equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES).getWishName()));
		assertThat("Knebel",                    equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_KNEBEL).getWishName()));
		assertThat("Brustklammern",             equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN).getWishName()));
		assertThat("InDieEcke",                 equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_GO_CORNER).getWishName()));
		assertThat("Gewichte",                  equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_GEWICHTE).getWishName()));
		assertThat("KG",                        equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_KG).getWishName()));
		assertThat("Dildo",                     equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_DILDO).getWishName()));
		assertThat("Haube",                     equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_MASKE).getWishName()));
		assertThat("Fernsehen",                 equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_TELEVISION).getWishName()));
		assertThat("Stiefel",                   equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_ADORE_K_M).getWishName()));
		assertThat("GerteEvent",                equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_GERTE).getWishName()));
		assertThat("Custom1",                   equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST1).getWishName()));
		assertThat("Custom2",                   equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST2).getWishName()));
		assertThat("Custom3",                   equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST3).getWishName()));
		assertThat("Custom4",                   equalTo(Wishes.getWish(WishTypesCreator.INDEX_WISH_CUST4).getWishName()));

		assertThat(0,                    equalTo(WishTypesCreator.INDEX_WISH_NAKED));
		assertThat(1,                    equalTo(WishTypesCreator.INDEX_WISH_WEAR_FETISCH));
		assertThat(2,                    equalTo(WishTypesCreator.INDEX_WISH_WEAR_WYW));
		assertThat(3,                    equalTo(WishTypesCreator.INDEX_WISH_COLLAR));
		assertThat(4,                    equalTo(WishTypesCreator.INDEX_WISH_HANDFESSELN));
		assertThat(5,                    equalTo(WishTypesCreator.INDEX_WISH_FUSSFESSELN));
		assertThat(6,                    equalTo(WishTypesCreator.INDEX_WISH_HANDCUFF));
		assertThat(7,                    equalTo(WishTypesCreator.INDEX_WISH_BIND_FOOT_HAND));
		assertThat(8,                    equalTo(WishTypesCreator.INDEX_WISH_BIG_TOES));
		assertThat(9,                    equalTo(WishTypesCreator.INDEX_WISH_THUMBS));
		assertThat(10,                   equalTo(WishTypesCreator.INDEX_WISH_CAGE));
		assertThat(11,                   equalTo(WishTypesCreator.INDEX_WISH_FETISH_GLOVES));
		assertThat(12,                   equalTo(WishTypesCreator.INDEX_WISH_DOWN_KNEES));
		assertThat(13,                   equalTo(WishTypesCreator.INDEX_WISH_KNEBEL));
		assertThat(14,                   equalTo(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN));
		assertThat(15,                   equalTo(WishTypesCreator.INDEX_WISH_GO_CORNER));
		assertThat(16,                   equalTo(WishTypesCreator.INDEX_WISH_GEWICHTE));
		assertThat(17,                   equalTo(WishTypesCreator.INDEX_WISH_KG));
		assertThat(18,                   equalTo(WishTypesCreator.INDEX_WISH_DILDO));
		assertThat(19,                   equalTo(WishTypesCreator.INDEX_WISH_MASKE));
		assertThat(20,                   equalTo(WishTypesCreator.INDEX_WISH_TELEVISION));
		assertThat(21,                   equalTo(WishTypesCreator.INDEX_WISH_ADORE_K_M));
		assertThat(22,                   equalTo(WishTypesCreator.INDEX_WISH_GERTE));
		assertThat(23,                   equalTo(WishTypesCreator.INDEX_WISH_CUST1));
		assertThat(24,                   equalTo(WishTypesCreator.INDEX_WISH_CUST2));
		assertThat(25,                   equalTo(WishTypesCreator.INDEX_WISH_CUST3));
		assertThat(26,                   equalTo(WishTypesCreator.INDEX_WISH_CUST4));
	}



	@Test
	public void testGetFirstSessionItem() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		
		Wish wish = session.getActionItem(0).getWish();
		assertThat("Nackig", equalTo(wish.getWishName()));
	}

	@Test
	public void testGetSecondSessionItem() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		
		Wish wish = session.getActionItem(1).getWish();
		assertThat("Halsband", equalTo(wish.getWishName()));
	}

	// wearing tests
	@Test
	public void testWearBeNaked() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		assertThat("Nackig", equalTo(session.getWearing().getWishName()));
	}

	@Test
	public void testWearFetish() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		assertThat("Nackig", equalTo(session.getWearing().getWishName()));
	}

	@Test
	public void testWearWYW() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		assertThat("Nackig", equalTo(session.getWearing().getWishName()));
	}
	

	@Test
	public void testCountActionItems1() {
		Session session = new Session(60, 20, true);

		assertThat(session.getCountActionPlanItems() + session.getNumberDroppedActionItems(), equalTo(session.getNumberTryToCreateActionItems()));

		assertThat(7, equalTo(session.getCountActionItemsPlannedToExecute()));
		assertThat(5, equalTo(session.getCountActionPlanItems()));
		assertThat(5, equalTo(session.getCountActionItemsDepToDuration()));
	}
	
	@Test
	public void testAlleItemsLiegenImZeitrahmen() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		
		for(int i=0; i<session.getCountActionPlanItems(); i++) {
			int endPoint = session.getActionItem(i).getEndPointInMinutes();
			int duration = session.getSessionDuration();
			
			assertTrue(endPoint <= duration);
		}
	}
	
	@Test
	public void testLiegtZeitPunktImWunschZeitraum() {
		int sessionDuration = 60;
		Session session = new Session(sessionDuration, SlaveLevel.STARTLEVEL, true);

		ActionItem a1 = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_NAKED), -2, true, sessionDuration);
		boolean result1 = session.liegtZeitPunktImActionItemZeitraum(20, a1);
		assertThat(true, equalTo(result1));

		ActionItem a2 = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR), -1, true, sessionDuration);
		boolean result2 = session.liegtZeitPunktImActionItemZeitraum(20, a2);
		assertThat(true, equalTo(result2));

		ActionItem a3 = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR), -1, true, sessionDuration);
		boolean result3 = session.liegtZeitPunktImActionItemZeitraum(60, a3);
		assertThat(true, equalTo(result3));

		ActionItem a4 = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR), -1, true, sessionDuration);
		boolean result4 = session.liegtZeitPunktImActionItemZeitraum(61, a4);
		assertThat(false, equalTo(result4));

		ActionItem a5 = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR), -1, true, sessionDuration);
		boolean result5 = session.liegtZeitPunktImActionItemZeitraum(-1, a5);
		assertThat(true, equalTo(result5));

		ActionItem a6 = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR), -1, true, sessionDuration);
		boolean result6 = session.liegtZeitPunktImActionItemZeitraum(-2, a6);
		assertThat(false, equalTo(result6));
	}
	
	@Test
	public void testWasLauftAllesZumZeitpunktParallel() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);

		ArrayList<Wish> resultWishes = session.wasLauftAllesZumZeitpunktParallel(0);
		
		assertThat(resultWishes.size(), equalTo(3));
	}	
	
	@Test
	public void testWasLauftAllesZumZeitpunktParallel2() {
		this.enableMostSettings();
		Session session = new Session(60, 100, true);

		ArrayList<Wish> resultWishes = session.wasLauftAllesZumZeitpunktParallel(30);
		
		assertThat(resultWishes.size(), equalTo(4));
		Settings.getInstance().setStartSettings();
	}	
	
	@Test
	public void testRemoveWishesMinSmallerRemainnigSessionTime0() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);
		ArrayList<Wish> resultWishes = session.removeWishesMinSmallerRemainnigSessionTime(30, null);
		
		assertThat(resultWishes.size(), equalTo(0));
	}
	
	
	@Test
	public void testRemoveWishesMinSmallerRemainnigSessionTime1() {
		Session session = new Session(60, 3, true);

		ArrayList<Wish> wishList = new ArrayList<Wish>();
		wishList.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDCUFF));

		ArrayList<Wish> resultWishes = session.removeWishesMinSmallerRemainnigSessionTime(30, wishList);
		
		assertThat(resultWishes.size(), equalTo(1));
		assertThat(resultWishes.get(0).getId(), equalTo(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDCUFF).getId()));
	}
	
	
	@Test
	public void testRemoveWishesMinSmallerRemainnigSessionTime2() {
		Session session = new Session(60, SlaveLevel.STARTLEVEL, true);

		ArrayList<Wish> wishList = new ArrayList<Wish>();
		wishList.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDCUFF));

		ArrayList<Wish> resultWishes = session.removeWishesMinSmallerRemainnigSessionTime(55, wishList);
		
		assertThat(resultWishes.size(), equalTo(0));
	}
	
	@Test
	public void testGetCountActionItems1() {
		Session session = new Session(60, 3, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(5));
	}
	
	@Test
	public void testGetCountActionItems2() {
		Session session = new Session(90, 12, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(6));
	}
	
	@Test
	public void testGetCountActionItems3() {
		Session session = new Session(119, 12, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(7));
	}
	
	@Test
	public void testGetCountActionItems4() {
		Session session = new Session(120, 12, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(7));
	}
	
	@Test
	public void testGetCountActionItems5() {
		Session session = new Session(121, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(7));
	}
	
	@Test
	public void testGetCountActionItems6() {
		Session session = new Session(149, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(7));
	}
	
	@Test
	public void testGetCountActionItems7() {
		Session session = new Session(150, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(8));
	}
	
	@Test
	public void testGetCountActionItems8() {
		Session session = new Session(151, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(8));
	}
	
	@Test
	public void testGetCountActionItems9() {
		Session session = new Session(151, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(8));
	}
	
	@Test
	public void testGetCountActionItems10() {
		Session session = new Session(10, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(0));
	}
	
	@Test
	public void testGetCountActionItems11() {
		Session session = new Session(15, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(1));
	}
	
	@Test
	public void testGetCountActionItems12() {
		Session session = new Session(20, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(2));
	}
	
	@Test
	public void testGetCountActionItems13() {
		Session session = new Session(30, 20, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(3));
	}
	
	@Test
	public void testGetCountActionItems14() {
		Session session = new Session(45, 3, true);
		assertThat(session.getCountActionItemsDepToDuration(), equalTo(4));
	}
	
	@Test
	public void testgetMaxDurationForLevel1() {
		Session session = new Session(45, 20, true);
		assertThat(session.getMaxDurationForLevel(1), equalTo(30));
	}
	
	@Test
	public void testgetMaxDurationForLevel2() {
		Session session = new Session(45, SlaveLevel.STARTLEVEL, true);
		assertThat(session.getMaxDurationForLevel(1), equalTo(30));
	}
	
	@Test
	public void testgetMaxDurationForLevel3() {
		Session session = new Session(45, SlaveLevel.STARTLEVEL, true);
		assertThat(session.getMaxDurationForLevel(2), equalTo(45));
	}
	
	@Test
	public void testgetMaxDurationForLevel4() {
		Session session = new Session(45, SlaveLevel.STARTLEVEL, true);
		assertThat(session.getMaxDurationForLevel(3), equalTo(60));
	}
	
	@Test
	public void testgetMaxDurationForLevel5() {
		Session session = new Session(45, SlaveLevel.STARTLEVEL, true);
		assertThat(session.getMaxDurationForLevel(0), equalTo(0));
	}
	
	
	@Test
	public void createSession0() {
		Session session = new Session(0, 0, true);
		assertThat(session.getCountActionPlanItems(), equalTo(0));
		assertThat(session.getSessionDuration(), equalTo(0));
	}

	@Test
	public void createSession1() {
		Session session = new Session(300, 1, true);
		assertThat(session.getCountActionPlanItems(), equalTo(3));
		assertThat(session.getSessionDuration(), equalTo(30));
	}

	@Test
	public void createSession2() {
		Session session = new Session(300, 2, true);
		assertThat(session.getCountActionPlanItems(), equalTo(3));
		assertThat(session.getSessionDuration(), equalTo(39));
	}

	@Test
	public void createSession3() {
		Session session = new Session(300, 3, true);
		assertThat(session.getCountActionPlanItems(), equalTo(5));
		assertThat(session.getSessionDuration(), equalTo(56));
	}

	@Test
	public void createSession4() {
		Session session = new Session(300, 4, true);
		assertThat(session.getCountActionPlanItems(), equalTo(5));
		assertThat(session.getSessionDuration(), equalTo(67));
	}

	@Test
	public void createSession5() {
		Session session = new Session(300, 5, true);
		assertThat(session.getCountActionPlanItems(), equalTo(6));
		assertThat(session.getSessionDuration(), equalTo(89));
	}

	@Test
	public void createSession6() {
		Session session = new Session(100, 6, true);
		assertThat(session.getCountActionPlanItems(), equalTo(6));
		assertThat(session.getSessionDuration(), equalTo(96));
	}

	@Test
	public void createSession7() {
		Session session = new Session(30, 100, true);
		assertThat(session.getCountActionPlanItems(), equalTo(3));
		assertThat(session.getSessionDuration(), equalTo(30));
	}

	@Test
	public void createSession8() {
		Session session = new Session(15, 100, true);
		assertThat(session.getCountActionPlanItems(), equalTo(1));
		assertThat(session.getSessionDuration(), equalTo(10));
	}

	@Test
	public void createSession9() {
		Session session = new Session(10, 100, true);
		assertThat(session.getCountActionPlanItems(), equalTo(0));
		assertThat(session.getSessionDuration(), equalTo(10));
	}

	@Test
	public void createSession10() {
		Session session = new Session(5, 100, true);
		assertThat(session.getCountActionPlanItems(), equalTo(0));
		assertThat(session.getSessionDuration(), equalTo(5));
	}

	@Test
	public void getNumberDroppedActionItems() {
		this.enableMostSettings();

		Session session = new Session(20, 100, true);
		assertThat(session.getNumberDroppedActionItems(), equalTo(0));
		assertThat(session.getNumberDroppedActionItems() +  session.getCountActionPlanItems(), equalTo(2));

		Settings.getInstance().setStartSettings();
	}

	
	@Test
	public void testMostSettingsSet() {
		this.enableMostSettings();
		
		Session session = new Session(300, 100, true);

		assertThat(session.getCountActionPlanItems(), equalTo(13));
		assertThat(session.getSessionDuration(), equalTo(300));
		
		assertThat(session.getActionItem(0).getWish().getId(), equalTo(0)); // INDEX_WISH_NAKED
		assertThat(session.getActionItem(1).getWish().getId(), equalTo(3)); // INDEX_WISH_COLLAR
		assertThat(session.getActionItem(2).getWish().getId(), equalTo(4)); // INDEX_WISH_HANDFESSELN
		assertThat(session.getActionItem(3).getWish().getId(), equalTo(5)); // INDEX_WISH_FUSSFESSELN
		assertThat(session.getActionItem(4).getWish().getId(), equalTo(4)); // INDEX_WISH_HANDFESSELN
		assertThat(session.getActionItem(5).getWish().getId(), equalTo(8)); // INDEX_WISH_BIG_TOES
		assertThat(session.getActionItem(6).getWish().getId(), equalTo(4));
		assertThat(session.getActionItem(7).getWish().getId(), equalTo(5));
		assertThat(session.getActionItem(8).getWish().getId(), equalTo(6));
		assertThat(session.getActionItem(9).getWish().getId(), equalTo(10));
		assertThat(session.getActionItem(10).getWish().getId(), equalTo(12));
        assertThat(session.getActionItem(11).getWish().getId(), equalTo(4));
        assertThat(session.getActionItem(12).getWish().getId(), equalTo(5));
        assertThat(session.getActionItem(13).getWish().getId(), equalTo(4));
        assertThat(session.getActionItem(14).getWish().getId(), equalTo(7));

        // System.out.println("count elements action items: " + session.getCountActionItemsPlannedToExecute());
        assertThat(15, equalTo(session.getCountActionItemsPlannedToExecute()));
        assertThat(13, equalTo(session.getCountActionItemsDepToDuration()));
        assertThat(13, equalTo(session.getCountActionPlanItems()));

		Settings.getInstance().setStartSettings();
	}


	@Test
	public void testMassTest1() {
		ZZGenerator zzG = new ZZGenerator(true);
		
		Settings.getInstance().saveSettings(null);
		
		for(int i=0; i<10; i++) {
			
			for(int j=0; j<WishTypesCreator.getInstance().getSize(); j++) {
				if(zzG.getIntBordersIncluded(0, 1) == 1) Settings.getInstance().disableWish(j);
				else Settings.getInstance().enableWish(j);
			}
			
			new Session(zzG.getIntBordersIncluded(0, 900), zzG.getIntBordersIncluded(-1, 50), true);
		}

		Settings.getInstance().setStartSettings();
	}
	
	
}


//assertTrue(responseString.contains("color") || responseString.contains("colour"));
//==> failure message: 
//java.lang.AssertionError:


//assertThat(responseString, anyOf(containsString("color"), containsString("colour")));
//==> failure message:
//java.lang.AssertionError: 
//Expected: (a string containing "color" or a string containing "colour")
//   got: "Please choose a font"