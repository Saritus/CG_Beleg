package test;

import org.junit.Assert;
import org.junit.Test;
import math.*;

public class TestLineareAlgebra {

	@Test
	public void testIsEqual() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(1, 2);
		Vektor2D v3 = new Vektor2D(3, 4);
		if (!LineareAlgebra.isEqual(v1, v2)) {
			Assert.fail();
		}
		if (LineareAlgebra.isEqual(v1, v3)) {
			Assert.fail();
		}

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, 2, 4);
		Vektor3D v5 = new Vektor3D(1, 2, 4);
		Vektor3D v6 = new Vektor3D(3, 4, 6);
		if (!LineareAlgebra.isEqual(v4, v5)) {
			Assert.fail();
		}
		if (LineareAlgebra.isEqual(v4, v6)) {
			Assert.fail();
		}
	}

	@Test
	public void testIsNotEqual() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(1, 2);
		Vektor2D v3 = new Vektor2D(3, 4);
		if (LineareAlgebra.isNotEqual(v1, v2)) {
			Assert.fail();
		}
		if (!LineareAlgebra.isNotEqual(v1, v3)) {
			Assert.fail();
		}

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, 2, 4);
		Vektor3D v5 = new Vektor3D(1, 2, 4);
		Vektor3D v6 = new Vektor3D(3, 4, 6);
		if (LineareAlgebra.isNotEqual(v4, v5)) {
			Assert.fail();
		}
		if (!LineareAlgebra.isNotEqual(v4, v6)) {
			Assert.fail();
		}
	}

	@Test
	public void testAdd() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(3, 4);
		Vektor2D v3 = (Vektor2D) LineareAlgebra.add(v1, v2);
		Assert.assertEquals(4, v3.getElem(0), 0.01);
		Assert.assertEquals(6, v3.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, 2, 4);
		Vektor3D v5 = new Vektor3D(3, 4, 6);
		Vektor3D v6 = (Vektor3D) LineareAlgebra.add(v4, v5);
		Assert.assertEquals(4, v6.getElem(0), 0.01);
		Assert.assertEquals(6, v6.getElem(1), 0.01);
		Assert.assertEquals(10, v6.getElem(2), 0.01);
	}

	@Test
	public void testSub() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(3, 4);
		Vektor2D v3 = (Vektor2D) LineareAlgebra.sub(v1, v2);
		Assert.assertEquals(-2, v3.getElem(0), 0.01);
		Assert.assertEquals(-2, v3.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, 2, 7);
		Vektor3D v5 = new Vektor3D(3, 4, 6);
		Vektor3D v6 = (Vektor3D) LineareAlgebra.sub(v4, v5);
		Assert.assertEquals(-2, v6.getElem(0), 0.01);
		Assert.assertEquals(-2, v6.getElem(1), 0.01);
		Assert.assertEquals(1, v6.getElem(2), 0.01);
	}

	@Test
	public void testMult() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = (Vektor2D) LineareAlgebra.mult(v1, 2);
		Assert.assertEquals(2, v2.getElem(0), 0.01);
		Assert.assertEquals(4, v2.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(1, 2, 7);
		Vektor3D v4 = (Vektor3D) LineareAlgebra.mult(v3, 3);
		Assert.assertEquals(3, v4.getElem(0), 0.01);
		Assert.assertEquals(6, v4.getElem(1), 0.01);
		Assert.assertEquals(21, v4.getElem(2), 0.01);
	}

	@Test
	public void testDiv() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = (Vektor2D) LineareAlgebra.div(v1, 2);
		Assert.assertEquals(1. / 2., v2.getElem(0), 0.01);
		Assert.assertEquals(1, v2.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(1, 2, 7);
		Vektor3D v4 = (Vektor3D) LineareAlgebra.div(v3, 3);
		Assert.assertEquals(1. / 3., v4.getElem(0), 0.01);
		Assert.assertEquals(2. / 3., v4.getElem(1), 0.01);
		Assert.assertEquals(7. / 3., v4.getElem(2), 0.01);
	}

	@Test
	public void testNegate() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = (Vektor2D) LineareAlgebra.negate(v1);
		Assert.assertEquals(-1, v2.getElem(0), 0.01);
		Assert.assertEquals(-2, v2.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(1, -2, 7);
		Vektor3D v4 = (Vektor3D) LineareAlgebra.negate(v3);
		Assert.assertEquals(-1, v4.getElem(0), 0.01);
		Assert.assertEquals(2, v4.getElem(1), 0.01);
		Assert.assertEquals(-7, v4.getElem(2), 0.01);
	}

	@Test
	public void testLength() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Assert.assertEquals(Math.sqrt(5), v1.length(), 0.01);

		// Test for Vektor3D
		Vektor3D v2 = new Vektor3D(1, -2, 7);
		Assert.assertEquals(Math.sqrt(54), v2.length(), 0.01);
	}

	@Test
	public void testNormalize() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(0, 3);
		Vektor2D v2 = (Vektor2D) LineareAlgebra.normalize(v1);
		Assert.assertEquals(0, v2.getElem(0), 0.01);
		Assert.assertEquals(1, v2.getElem(1), 0.01);
		Assert.assertEquals(1, v2.length(), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(1, 2, 2);
		Vektor3D v4 = (Vektor3D) LineareAlgebra.normalize(v3);
		Assert.assertEquals(1. / 3., v4.getElem(0), 0.01);
		Assert.assertEquals(2. / 3., v4.getElem(1), 0.01);
		Assert.assertEquals(2. / 3., v4.getElem(2), 0.01);
		Assert.assertEquals(1, v4.length(), 0.01);
	}

	@Test
	public void testAbs() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(-3, -5);
		Vektor2D v2 = (Vektor2D) LineareAlgebra.abs(v1);
		Assert.assertEquals(3, v2.getElem(0), 0.01);
		Assert.assertEquals(5, v2.getElem(1), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(-3, -5, 7);
		Vektor3D v4 = (Vektor3D) LineareAlgebra.abs(v3);
		Assert.assertEquals(3, v4.getElem(0), 0.01);
		Assert.assertEquals(5, v4.getElem(1), 0.01);
		Assert.assertEquals(7, v4.getElem(2), 0.01);
	}

	@Test
	public void testDeterminante() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(3, 4);
		Assert.assertEquals(-2, LineareAlgebra.determinante(v1, v2), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(0, 3, 1);
		Vektor3D v4 = new Vektor3D(1, 2, 1);
		Vektor3D v5 = new Vektor3D(2, 1, 0);
		Assert.assertEquals(3, LineareAlgebra.determinante(v3, v4, v5), 0.01);
	}

	@Test
	public void testEuklDistance() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(3, 4);
		Assert.assertEquals(Math.sqrt(8), LineareAlgebra.euklDistance(v1, v2), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(4, 1, -2);
		Vektor3D v4 = new Vektor3D(2, 3, -1);
		Assert.assertEquals(3, LineareAlgebra.euklDistance(v3, v4), 0.01);
	}

	@Test
	public void testManhattenDistance() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(3, 4);
		Assert.assertEquals(4, LineareAlgebra.manhattanDistance(v1, v2), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(4, 1, -2);
		Vektor3D v4 = new Vektor3D(2, 3, -1);
		Assert.assertEquals(5, LineareAlgebra.manhattanDistance(v3, v4), 0.01);
	}

	@Test
	public void testDotProduct() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 2);
		Vektor2D v2 = new Vektor2D(3, 4);
		Assert.assertEquals(11, LineareAlgebra.dotProduct(v1, v2), 0.01);

		// Test for Vektor3D
		Vektor3D v3 = new Vektor3D(1, 2, 3);
		Vektor3D v4 = new Vektor3D(-7, 8, 9);
		Assert.assertEquals(36, LineareAlgebra.dotProduct(v3, v4), 0.01);
	}

	@Test
	public void testCrossProduct() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(1, 4);
		Vektor2D v2 = new Vektor2D(3, 4);
		Assert.assertEquals(8, LineareAlgebra.crossProduct(v1, v2).length(), 0.01);

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, -5, 10);
		Vektor3D v5 = new Vektor3D(2, 0, 20);
		Vektor3D v6 = (Vektor3D) LineareAlgebra.crossProduct(v4, v5);
		Assert.assertArrayEquals(new double[] { -100, 0, 10 }, v6.getArray(), 0.01);
	}

	@Test
	public void testCosEquation() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(0, 4);
		Vektor2D v2 = new Vektor2D(3, 0);
		Assert.assertEquals(0, LineareAlgebra.cosEquation(v1, v2), 0.0001);

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(1, -5, 10);
		Vektor3D v5 = new Vektor3D(2, 0, 20);
		Assert.assertEquals(0.8953140798, LineareAlgebra.cosEquation(v4, v5), 0.0001);
	}

	@Test
	public void testSinEquation() {
		// Test for Vektor2D
		Vektor2D v1 = new Vektor2D(0, 4);
		Vektor2D v2 = new Vektor2D(3, 0);
		Assert.assertEquals(1, LineareAlgebra.sinEquation(v1, v2), 0.0001);

		// Test for Vektor3D
		Vektor3D v4 = new Vektor3D(-10, 0, 10);
		Vektor3D v5 = new Vektor3D(2, 30, 0);
		Assert.assertEquals(0.998893192, LineareAlgebra.sinEquation(v4, v5), 0.0001);
	}

	@Test
	public void testAngleDegree() {
		Assert.assertEquals(30, LineareAlgebra.angleDegree(0.5, "sin"), 0.01);
		Assert.assertEquals(45, LineareAlgebra.angleDegree(1. / Math.sqrt(2), "sin"), 0.01);
		Assert.assertEquals(60, LineareAlgebra.angleDegree(0.5, "cos"), 0.01);
		Assert.assertEquals(45, LineareAlgebra.angleDegree(1. / Math.sqrt(2), "cos"), 0.01);
		Assert.assertEquals(45, LineareAlgebra.angleDegree(1, "tan"), 0.01);
	}

	@Test
	public void testAngleRad() {
		Assert.assertEquals(Math.PI / 6, LineareAlgebra.angleRad(0.5, "sin"), 0.01);
		Assert.assertEquals(Math.PI / 4, LineareAlgebra.angleRad(1. / Math.sqrt(2), "sin"), 0.01);
		Assert.assertEquals(Math.PI / 3, LineareAlgebra.angleRad(0.5, "cos"), 0.01);
		Assert.assertEquals(Math.PI / 4, LineareAlgebra.angleRad(1. / Math.sqrt(2), "cos"), 0.01);
		Assert.assertEquals(Math.PI / 4, LineareAlgebra.angleRad(1, "tan"), 0.01);
	}

	@Test
	public void testRadToDegree() {
		Assert.assertEquals(0, LineareAlgebra.radToDegree(0), 0.01);
		Assert.assertEquals(90, LineareAlgebra.radToDegree(Math.PI / 2), 0.01);
		Assert.assertEquals(180, LineareAlgebra.radToDegree(Math.PI), 0.01);
		Assert.assertEquals(270, LineareAlgebra.radToDegree(3 * Math.PI / 2), 0.01);
	}

	@Test
	public void testDegreeToRad() {
		Assert.assertEquals(0, LineareAlgebra.degreeToRad(0), 0.01);
		Assert.assertEquals(Math.PI / 2, LineareAlgebra.degreeToRad(90), 0.01);
		Assert.assertEquals(Math.PI, LineareAlgebra.degreeToRad(180), 0.01);
		Assert.assertEquals(3 * Math.PI / 2, LineareAlgebra.degreeToRad(270), 0.01);
	}
}
