package org.mindmistress4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import bitsAndBytes.ActionItem;
import bitsAndBytes.ActionPlan;
import bitsAndBytes.wishes.Wish;
import bitsAndBytes.wishes.WishTypesCreator;
import filesReadAndWrite.Settings;

public class ActionPlanTest {
	private ActionPlan actionPlan = null;
	
	@Before
	public void setUp() throws Exception {
		Settings.getInstance().setStartSettings();
		actionPlan = new ActionPlan();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTestGetRemainingCooldownTime0() {
		int cooldownresult = actionPlan.getRemainingCooldownTime(null, 2);
		assertThat(cooldownresult, equalTo(-1));
	}
	
	@Test
	public void testTestGetRemainingCooldownTime1() {
		// item nicht im testplan enthalten

		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		Wish wish2 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN);
		
		int cooldownresult = actionPlan.getRemainingCooldownTime(wish2, 2);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	@Test
	public void testTestGetRemainingCooldownTime2() {
		// item im testplan enthalten aber Zeitpunkt vor der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 20);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime3() {
		// item im testplan enthalten aber Zeitpunkt nach der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 90);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime4() {
		// item im testplan enthalten Zeitpunkt zu Begin der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 30);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime5() {
		// item im testplan enthalten Zeitpunkt zu Ende der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 60);
		
		assertThat(cooldownresult, equalTo(15));
	}
	
	@Test
	public void testTestGetRemainingCooldownTime5b() {
		// item im testplan enthalten Zeitpunkt zu Ende der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 59);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	@Test
	public void testTestGetRemainingCooldownTime5c() {
		// item im testplan enthalten Zeitpunkt zu Ende der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 61);
		
		assertThat(cooldownresult, equalTo(14));
	}
	
	@Test
	public void testTestGetRemainingCooldownTime6() {
		// item im testplan enthalten Zeitpunkt mitten in der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 40);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime7() {
		// item im testplan enthalten Zeitpunkt Anfang der Cooldown Phase
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 61);
		
		assertThat(cooldownresult, equalTo(14));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime8() {
		// item im testplan enthalten Zeitpunkt Ende der Cooldown Phase
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 74);
		
		assertThat(cooldownresult, equalTo(1));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime8a() {
		// item im testplan enthalten Zeitpunkt Ende der Cooldown Phase
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 75);
		
		assertThat(cooldownresult, equalTo(0));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime8b() {
		// item im testplan enthalten Zeitpunkt Ende der Cooldown Phase
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 76);
		
		assertThat(cooldownresult, equalTo(-1));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime9() {
		// item im testplan enthalten Zeitpunkt Ende der Cooldown Phase
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 71);
		
		assertThat(cooldownresult, equalTo(4));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime10() {
		// item im testplan enthalten Zeitpunkt Mitte der Cooldown Phase
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 74);
		
		assertThat(cooldownresult, equalTo(1));
	}
	
	@Test
	public void testTestGetRemainingCooldownTime11() {
		// der gleiche Wunsch mehrfach
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));
		actionPlan.add(new ActionItem(wish1, 75, 85, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 90);
		
		assertThat(cooldownresult, equalTo(10));
	}
	
	
	@Test
	public void testTestGetRemainingCooldownTime12() {
		// item im testplan enthalten aber Zeitpunkt vor der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 5, 15, true ));
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 20);
		
		assertThat(cooldownresult, equalTo(10));
	}	

	@Test
	public void testTestGetRemainingCooldownTime13() {
		// item im testplan enthalten aber Zeitpunkt vor der Ausführung
		
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));
		actionPlan.add(new ActionItem(wish1, 5, 15, true ));

		int cooldownresult = actionPlan.getRemainingCooldownTime(wish1, 20);
		
		assertThat(cooldownresult, equalTo(10));
	}	

	@Test
	public void testGetAllWishesNotInCooldown1() {
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		ArrayList<Wish> inputList = new ArrayList<Wish>();
		inputList.add(wish1);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		ArrayList<Wish> result = actionPlan.getAllWishesNotInCooldown(inputList, 165);

		
		assertThat(result.size(), equalTo(1));
	}	

	
	@Test
	public void testGetAllWishesNotInCooldown2() {
		Wish wish1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		ArrayList<Wish> inputList = new ArrayList<Wish>();
		inputList.add(wish1);
		actionPlan.add(new ActionItem(wish1, 30, 60, true ));

		ArrayList<Wish> result = actionPlan.getAllWishesNotInCooldown(inputList, 65);

		
		assertThat(result.size(), equalTo(0));
	}	


	@Test
	public void testGetAllWishesNotInCooldown3() {
		ArrayList<Wish> result = actionPlan.getAllWishesNotInCooldown(null, 65);
		assertThat(result.size(), equalTo(0));
	}	

}
