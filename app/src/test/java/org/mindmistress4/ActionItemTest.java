package org.mindmistress4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bitsAndBytes.ActionItem;
import bitsAndBytes.wishes.WishTypesCreator;
import filesReadAndWrite.Settings;

public class ActionItemTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Settings.getInstance().setStartSettings();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWish() {
		ActionItem actionItem = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES), 10, 13, true);
		assertThat(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES), equalTo(actionItem.getWish()));
	}

	@Test
	public void testGetStartPointInMinutes() {
		ActionItem actionItem = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES), 10, 13, true);
		assertThat(10, equalTo(actionItem.getStartPointInMinutes()));
	}

	@Test
	public void testGetEndPointInMinutes() {
		ActionItem actionItem = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES), 10, 13, true);
		assertThat(13, equalTo(actionItem.getEndPointInMinutes()));
	}

	@Test
	public void testContructor() {
		ActionItem actionItem = new ActionItem(WishTypesCreator.getInstance().getWish(WishTypesCreator.INDEX_WISH_DOWN_KNEES), 10, true, 60);
		
		assertThat(46, equalTo(actionItem.getEndPointInMinutes()));
	}

}
