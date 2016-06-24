package verhalten;

import math.*;

public final class Schwarmverhalten extends Verhalten implements Behavior {

	private static final double alignment_value = 225.5;
	private static final double cohesion_value = 1.;
	private static final double separation_value = 2000.;
	private static final double obstacles_value = 10000;
	private static final double alpha_value = 2.;

	Schwarmverhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() {
		obj.calculateDistances();
		Vektor2D alignment = (Vektor2D) getAlignment(200).mult(alignment_value);
		Vektor2D cohesion = (Vektor2D) getCohesion(200).mult(cohesion_value);
		Vektor2D separation = (Vektor2D) getSeparation(50).mult(separation_value);
		Vektor2D obstacles = (Vektor2D) getObstacleSeparation(50).mult(obstacles_value);
		Vektor2D alpha = (Vektor2D) getAlphaCohesion(300).mult(alpha_value);
		Vektor2D force = (Vektor2D) LineareAlgebra.add(alignment, cohesion, separation, obstacles, alpha);
		obj.eulerMethod(force);
	}
}
