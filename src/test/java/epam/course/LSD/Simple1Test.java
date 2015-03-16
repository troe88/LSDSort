package epam.course.LSD;

import junit.framework.TestCase;

import java.util.Arrays;

import epam.course.Helper.Helper;
import junit.framework.Test;
import junit.framework.TestSuite;

public class Simple1Test extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public Simple1Test(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(Simple1Test.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int in[] = {5, 3, 4, 1, 2};
		int out[] = {1, 2, 3, 4, 5};
		
		long start = System.currentTimeMillis();
		epam.course.LSD.LSD.sort(in);
		long end = System.currentTimeMillis();
		Helper.print("SIMPLE",end - start, in.length);
		
		assertTrue(Arrays.equals(in, out));
	}
}

