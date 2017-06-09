package org.mindmistress4;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.crypto.spec.SecretKeySpec;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filesReadAndWrite.CryptUtil;
import filesReadAndWrite.Settings;
import filesReadAndWrite.WriteAndReadFileUtil;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class WriteAndReadUtilTest {

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
	public void testWriteAndReadFileTest() {
		SecretKeySpec key = CryptUtil.getKey();
		if(key == null) fail();
		
		String inhalt1 = "101011101101022";     
		WriteAndReadFileUtil.writeStringToFile(Settings.settingsFileName, inhalt1, null);
		
		String inhalt2 = "101011101101012";     
		WriteAndReadFileUtil.writeStringToFile(Settings.settingsFileName, inhalt2, null);
		
		String text = WriteAndReadFileUtil.readStringFromFile(Settings.settingsFileName, null);

		assertThat(inhalt2, is(equalTo(text)));
	}

	@Test
	public void testWriteAndReadFileTestWithEncryption() {
		SecretKeySpec key = CryptUtil.getKey();
		if(key == null) fail();
		
		String inhalt = "101011101101012";     
		String verschluesselt = CryptUtil.encryptText(inhalt, key);
		WriteAndReadFileUtil.writeStringToFile(Settings.settingsFileName, verschluesselt, null);

		String text = WriteAndReadFileUtil.readStringFromFile(Settings.settingsFileName, null);
		String entschluesselt = CryptUtil.decryptText(text, key);

		assertThat(inhalt, is(equalTo(entschluesselt)));
	}

}
