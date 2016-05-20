package Schwarmverhalten;

import math.*;
import org.lwjgl.input.Mouse;

public class Schwarmverhalten implements Behavior {

	private BasisObjekt obj;
	public static double alignment_value = 95.5;
	public static double cohesion_value = 0.04;
	public static double separation_value = 10.;
	public static double mouse_value = 10000.;

	Schwarmverhalten(BasisObjekt obj) {
		this.obj = obj;
	}

	@Override
	public void update() throws Exception {
		Vektor2D force = new Vektor2D();
		Vektor2D mouse = new Vektor2D(Mouse.getX(), 768-Mouse.getY());
		Vektor2D alignment = (Vektor2D) obj.om.getAverageSpeed();
		Vektor2D cohesion = (Vektor2D) obj.om.getAveragePosition().sub(obj.pos);
		Vektor2D separation = (Vektor2D) obj.om.getSeparation(obj, 30);
		Vektor2D mouseforce = (Vektor2D) LineareAlgebra.sub(obj.pos,mouse);

		if(mouseforce.length()<100)
			mouseforce.normalize();
		else
			mouseforce=new Vektor2D();
		force = (Vektor2D) LineareAlgebra.add(alignment.mult(alignment_value), cohesion.mult(cohesion_value),
				separation.mult(separation_value), mouseforce.mult(mouse_value));
		obj.speed.add(force.div(obj.masse));
		obj.speed.truncate(obj.maxSpeed);
		obj.pos.add(obj.speed);
		obj.pos.modulo(1024 - 5, 768 - 5);
	}
}
