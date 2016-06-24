package verhalten;

import math.*;

public final class Schwarmverhalten implements Behavior {

	private BeweglichesObjekt obj;
	private static ObjektManager om = ObjektManager.getInstance();

	private static final double alignment_value = 225.5;
	private static final double cohesion_value = 1.;
	private static final double separation_value = 2000.;
	private static final double obstacles_value = 10000;
	private static final double alpha_value = 2.;

	Schwarmverhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		obj.calculateDistances();
		Vektor2D alignment = (Vektor2D) om.getAlignment(obj, 200).mult(alignment_value);
		Vektor2D cohesion = (Vektor2D) om.getCohesion(obj, 200).mult(cohesion_value);
		Vektor2D separation = (Vektor2D) om.getSeparation(obj, 30).mult(separation_value);
		Vektor2D obstacles = (Vektor2D) om.getObstacleSeparation(obj, 50).mult(obstacles_value);
		Vektor2D alpha = (Vektor2D) om.getAlphaCohesion(obj, 300).mult(alpha_value);

		Vektor2D force = (Vektor2D) LineareAlgebra.add(alignment, cohesion, separation, obstacles, alpha);

		obj.eulerMethod(force);
	}
}
