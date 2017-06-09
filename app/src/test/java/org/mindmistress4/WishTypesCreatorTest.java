package org.mindmistress4;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;

import bitsAndBytes.wishes.Wish;
import bitsAndBytes.wishes.WishTypesCreator;
import bitsAndBytes.wishes.WishWholeSessionDuration;
import filesReadAndWrite.Settings;

public class WishTypesCreatorTest {

    @Before
	public void setUp() {
		Settings.getInstance().setStartSettings();
	}

	@Test
	public void testGetAllWishesAllowedInParallel() {
		ArrayList<Wish> wishes = new ArrayList<Wish>();
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES));
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDCUFF));
		
		ArrayList<Wish> resultWishes = WishTypesCreator.getInstance().getAllWishesAllowedAdditionalInParallel(wishes);
		
		assertThat(6, equalTo(resultWishes.size()));
		
		assertThat("Kaefig", equalTo(resultWishes.get(0).getWishName()));
		assertThat("Gewichte", equalTo(resultWishes.get(1).getWishName()));
		assertThat("Dildo", equalTo(resultWishes.get(2).getWishName()));
		assertThat("Fernsehen", equalTo(resultWishes.get(3).getWishName()));
		assertThat("Stiefel", equalTo(resultWishes.get(4).getWishName()));
		assertThat("GerteEvent", equalTo(resultWishes.get(5).getWishName()));
	}

	@Test
	public void testGetAllWishesAllowedInParallel2() {
		ArrayList<Wish> wishes = new ArrayList<Wish>();
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES));
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDCUFF));
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_CAGE));
		
		ArrayList<Wish> resultWishes = WishTypesCreator.getInstance().getAllWishesAllowedAdditionalInParallel(wishes);
		
		assertThat(0, equalTo(resultWishes.size()));
	}
	
	
	@Test
	public void testPickAWishRandom() {
		ArrayList<Wish> wishes = new ArrayList<Wish>();
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_NAKED));
		wishes.add(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR));
		
		ArrayList<Wish> resultWishes = WishTypesCreator.getInstance().getAllWishesAllowedAdditionalInParallel(wishes);
		Wish w = WishTypesCreator.getInstance().pickAWishRandom(resultWishes, true);

		
		assertThat(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN), equalTo(w));
	}


	@Test
	public void testGetDuration() {
		Wish w = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_BRUSTKLAMMERN); // 10, 50
		int d = 0;
		
		d = w.getDuration(10, 100, true);
		assertThat(36, equalTo(d));
		
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));
		
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));

		w = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR); 
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));

		d = w.getDuration(50, 100, true);
		assertThat(50, equalTo(d));

		d = w.getDuration(0, 100, true);
		assertThat(100, equalTo(d));

	}
	
	@Test
	public void testGetDurationSingleOrderType() {
		Wish w = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_GERTE);
		int d = 0;
		
		d = w.getDuration(10, 100, true);
		assertThat(10, equalTo(d));
		
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));
		
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));

		w = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_ADORE_K_M); 
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));

		d = w.getDuration(50, 100, true);
		assertThat(10, equalTo(d));

		d = w.getDuration(0, 100, true);
		assertThat(10, equalTo(d));
	}


	@Test
	public void testWishWholeSessionDuration() {
		Wish w = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_NAKED); 
		int d = 0;
		
		d = w.getDuration(10, 100, true);
		assertThat(90, equalTo(d));
		
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));
		
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));
	
		w = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_WEAR_WYW); 
		d = w.getDuration(90, 100, true);
		assertThat(10, equalTo(d));
	
		d = w.getDuration(50, 100, true);
		assertThat(50, equalTo(d));
	
		d = w.getDuration(0, 100, true);
		assertThat(100, equalTo(d));
	
	}

	@Test
	public void testGetAllEnabledWishes() {
		Settings.getInstance().setStartSettings();

		ArrayList<Wish> wishes = new ArrayList<Wish>();

		Wish w1 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_NAKED);
		assertThat(true, is(w1.isWishEnabled()));
		wishes.add(w1);

		Wish w2 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_COLLAR);
		assertThat(true, is(w2.isWishEnabled()));
		wishes.add(w2);

		Wish w3 = WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_HANDFESSELN);
		assertThat(true, is(w3.isWishEnabled()));
		wishes.add(w3);
		
		ArrayList<Wish> result = WishTypesCreator.getInstance().getAllEnabledWishes(wishes);
		
		assertThat(result.size(), equalTo(3));
		assertThat(w1.getId(), equalTo(result.get(0).getId()));
		assertThat(w2.getId(), equalTo(result.get(1).getId()));
		assertThat(w3.getId(), equalTo(result.get(2).getId()));
	}
	
	@Test
	public void testGetWish1() {
		WishTypesCreator.getInstance().getWish(-1);
	}

	@Test
	public void testGetWish2() {
		WishTypesCreator.getInstance().getWish(Wish.MAX_WISH_DURATION);
	}

	@Test
	public void testGetter() {
		WishWholeSessionDuration wish = new WishWholeSessionDuration(WishTypesCreator.INDEX_WISH_NAKED+1000, "Nackig", "Starttext", "Endtext", true, 200);
		assertThat(wish.getCoolDown(), equalTo(-1));
		assertThat(wish.getMinDuration(), equalTo(-1));
		assertThat(wish.getMaxDuration(), equalTo(Wish.MAX_WISH_DURATION));
		wish.setMaxDuration(4711);
		
	}

}