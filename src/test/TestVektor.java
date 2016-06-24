package test;

import org.junit.*;
import math.*;

public class TestVektor {

	@Test
	public void testGetDimension() {
		// Test for Vektor2D
		Vektor2D v2d = new Vektor2D();
		Assert.assertEquals(v2d.getDimension(), 2);

		// Test for Vektor3D
		Vektor3D v3d = new Vektor3D();
		Assert.assertEquals(v3d.getDimension(), 3);
	}

	@Test
	public void testGetArray() {
		// Test for Vektor2D
		double[] expecteds = { 2, 3 };
		Vektor2D v2d = new Vektor2D(expecteds);
		Assert.assertArrayEquals(expecteds, v2d.getArray(), 0.01);

		// Test for Vektor3D
		expecteds = new double[] { 2, 3, 5 };
		Vektor3D v3d = new Vektor3D(expecteds);
		Assert.assertArrayEquals(expecteds, v3d.getArray(), 0.01);
	}

	@Test
	public void testGetElemPositive() {
		// Test for Vektor2D
		Vektor2D v2d = new Vektor2D(2, 3);
		Assert.assertEquals(2, v2d.getElem(0), 0.01);
		Assert.assertEquals(3, v2d.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3d = new Vektor3D(2, 3, 5);
		Assert.assertEquals(2, v3d.getElem(0), 0.01);
		Assert.assertEquals(3, v3d.getElem(1), 0.01);
		Assert.assertEquals(5, v3d.getElem(2), 0.01);
	}

	@Test
	public void testGetElemNegative() {
		// Test for Vektor2D
		Vektor2D v2d = new Vektor2D(2, 3);
		try {
			// Negative OutOfBounds
			v2d.getElem(-1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Invalid dimension", e.getMessage());
		}
		try {
			// Positive OutOfBounds
			v2d.getElem(4);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Invalid dimension", e.getMessage());
		}

		// Test for Vektor3D
		Vektor3D v3d = new Vektor3D(2, 3, 5);
		try {
			// Negative OutOfBounds
			v3d.getElem(-1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Invalid dimension", e.getMessage());
		}
		try {
			// Positive OutOfBounds
			v3d.getElem(5);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Invalid dimension", e.getMessage());
		}
	}

	@Test
	public void testSetPositionPositive() {
		// Test for Vektor2D
		Vektor2D v2d = new Vektor2D();
		double[] expecteds = { 2., 3. };
		v2d.setPosition(expecteds);
		Assert.assertArrayEquals(expecteds, v2d.getArray(), 0.01);

		// Test for Vektor3D
		Vektor3D v3d = new Vektor3D();
		expecteds = new double[] { 2., 3., 5. };
		v3d.setPosition(expecteds);
		Assert.assertArrayEquals(expecteds, v3d.getArray(), 0.01);
	}

	@Test
	public void testSetPositionNegative() {
		// Test for Vektor2D
		try {
			Vektor2D v2d = new Vektor2D();
			v2d.setPosition(2, 3, 5);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Array does not have the right length", e.getMessage());
		}

		// Test for Vektor3D
		try {
			Vektor3D v3d = new Vektor3D();
			v3d.setPosition(new double[] { 2, 3, 5, 9 });
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Array does not have the right length", e.getMessage());
		}
	}

	@Test
	public void testIsNullVector() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(0, 0);
		Vektor2D v2 = new Vektor2D(0, 3);
		if (!v1.isNullVector()) {
			Assert.fail();
		}
		if (v2.isNullVector()) {
			Assert.fail();
		}

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(0, 0, 0);
		Vektor3D v4 = new Vektor3D(1, 1, 2);
		if (!v3.isNullVector()) {
			Assert.fail();
		}
		if (v4.isNullVector()) {
			Assert.fail();
		}
	}

	@Test
	public void testAddPositive() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(2, 3);
		Vektor2D v2 = new Vektor2D(5, 7);
		v1.add(v2);
		Assert.assertEquals(7, v1.getElem(0), 0.01);
		Assert.assertEquals(10, v1.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(2, 3, 11);
		Vektor3D v4 = new Vektor3D(5, 7, 13);
		v3.add(v4);
		Assert.assertEquals(7, v3.getElem(0), 0.01);
		Assert.assertEquals(10, v3.getElem(1), 0.01);
		Assert.assertEquals(24, v3.getElem(2), 0.01);
	}

	@Test
	public void testAddNegative() {
		// Test for Vektor2D
		try {
			// Positive Overflow
			Vektor2D v1 = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
			Vektor2D v2 = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
			v1.add(v2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Positive double overflow", e.getMessage());
		}
		try {
			// Negative Overflow
			Vektor2D v1 = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
			Vektor2D v2 = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
			v1.add(v2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Negative double overflow", e.getMessage());
		}

		// Test for Vektor3D
		try {
			// Positive Overflow
			Vektor3D v1 = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
			Vektor3D v2 = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
			v1.add(v2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Positive double overflow", e.getMessage());
		}
		try {
			// Negative Overflow
			Vektor3D v1 = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
			Vektor3D v2 = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
			v1.add(v2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Negative double overflow", e.getMessage());
		}
	}

	@Test
	public void testSub() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(2, 3);
		Vektor2D v2 = new Vektor2D(5, 7);
		v1.sub(v2);
		Assert.assertEquals(-3, v1.getElem(0), 0.01);
		Assert.assertEquals(-4, v1.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(2, 3, 11);
		Vektor3D v4 = new Vektor3D(5, 7, 13);
		v3.sub(v4);
		Assert.assertEquals(-3, v3.getElem(0), 0.01);
		Assert.assertEquals(-4, v3.getElem(1), 0.01);
		Assert.assertEquals(-2, v3.getElem(2), 0.01);
	}

	@Test
	public void testMultPositive() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(2, 3);
		v1.mult(3);
		Assert.assertEquals(6, v1.getElem(0), 0.01);
		Assert.assertEquals(9, v1.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(2, 3, 11);
		v3.mult(4);
		Assert.assertEquals(8, v3.getElem(0), 0.01);
		Assert.assertEquals(12, v3.getElem(1), 0.01);
		Assert.assertEquals(44, v3.getElem(2), 0.01);
	}

	@Test
	public void testMultNegative() {
		// Test for Vektor2D
		try {
			// Positive Overflow
			Vektor2D v1 = new Vektor2D(Double.MAX_VALUE, Double.MAX_VALUE);
			v1.mult(2);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Positive double overflow", e.getMessage());
		}
		try {
			// Negative Overflow
			Vektor2D v1 = new Vektor2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
			v1.mult(3);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Negative double overflow", e.getMessage());
		}

		// Test for Vektor3D
		try {
			// Positive Overflow
			Vektor3D v1 = new Vektor3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
			v1.mult(3);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Positive double overflow", e.getMessage());
		}
		try {
			// Negative Overflow
			Vektor3D v1 = new Vektor3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
			v1.mult(4);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Negative double overflow", e.getMessage());
		}
	}

	@Test
	public void testDivPositive() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(6, 8);
		v1.div(2);
		Assert.assertEquals(3, v1.getElem(0), 0.01);
		Assert.assertEquals(4, v1.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(6, 9, 12);
		v2.div(3);
		Assert.assertEquals(2, v2.getElem(0), 0.01);
		Assert.assertEquals(3, v2.getElem(1), 0.01);
		Assert.assertEquals(4, v2.getElem(2), 0.01);
	}

	@Test(expected = Exception.class)
	public void testDivNegative() {
		Vektor2D v1 = new Vektor2D(6, 8);
		v1.div(0);
	}

	@Test
	public void testIsEqual() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(1, 2);
		Vektor2D v3 = new Vektor2D(2, 3);
		if (!v1.isEqual(v2)) {
			Assert.fail();
		}
		if (v1.isEqual(v3)) {
			Assert.fail();
		}

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, 2, 4);
		Vektor3D v5 = new Vektor3D(1, 2, 4);
		Vektor3D v6 = new Vektor3D(2, 3, 6);
		if (!v4.isEqual(v5)) {
			Assert.fail();
		}
		if (v4.isEqual(v6)) {
			Assert.fail();
		}
	}

	@Test
	public void testIsNotEqual() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(1, 2);
		Vektor2D v3 = new Vektor2D(2, 3);
		if (v1.isNotEqual(v2)) {
			Assert.fail();
		}
		if (!v1.isNotEqual(v3)) {
			Assert.fail();
		}

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, 2, 4);
		Vektor3D v5 = new Vektor3D(1, 2, 4);
		Vektor3D v6 = new Vektor3D(2, 3, 6);
		if (v4.isNotEqual(v5)) {
			Assert.fail();
		}
		if (!v4.isNotEqual(v6)) {
			Assert.fail();
		}
	}

	@Test
	public void testLength() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(2, 2);
		Assert.assertEquals(Math.sqrt(8), v1.length(), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(2, 2, 3);
		Assert.assertEquals(Math.sqrt(17), v2.length(), 0.01);
	}

	@Test
	public void testLengthsquare() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(2, 2);
		Assert.assertEquals(8, v1.lengthsquare(), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(2, 2, 3);
		Assert.assertEquals(17, v2.lengthsquare(), 0.01);
	}

	@Test
	public void testNormalizePositive() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(0, 3);
		v1.normalize();
		Assert.assertEquals(0, v1.getElem(0), 0.01);
		Assert.assertEquals(1, v1.getElem(1), 0.01);
		Assert.assertEquals(1, v1.length(), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(1, 2, 2);
		v2.normalize();
		Assert.assertEquals(1. / 3., v2.getElem(0), 0.01);
		Assert.assertEquals(2. / 3., v2.getElem(1), 0.01);
		Assert.assertEquals(2. / 3., v2.getElem(2), 0.01);
		Assert.assertEquals(1, v2.length(), 0.01);
	}

	@Test
	public void testNormalizeNegative() {
		// Test for Vektor2D
		try {
			Vektor2D v1 = new Vektor2D(0, 0);
			v1.normalize();
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nullvector cannot be normalized", e.getMessage());
		}

		// Test for Vektor3D
		try {
			Vektor3D v2 = new Vektor3D(0, 0, 0);
			v2.normalize();
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nullvector cannot be normalized", e.getMessage());
		}
	}

	@Test
	public void testNegate() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(2, 3);
		v1.negate();
		Assert.assertEquals(-2, v1.getElem(0), 0.01);
		Assert.assertEquals(-3, v1.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(2, 3, -4);
		v2.negate();
		Assert.assertEquals(-2, v2.getElem(0), 0.01);
		Assert.assertEquals(-3, v2.getElem(1), 0.01);
		Assert.assertEquals(4, v2.getElem(2), 0.01);
	}

	@Test
	public void testClone() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = v1.clone();
		Assert.assertEquals(1, v2.getElem(0), 0.01);
		Assert.assertEquals(2, v2.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(1, 2, -4);
		Vektor3D v4 = v3.clone();
		Assert.assertEquals(1, v4.getElem(0), 0.01);
		Assert.assertEquals(2, v4.getElem(1), 0.01);
		Assert.assertEquals(-4, v4.getElem(2), 0.01);
	}

	@Test
	public void testAbs() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(-1, -2);
		v1.abs();
		Assert.assertEquals(1, v1.getElem(0), 0.01);
		Assert.assertEquals(2, v1.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(-1, 2, -4);
		v2.abs();
		Assert.assertEquals(1, v2.getElem(0), 0.01);
		Assert.assertEquals(2, v2.getElem(1), 0.01);
		Assert.assertEquals(4, v2.getElem(2), 0.01);
	}

	@Test
	public void testToString() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(-1, -2);
		Vektor2D v2 = new Vektor2D(-1.333, Math.PI);
		Assert.assertEquals("( -1.0, -2.0 )", v1.toString());
		Assert.assertEquals("( -1.333, 3.141592653589793 )", v2.toString());

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(-1, -2, 7);
		Vektor3D v4 = new Vektor3D(-1.333, Math.PI, Math.E);
		Assert.assertEquals("( -1.0, -2.0, 7.0 )", v3.toString());
		Assert.assertEquals("( -1.333, 3.141592653589793, 2.718281828459045 )", v4.toString());
	}
}
