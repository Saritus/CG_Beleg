package test;

import org.junit.Assert;
import org.junit.Test;

import math.Vektor2D;
import verhalten.AlphaObjekt;
import verhalten.HindernisObjekt;
import verhalten.ObjektManager;
import verhalten.SchwarmObjekt;
import verhalten.SchwarmVerhalten;

public class TestBasisVerhalten {
	@Test
	public void testGetCohesion() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(15, 10), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		SchwarmVerhalten sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(-5.125, sv1.getCohesion(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(-3.42, sv1.getCohesion(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetAlignment() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(15, 10), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		SchwarmVerhalten sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(4.75, sv1.getAlignment(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(3.17, sv1.getAlignment(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetSeparation() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(15, 10), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		SchwarmVerhalten sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(0.09, sv1.getSeparation(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(0.06, sv1.getSeparation(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetObstacleSeparation() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(15, 10), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		HindernisObjekt ho = new HindernisObjekt(5, 5);
		ObjektManager.getInstance().add(ho);
		SchwarmVerhalten sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(0.08, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(0.04, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetAlphaCohesion() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(15, 10), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		AlphaObjekt ao1 = new AlphaObjekt(new Vektor2D(), new Vektor2D(), 1);
		ObjektManager.getInstance().add(ao1);
		SchwarmVerhalten sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		Assert.assertEquals(0, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(0, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetForce() {
		SchwarmObjekt so1 = new SchwarmObjekt(new Vektor2D(15, 10), new Vektor2D(), 1);
		SchwarmObjekt so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(), 1);
		so1.calculateDistances();
		so2.calculateDistances();
		so1.getBehavior().update();
		Assert.assertEquals(43.5, so1.getPos().getX(), 0.01);
		Assert.assertEquals(29., so1.getPos().getY(), 0.01);
		Assert.assertEquals(28.5, so1.getSpeed().getX(), 0.01);
		Assert.assertEquals(19., so1.getSpeed().getY(), 0.01);
	}
}
