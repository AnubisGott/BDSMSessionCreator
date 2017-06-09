package org.mindmistress4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filesReadAndWrite.Settings;
import hilfsklassen.ZZGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ZZGeneratorTest {
	private ZZGenerator zufallszahlen = null;
	private int i = 0;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		zufallszahlen = new ZZGenerator(true);
		Settings.getInstance().setStartSettings();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIntBordersIncluded() {
		i = zufallszahlen.getIntBordersIncluded(4, 6);
		assertThat(i, is(equalTo(4)));
		i = zufallszahlen.getIntBordersIncluded(4, 6);
		assertThat(i, is(equalTo(5)));
		i = zufallszahlen.getIntBordersIncluded(4, 6);
		assertThat(i, is(equalTo(5)));
		i = zufallszahlen.getIntBordersIncluded(4, 6);
		assertThat(i, is(equalTo(6)));
		
		i = zufallszahlen.getIntBordersIncluded(4, 4);
		assertThat(i, is(equalTo(4)));
		
		i = zufallszahlen.getIntBordersIncluded(4, 4);
		
		
	}

}
