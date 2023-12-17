package unl.soc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WaterUtilsTests {

	public static final double TOLERANCE = 0.001;

	/**
	 * Determines if the contents of the two given <code>List</code>s are all close.
	 * Lists must be the same size and each element must be within
	 * {@link #TOLERANCE} of each other.
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean isCloseLists(List<Double> a, List<Double> b) {
		if (a.size() != b.size()) {
			return false;
		}
		for (int i = 0; i < a.size(); i++) {
			if (Math.abs(a.get(i) - b.get(i)) > TOLERANCE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Tests {@link WaterUtils#getRemainingWater} with the input provided in the
	 * handout.
	 *
	 */
	@Test
	public void testRemainingWater001() {

		double limit = 10.0;
		List<Double> usage = Arrays.asList(3.5, 8.5, 10.0, 0.0, 20.0);

		List<Double> actual = WaterUtils.getRemainingWater(limit, usage);
		List<Double> expected = Arrays.asList(6.5, 1.5, 0.0, 10.0, 0.0);

		assertTrue(isCloseLists(actual, expected));

	}

	/**
	 * Tests {@link WaterUtils#getRemainingWater} with 6 values
	 *
	 */
	@Test
	public void testRemainingWater002() {

		double limit = 5.0;
		List<Double> usage = Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0);

		List<Double> actual = WaterUtils.getRemainingWater(limit, usage);
		List<Double> expected = Arrays.asList(5.0, 4.0, 3.0, 2.0, 1.0, 0.0);

		assertTrue(isCloseLists(actual, expected));

	}

	/**
	 * Tests {@link WaterUtils#getRemainingWater} with the input values that all
	 * exceed the limit.
	 *
	 */
	@Test
	public void testRemainingWater003() {

		double limit = 7.0;
		List<Double> usage = Arrays.asList(7.5, 8.75, 7.0001, 7.0, 1000.0);

		List<Double> actual = WaterUtils.getRemainingWater(limit, usage);
		List<Double> expected = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0);

		assertTrue(isCloseLists(actual, expected));

	}

	//TODO: add 2 more non-trivial test cases of your own for getRemainingWater

	/**
	 * Tests {@link WaterUtils#averageRainfall} with the input provided in the
	 * handout.
	 *
	 */
	@Test
	public void testAverageRainfall001() {

		double map[][] = {
				{ 0.75, 0.50, 0.00, -1.00, 0.10 },
				{ 1.00, 0.25, 0.125, 0.00, -5.0 },
				{ 1.25, 0.50, -1.0,  0.10, 2.75 },
		};

	    double actual = WaterUtils.averageRainfall(map);
	    double expected = 0.610;
	    assertEquals(expected, actual, TOLERANCE);

	}


	/**
	 * Tests {@link WaterUtils#averageRainfall} with no valid input values.
	 *
	 */
	@Test
	public void testAverageRainfall002() {

		double map[][] = {
				{ -1.0, -2.0 },
				{ -1.25, -2.75 },
		};

	    double actual = WaterUtils.averageRainfall(map);
	    double expected = 0.0;
	    assertEquals(expected, actual, TOLERANCE);

	}

	/**
	 * Tests {@link WaterUtils#averageRainfall} with all valid input values.
	 *
	 */
	@Test
	public void testAverageRainfall003() {

		double map[][] = {
				{ 1.00, 2.00 },
				{ 1.25, 2.25 },
				{ 1.50, 2.50 },
		};

	    double actual = WaterUtils.averageRainfall(map);
	    double expected = 1.75;
	    assertEquals(expected, actual, TOLERANCE);

	}

	//TODO: add 2 more non-trivial test cases of your own for averageRainfall

}
