package test;

import org.junit.Assert;
import org.junit.Test;

import math.Function;
import math.Vektor3D;

public class TestFunction {
	@Test
	public void testGetColorFromChar() {
		Assert.assertTrue(Function.getColorFromChar('r').isEqual(new Vektor3D(1, 0, 0)));
		Assert.assertTrue(Function.getColorFromChar('g').isEqual(new Vektor3D(0, 1, 0)));
		Assert.assertTrue(Function.getColorFromChar('b').isEqual(new Vektor3D(0, 0, 1)));
	}
}
