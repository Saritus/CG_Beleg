package verhalten;

import math.*;
import objekte.BeweglichesObjekt;

public final class SchwarmVerhalten extends BasisVerhalten {

	private static final double alignment_value = 225.5;
	private static final double cohesion_value = 1.;
	private static final double separation_value = 5000.;
	private static final double obstacles_value = 10000.;
	private static final double alpha_value = 2.;
	private static final double border_value = 1000.;

	public SchwarmVerhalten(BeweglichesObjekt obj) {
		super(obj);
	}

	@Override
	public void update() {
		obj.calculateDistances();
		obj.eulerMethod(getForce());
	}

	public Vektor2D getForce() {
		Vektor2D force = new Vektor2D();
		force.add(getAlignment(200).mult(alignment_value));
		force.add(getCohesion(200).mult(cohesion_value));
		force.add(getSeparation(50).mult(separation_value));
		force.add(getObstacleSeparation(50).mult(obstacles_value));
		force.add(getAlphaCohesion(300).mult(alpha_value));
		force.add(getBorderSeparation(50).mult(border_value));
		return force;
	}
}
