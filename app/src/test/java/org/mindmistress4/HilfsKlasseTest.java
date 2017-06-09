package org.mindmistress4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filesReadAndWrite.Settings;
import hilfsklassen.HilfsKlasse;
import hilfsklassen.ZZGenerator;

public class HilfsKlasseTest {

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
	public void testGetTimepointsBorderCases() {
		ArrayList<Integer> result0 = HilfsKlasse.getTimepoints(new ZZGenerator(true), -3, 5);
		assertThat(result0, is(equalTo(null)));

		ArrayList<Integer> result1 = HilfsKlasse.getTimepoints(new ZZGenerator(true), 30, -5);
		assertThat(result1, is(equalTo(null)));
		
		ArrayList<Integer> result2 = HilfsKlasse.getTimepoints(new ZZGenerator(true), 0, 1);
		assertThat(result2, is(equalTo(null)));
		
		ArrayList<Integer> result3 = HilfsKlasse.getTimepoints(new ZZGenerator(true), 0, 0);
		assertThat(result3, is(equalTo(null)));

		ArrayList<Integer> result4 = HilfsKlasse.getTimepoints(new ZZGenerator(true), 10, 5);
		assertThat(result4, is(equalTo(null)));
	}
	
	@Test
	public void testGetTimepoints0() {
		ArrayList<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(0);
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 1, 1);
		assertThat(result, is(equalTo(expectedResult)));
	}
	
	
	@Test
	public void testGetTimepoints1() {
		ArrayList<Integer> expectedResult = new ArrayList<Integer>();
		expectedResult.add(0);
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 1, 5);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test
	public void testGetTimepoints2(){
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(0,21,41,46)); 
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 4, 60);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test
	public void testGetTimepoints3(){
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(0,1,2,3)); 
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 4, 4);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test
	public void testGetTimepoints4(){
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(0,21,41,46)); 
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 4, 60);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test
	public void testGetTimepoints5(){
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,11,13,14,15,16,17,18,19,20,21,27,29));
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 20, 30);
		assertThat(result, is(equalTo(expectedResult)));
	}

	@Test
	public void testGetTimepoints6(){
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(0,20,34,40,53,79));
		ArrayList<Integer> result = HilfsKlasse.getTimepoints(new ZZGenerator(true), 6, 90);
		assertThat(result, is(equalTo(expectedResult)));
	}

}
