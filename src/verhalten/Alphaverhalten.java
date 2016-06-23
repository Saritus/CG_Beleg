package verhalten;

import math.*;

public class Alphaverhalten implements Behavior {

	public BeweglichesObjekt obj;

	Alphaverhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		obj.calculateDistances();
		Vektor2D separation = (Vektor2D) om.getSeparation(obj, 30).mult(separation_value);
		Vektor2D obstacles = (Vektor2D) om.getObstacleSeparation(obj, 50).mult(obstacles_value);
		Vektor2D stop = (Vektor2D) LineareAlgebra.mult(obj.speed, -3);

		Vektor2D force = (Vektor2D) LineareAlgebra.add(separation, obstacles, stop);

		obj.speed.add(force.div(obj.masse));
		obj.speed.truncate(obj.maxSpeed);
		obj.pos.add(obj.speed);
		obj.pos.modulo(1024, 768);
	}
}
