package epam.course.LSD;

import java.util.Arrays;

import epam.course.Helper.Helper;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class OneThousandTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public OneThousandTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(OneThousandTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int length = 1000;
		epam.course.LSD.LSD.setMax(length);
		int in[] = new int [length];
		int out[] = new int[in.length];
		long end, start;
		long time_lsd, time_sys;
		
		epam.course.LSD.LSD.genRandArray(in, false);
		System.arraycopy(in, 0, out, 0, length);
		
		start = System.currentTimeMillis();
		Arrays.sort(out);
		end = System.currentTimeMillis();
		time_sys = end - start;
		
		start = System.currentTimeMillis();
		epam.course.LSD.LSD.sort(in);
		end = System.currentTimeMillis();
		time_lsd = end - start;
		
		Helper.print("QQQ " + getClass().getName(), time_lsd, time_sys, length);
		
		assertTrue(Arrays.equals(in, out));
	}
}
