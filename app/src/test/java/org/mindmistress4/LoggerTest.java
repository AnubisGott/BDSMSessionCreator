package org.mindmistress4;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filesReadAndWrite.Settings;
import hilfsklassen.Logger;

public class LoggerTest {

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
	public void testSetLogLevel() {
		Logger.setLogLevel(Logger.all);
		Logger.setLogLevel(Logger.info);
	}

	@Test
	public void testLogIntStringClassOfQ() {
		Logger.log(Logger.debug, "testLogIntStringClassOfQ", this.getClass());
	}

	@Test
	public void testLogIntString() {
		Logger.log(Logger.all, "testLogIntString", this.getClass());
	}

	@Test
	public void testLogIntStringString() {
		Logger.log(Logger.severe, this.getClass().getSimpleName(), this.getClass());
	}

	@Test
	public void testLog2() {
		Logger.log(new FileNotFoundException());
	}
		
	@Test
	public void log3() {
		Logger.log(Logger.severe, "logMessage", Logger.class);
	}
	
	@Test
	public void log4() {
		Logger.log (Logger.all, "logMessage", "");
	}
	
	@Test
	public void log5() {
		Logger.log(Logger.all, "logMessage", Logger.class, new FileNotFoundException());
	}
	
	@Test
	public void log6() {
		Logger.log(-1, "logMessage", Logger.class, new FileNotFoundException());
	}
	
	@Test
	public void log7() {
		Logger.log(100, "logMessage", Logger.class, new FileNotFoundException());
	}
	

}
