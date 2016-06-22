package verhalten;

import math.*;

public class Alphaverhalten implements Behavior {

	private BeweglichesObjekt obj;
	public static double alignment_value = 225.5;
	public static double cohesion_value = 1.;
	public static double separation_value = 2000.;
	public static double obstacles_value = 5000;
	public static ObjektManager om = ObjektManager.getInstance();

	Alphaverhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		om.calculateDistances(obj);
		Vektor2D separation = (Vektor2D) om.getSeparation(obj, 30).mult(separation_value);
		Vektor2D obstacles = (Vektor2D) om.getObstacleSeparation(obj, 50).mult(obstacles_value);

		Vektor2D force = (Vektor2D) LineareAlgebra.add(separation, obstacles);

		obj.speed.add(force.div(obj.masse));
		obj.speed.truncate(obj.maxSpeed);
		obj.pos.add(obj.speed);
		obj.pos.modulo(1024, 768);
	}
}
