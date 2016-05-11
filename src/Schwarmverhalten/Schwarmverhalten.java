package Schwarmverhalten;

import math.*;

public class Schwarmverhalten implements Behavior {

	private BasisObjekt obj;

	Schwarmverhalten(BasisObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		Vektor2D beschleunigung = new Vektor2D();
		Vektor2D alignment = (Vektor2D) obj.om.getAverageSpeed().sub(obj.pos);
		Vektor2D cohesion = (Vektor2D) obj.om.getAveragePosition().sub(obj.pos);
		Vektor2D separation = new Vektor2D();
		beschleunigung = (Vektor2D) LineareAlgebra.add(alignment, cohesion, separation);
		obj.speed.add(beschleunigung);
		obj.pos.add(obj.speed);
	}
}
