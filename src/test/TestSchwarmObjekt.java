package test;

import org.junit.Assert;
import org.junit.Test;

import math.Vektor2D;
import math.Vektor3D;
import objekte.AlphaObjekt;
import objekte.SchwarmObjekt;

public class TestSchwarmObjekt {
	@Test
	public void testNearColor() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(1, 0), new Vektor2D(), 1);
		so2.setColor(new Vektor3D(0, 0.5, 1));
		SchwarmObjekt so3 = new SchwarmObjekt(new Vektor2D(1, 0), new Vektor2D(), 1);
		so3.setColor(new Vektor3D(1, 1, 0));
		so1.calculateDistances();
		so2.calculateDistances();
		so3.calculateDistances();
		Assert.assertEquals(1., so1.getNearColor(Double.MAX_VALUE).getX(), 0.01);
		Assert.assertEquals(1.5, so1.getNearColor(Double.MAX_VALUE).getY(), 0.01);
		Assert.assertEquals(1., so1.getNearColor(Double.MAX_VALUE).getZ(), 0.01);
	}

	@Test
	public void testAlphaColor() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		AlphaObjekt ao1 = new AlphaObjekt(new Vektor2D(), new Vektor2D(), 1);
		ao1.setColor(new Vektor3D(1, 0, 0.5));
		Assert.assertEquals(1., so1.getAlphaColor(Double.MAX_VALUE).getX(), 0.01);
		Assert.assertEquals(0., so1.getAlphaColor(Double.MAX_VALUE).getY(), 0.01);
		Assert.assertEquals(0.5, so1.getAlphaColor(Double.MAX_VALUE).getZ(), 0.01);
	}
}
