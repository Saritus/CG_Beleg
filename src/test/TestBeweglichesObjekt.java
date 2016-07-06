package test;

import org.junit.Assert;
import org.junit.Test;

import math.Vektor2D;
import objekte.SchwarmObjekt;

public class TestBeweglichesObjekt {
	@Test
	public void testCalculateDistances() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(1, 0), new Vektor2D(), 1);
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(19., so1.getAbstand()[0], 0.01);
		Assert.assertEquals(20., so1.getAbstand()[1], 0.01);
		Assert.assertEquals(18., so2.getAbstand()[0], 0.01);
		Assert.assertEquals(19., so2.getAbstand()[1], 0.01);
	}

	@Test
	public void testEulerMethod() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(5, 5), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(10, 10), new Vektor2D(), 1);
		so1.eulerMethod(new Vektor2D(5, 4));
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(0., so1.getAbstand()[0], 0.01);
		Assert.assertEquals(1., so1.getAbstand()[1], 0.01);
		Assert.assertEquals(1., so2.getAbstand()[0], 0.01);
		Assert.assertEquals(0., so2.getAbstand()[1], 0.01);
	}
}
