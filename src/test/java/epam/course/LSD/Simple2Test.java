package epam.course.LSD;

import java.util.Arrays;

import epam.course.Helper.Helper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class Simple2Test extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public Simple2Test(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(Simple2Test.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int in[] =  {3, 2, 1, -2, -3, -1};
		int out[] = {-3, -2, -1, 1, 2, 3};
		
		long start = System.currentTimeMillis();
		epam.course.LSD.LSD.sort(in);
		long end = System.currentTimeMillis();
		Helper.print("SIMPLE",end - start, in.length);

		
		assertTrue(Arrays.equals(in, out));
	}
}
