package verhalten;

import math.*;

public final class AlphaVerhalten extends BasisVerhalten {

	private static final double separation_value = 500.;
	private static final double obstacles_value = 10000;

	public AlphaVerhalten(BeweglichesObjekt obj) {
		super(obj);
	}

	public void update() {
		obj.calculateDistances();
		obj.eulerMethod(getForce());
	}

	public Vektor2D getForce() {
		Vektor2D force = new Vektor2D();
		force.add(getSeparation(30).mult(separation_value));
		force.add(getObstacleSeparation(50).mult(obstacles_value));
		return force;
	}
}
