package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import math.Vektor2D;
import objekte.AlphaObjekt;
import objekte.HindernisObjekt;
import objekte.SchwarmObjekt;
import program.ObjektManager;

public class TestObjektManager {

	SchwarmObjekt so1, so2;
	HindernisObjekt ho1;
	AlphaObjekt ao1;
	ObjektManager om = ObjektManager.getInstance();

	@Before
	public void initObjects() {
		so1 = new SchwarmObjekt(new Vektor2D(10, 10), new Vektor2D(10, 10), 1);
		so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(10, 10), 1);
		so1.calculateDistances();
		so2.calculateDistances();
		ho1 = new HindernisObjekt(10, 10);
		om.add(ho1);
		ao1 = new AlphaObjekt(new Vektor2D(), new Vektor2D(), 1);
	}

	@After
	public void deleteObjects() {
		om.removeAll();
	}

	@Test
	public void testClone() {
		try {
			ObjektManager.getInstance().clone();
			Assert.fail();
		} catch (RuntimeException e) {
			Assert.assertEquals("clone is not allowed", e.getMessage());
		}
	}

	@Test
	public void testGetCount() {
		Assert.assertEquals(om.getObjectCount(), 2);
		Assert.assertEquals(om.getAlphaCount(), 1);
		Assert.assertEquals(om.getObstacleCount(), 2);
	}

	@Test
	public void testAddObject() {
		om.add(so1);
		Assert.assertEquals(om.getObjectCount(), 3);
	}

	@Test
	public void testAddAlpha() {
		om.add(ao1);
		Assert.assertEquals(om.getAlphaCount(), 2);
	}

	@Test
	public void testAddObstacle() {
		om.add(new HindernisObjekt());
		Assert.assertEquals(om.getObstacleCount(), 3);
	}

	@Test
	public void testRemoveAllObjects() {
		om.removeAllObjects();
		Assert.assertEquals(om.getObjectCount(), 0);
	}

	@Test
	public void testRemoveAllAlphas() {
		om.removeAllAlphas();
		Assert.assertEquals(om.getAlphaCount(), 0);
	}

	@Test
	public void testRemoveAllObstacles() {
		om.removeAllObstacles();
		Assert.assertEquals(om.getObstacleCount(), 1);
	}

	@Test
	public void testRemoveAll() {
		om.removeAll();
		Assert.assertEquals(om.getObjectCount(), 0);
		Assert.assertEquals(om.getAlphaCount(), 0);
		Assert.assertEquals(om.getObstacleCount(), 1);
	}
}
