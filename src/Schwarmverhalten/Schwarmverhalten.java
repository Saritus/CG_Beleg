package Schwarmverhalten;

import math.*;

public class Schwarmverhalten implements Behavior {

	private BasisObjekt obj;
	public static double alignment_value = 0.;
	public static double cohesion_value = 0.;
	public static double separation_value = 1.14;

	Schwarmverhalten(BasisObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		Vektor2D force = new Vektor2D();
		Vektor2D alignment = (Vektor2D) obj.om.getAverageSpeed().sub(obj.speed);
		Vektor2D cohesion = (Vektor2D) obj.om.getAveragePosition().sub(obj.pos);
		Vektor2D separation = (Vektor2D) obj.om.getSeparation(obj);
		force = (Vektor2D) LineareAlgebra.add(alignment.mult(alignment_value), cohesion.mult(cohesion_value),
				separation.mult(separation_value));
		obj.speed.add(force.div(obj.masse));
		obj.speed.truncate(obj.maxSpeed);
		obj.pos.add(obj.speed);
		obj.pos.cut(1024, 680);
	}
}
