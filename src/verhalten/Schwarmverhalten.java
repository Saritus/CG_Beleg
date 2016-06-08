package verhalten;

import math.*;

public class Schwarmverhalten implements Behavior {

	private BeweglichesObjekt obj;
	public static double alignment_value = 125.5;
	public static double cohesion_value = 1.;
	public static double separation_value = 10000.;
	public static double obstacles_value = 10000;
	public static ObjektManager om = ObjektManager.getInstance();

	Schwarmverhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		Vektor2D alignment = (Vektor2D) om.getAlignment(obj, 200);
		Vektor2D cohesion = (Vektor2D) om.getCohesion(obj, 200);
		Vektor2D separation = (Vektor2D) om.getSeparation(obj, 30);
		Vektor2D obstacles = (Vektor2D) om.getObstacleSeparation(obj, 50);

		Vektor2D force = (Vektor2D) LineareAlgebra.add(alignment.mult(alignment_value), cohesion.mult(cohesion_value),
				separation.mult(separation_value), obstacles.mult(obstacles_value));
		obj.speed.add(force.div(obj.masse));
		obj.speed.truncate(obj.maxSpeed);
		obj.pos.add(obj.speed);
		obj.pos.modulo(1024, 768);
	}
}
