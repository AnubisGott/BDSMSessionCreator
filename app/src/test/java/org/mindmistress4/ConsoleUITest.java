package org.mindmistress4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bitsAndBytes.consoleui.ConsoleUI;
import filesReadAndWrite.Settings;

public class ConsoleUITest {

	@Before
	public void setUp() throws Exception {
		Settings.getInstance().setStartSettings();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String[] args = { "runInTestMode" };
		ConsoleUI.main(args);
	}

}
