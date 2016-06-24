package verhalten;

import math.*;

public final class Alphaverhalten extends Verhalten implements Behavior {

	private static final double separation_value = 500.;
	private static final double obstacles_value = 10000;

	Alphaverhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	public void update() {
		obj.calculateDistances();
		Vektor2D separation = (Vektor2D) getSeparation(30).mult(separation_value);
		Vektor2D obstacles = (Vektor2D) getObstacleSeparation(50).mult(obstacles_value);
		Vektor2D stop = (Vektor2D) LineareAlgebra.mult(obj.speed, -3);
		Vektor2D force = (Vektor2D) LineareAlgebra.add(separation, obstacles, stop);
		obj.eulerMethod(force);
	}

}
