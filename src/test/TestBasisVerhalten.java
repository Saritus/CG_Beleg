package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import math.Vektor2D;
import objekte.AlphaObjekt;
import objekte.HindernisObjekt;
import objekte.SchwarmObjekt;
import verhalten.ObjektManager;
import verhalten.SchwarmVerhalten;

public class TestBasisVerhalten {

	SchwarmObjekt so1, so2;
	SchwarmVerhalten sv1;
	HindernisObjekt ho;
	AlphaObjekt ao1;

	@Before
	public void initObjects() {
		so1 = new SchwarmObjekt(new Vektor2D(10, 10), new Vektor2D(10, 10), 1);
		so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(10, 10), 1);
		sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		ho = new HindernisObjekt(5, 5);
		ObjektManager.getInstance().add(ho);
		ao1 = new AlphaObjekt(new Vektor2D(), new Vektor2D(), 1);
	}

	@After
	public void deleteObjects() {
		ObjektManager.getInstance().removeAll();
	}

	@Test
	public void testGetCohesion() {
		Assert.assertEquals(-5., sv1.getCohesion(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(-5, sv1.getCohesion(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetAlignment() {
		Assert.assertEquals(10., sv1.getAlignment(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(10., sv1.getAlignment(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetSeparation() {
		Assert.assertEquals(0.025, sv1.getSeparation(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(0.025, sv1.getSeparation(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetObstacleSeparation() {
		Assert.assertEquals(0.1, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(0.1, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetAlphaCohesion() {
		Assert.assertEquals(0.1, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(0), 0.01);
		Assert.assertEquals(0.1, sv1.getObstacleSeparation(Double.MAX_VALUE).getElem(1), 0.01);
	}

	@Test
	public void testGetForce() {
		so1.update();
		Assert.assertEquals(228., so1.getPos().getX(), 0.01);
		Assert.assertEquals(228., so1.getPos().getY(), 0.01);
		Assert.assertEquals(3290., so1.getSpeed().getX(), 0.01);
		Assert.assertEquals(3290., so1.getSpeed().getY(), 0.01);
	}
}
