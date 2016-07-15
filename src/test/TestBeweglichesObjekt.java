package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import math.Vektor2D;
import objekte.SchwarmObjekt;
import verhalten.ObjektManager;

public class TestBeweglichesObjekt {

	SchwarmObjekt so1, so2;

	@Before
	public void initObjects() {
		so1 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		so2 = new SchwarmObjekt(new Vektor2D(1, 1), new Vektor2D(), 1);
		so1.calculateDistances();
		so2.calculateDistances();
	}

	@After
	public void deleteObjects() {
		ObjektManager.getInstance().removeAll();
	}

	@Test
	public void testCalculateDistances() {
		Assert.assertEquals(0., so1.getAbstand()[0], 0.01);
		Assert.assertEquals(2., so1.getAbstand()[1], 0.01);
		Assert.assertEquals(2., so2.getAbstand()[0], 0.01);
		Assert.assertEquals(0., so2.getAbstand()[1], 0.01);
	}

	@Test
	public void testEulerMethod() {
		so1.eulerMethod(new Vektor2D(5, 4));
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(0., so1.getAbstand()[0], 0.01);
		Assert.assertEquals(7., so1.getAbstand()[1], 0.01);
		Assert.assertEquals(7., so2.getAbstand()[0], 0.01);
		Assert.assertEquals(0., so2.getAbstand()[1], 0.01);
	}
}
