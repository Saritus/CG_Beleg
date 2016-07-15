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
import verhalten.SchwarmVerhalten;

public class TestObjektManager {

	SchwarmObjekt so1, so2;
	SchwarmVerhalten sv1;
	HindernisObjekt ho;
	AlphaObjekt ao1;
	ObjektManager om = ObjektManager.getInstance();

	@Before
	public void initObjects() {
		so1 = new SchwarmObjekt(new Vektor2D(10, 10), new Vektor2D(10, 10), 1);
		so2 = new SchwarmObjekt(new Vektor2D(), new Vektor2D(10, 10), 1);
		sv1 = new SchwarmVerhalten(so1);
		so1.calculateDistances();
		so2.calculateDistances();
		ho = new HindernisObjekt(5, 5);
		om.add(ho);
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
	public void testRemove() {
		om.removeAll();
		Assert.assertEquals(om.getObjectCount(), 0);
		Assert.assertEquals(om.getAlphaCount(), 0);
		Assert.assertEquals(om.getObstacleCount(), 1);
	}
}
