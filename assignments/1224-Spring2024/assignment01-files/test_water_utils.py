import unittest

from water_utils import get_remaining_water
from water_utils import average_rainfall

class WaterUtilsUnitTests(unittest.TestCase):
    """
    Unit testing suite for the `water_utils` module.
    """

    tolerance = 0.001

    def is_close(a, b, tolerance):
        """
        Utility method to determine if two values are close (within the
        specified `tolerance` in absolute value).  The arguments `a` and
        `b` can be either single numeric values or lists of numbers (which
        must be the same size).
        """
        if isinstance(a, (float, int)) and isinstance(b, (float, int)):
            return (abs(a-b) <= tolerance)
        elif isinstance(a, list) and isinstance(b, list):
            if len(a) != len(b): return False
            for i in range( len(a) ):
                if not isinstance(a[i], (float, int)) or not isinstance(b[i], (float, int)): return False
                if abs(a[i]-b[i]) > tolerance:
                    return False
            return True
        else:
            return False

    def test_get_remaining_water_001(self):
        limit = 10.0
        list_handout = [3.5, 8.5, 10.0, 0.0, 20.0]
        expected = [6.5, 1.5, 0.0, 10.0, 0.0]
        actual = get_remaining_water(limit, list_handout)
        self.assertTrue( WaterUtilsUnitTests.is_close(expected, actual, self.tolerance) )

    def test_get_remaining_water_002(self):
        limit    = 5.0
        usage    = [0.0, 1.0, 2.0, 3.0, 4.0, 5.0]
        expected = [5.0, 4.0, 3.0, 2.0, 1.0, 0.0]
        actual = get_remaining_water(limit, usage)
        self.assertTrue( WaterUtilsUnitTests.is_close(expected, actual, self.tolerance) )

    def test_get_remaining_water_003(self):
        limit    = 7.0
        usage    = [7.5, 8.75, 7.0001, 7.0, 1000.0]
        expected = [0.0, 0.0, 0.0, 0.0, 0.0]
        actual = get_remaining_water(limit, usage)
        self.assertTrue( WaterUtilsUnitTests.is_close(expected, actual, self.tolerance) )

    #TODO: add 2 more non-trivial test cases of your own for get_remaining_water

    def test_average_rainfall_001(self):
        map_handout = [
          [ 0.75, 0.50, 0.00, -1.00, 0.10 ],
          [ 1.00, 0.25, 0.125, 0.00, -5.0 ],
          [ 1.25, 0.50, -1.0,  0.10, 2.75 ],
        ]
        expected = 0.610
        actual = average_rainfall(map_handout)
        self.assertTrue( WaterUtilsUnitTests.is_close(expected, actual, self.tolerance) )

    def test_average_rainfall_002(self):
        map = [
          [ -1.00, -2.00 ],
          [ -1.25, -2.75 ],
        ]
        expected = 0.0
        actual = average_rainfall(map)
        self.assertTrue( WaterUtilsUnitTests.is_close(expected, actual, self.tolerance), msg = f"expected: {expected}, actual: {actual}" )

    def test_average_rainfall_003(self):
        map = [
          [ 1.00, 2.00 ],
	  [ 1.25, 2.25 ],
	  [ 1.50, 2.50 ],
        ]
        expected = 1.75
        actual = average_rainfall(map)
        self.assertTrue( WaterUtilsUnitTests.is_close(expected, actual, self.tolerance), msg = f"expected: {expected}, actual: {actual}" )

    #TODO: add 2 more non-trivial test cases of your own for average_rainfall

if __name__ == '__main__':
    #buffer=True suppresses stdout
    unittest.main(buffer=True)
