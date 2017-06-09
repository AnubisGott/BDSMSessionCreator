package org.mindmistress4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

import bitsAndBytes.wishes.WishDurationType;
import bitsAndBytes.wishes.WishSingleOrderType;
import bitsAndBytes.wishes.WishWholeSessionDuration;
import filesReadAndWrite.Settings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class SettingsTest {

	@Before
	public void setUp() throws Exception {
		Settings.getInstance().setStartSettings();
	}


	@Test
	public void testInitState() {
		Settings testSettings = Settings.getInstance();
		
		assertThat(testSettings.getWishSetting( 0), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 1), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 2), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 3), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 4), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 5), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 6), equalTo(new Boolean(true)));

		assertThat(testSettings.getWishSetting( 7), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting( 8), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting( 9), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(10), equalTo(new Boolean(false)));

		assertThat(testSettings.getWishSetting(11), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(12), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(13), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(14), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(15), equalTo(new Boolean(true)));

		assertThat(testSettings.getWishSetting(16), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(17), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(18), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(19), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(20), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(21), equalTo(new Boolean(false)));

		assertThat(testSettings.getWishSetting(22), equalTo(new Boolean(true)));

		assertThat(testSettings.getWishSetting(23), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(24), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(25), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(26), equalTo(new Boolean(false)));

		assertThat(testSettings.getLevel(), equalTo(Settings.START_LEVEL));
	}

	@Test
	public void testSaveSettings() {
		Settings.getInstance().saveSettings(null);
		
		Settings.getInstance().disableWish(0);
		Settings.getInstance().disableWish(1);
		Settings.getInstance().disableWish(2);
		Settings.getInstance().disableWish(3);
		Settings.getInstance().enableWish(4);
		Settings.getInstance().enableWish(5);
		
		Settings.getInstance().loadSettings(null);
		
		assertThat(Settings.getInstance().getLevel(), equalTo(Settings.START_LEVEL));

		assertThat(Settings.getInstance().getWishSetting( 0), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 1), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 2), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 3), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 4), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 5), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 6), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting( 7), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting( 8), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting( 9), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(10), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(11), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting(12), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting(13), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting(14), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting(15), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting(16), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(17), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(18), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(19), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(20), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(21), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(22), equalTo(new Boolean(true)));
		assertThat(Settings.getInstance().getWishSetting(23), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(24), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(25), equalTo(new Boolean(false)));
		assertThat(Settings.getInstance().getWishSetting(25), equalTo(new Boolean(false)));
	}

	// @Test(expected = java.io.FileNotFoundException.class)
	@Test
	public void testLoadSettingsWithoutFile() {
		Settings testSettings = Settings.getInstance();
		testSettings.saveSettings(null);

		File file = new File(Settings.settingsFileName);
		file.delete();

		testSettings.loadSettings(null);
		
		assertThat(testSettings.getLevel(), equalTo(Settings.START_LEVEL));


		assertThat(testSettings.getWishSetting( 0), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 1), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 2), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 3), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 4), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 5), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting( 6), equalTo(new Boolean(true)));

		assertThat(testSettings.getWishSetting( 7), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting( 8), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting( 9), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(10), equalTo(new Boolean(false)));

		assertThat(testSettings.getWishSetting(11), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(12), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(13), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(14), equalTo(new Boolean(true)));
		assertThat(testSettings.getWishSetting(15), equalTo(new Boolean(true)));

		assertThat(testSettings.getWishSetting(16), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(17), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(18), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(19), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(20), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(21), equalTo(new Boolean(false)));

		assertThat(testSettings.getWishSetting(22), equalTo(new Boolean(true)));

		assertThat(testSettings.getWishSetting(23), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(24), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(25), equalTo(new Boolean(false)));
		assertThat(testSettings.getWishSetting(26), equalTo(new Boolean(false)));

	}
	
	@Test
	public void testEnableSettings() {
		Settings.getInstance().enableWish(-1);
		Settings.getInstance().enableWish(10000);

		Settings.getInstance().disableWish(-1);
		Settings.getInstance().disableWish(10000);
		
		Settings.getInstance().getWishSetting(-1);
		Settings.getInstance().getWishSetting(10000);
		
	}
	
}


