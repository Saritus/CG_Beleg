package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import math.Vektor2D;
import math.Vektor3D;
import objekte.AlphaObjekt;
import objekte.SchwarmObjekt;
import program.ObjektManager;

public class TestSchwarmObjekt {

	SchwarmObjekt so1, so2, so3;
	AlphaObjekt ao1;

	@Before
	public void initObjects() {
		so1 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		so3 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		so1.calculateDistances();
		so2.calculateDistances();
		so3.calculateDistances();
		ao1 = new AlphaObjekt(new Vektor2D(), new Vektor2D(), 1);
	}

	@After
	public void deleteObjects() {
		ObjektManager.getInstance().removeAll();
	}

	@Test
	public void testNearColor() {
		so2.setColor(new Vektor3D(0, 0.5, 1));
		so3.setColor(new Vektor3D(1, 1, 0));
		Assert.assertEquals(1., so1.getNearColor(Double.MAX_VALUE).getX(), 0.01);
		Assert.assertEquals(1.5, so1.getNearColor(Double.MAX_VALUE).getY(), 0.01);
		Assert.assertEquals(1., so1.getNearColor(Double.MAX_VALUE).getZ(), 0.01);
	}

	@Test
	public void testAlphaColor() {
		ao1.setColor(new Vektor3D(1, 0, 0.5));
		Assert.assertEquals(1., so1.getAlphaColor(Double.MAX_VALUE).getX(), 0.01);
		Assert.assertEquals(0., so1.getAlphaColor(Double.MAX_VALUE).getY(), 0.01);
		Assert.assertEquals(0.5, so1.getAlphaColor(Double.MAX_VALUE).getZ(), 0.01);
	}
}
