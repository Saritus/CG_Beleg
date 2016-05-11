package Schwarmverhalten;

import math.Vektor2D;

/**
 * Created by Matze on 10.05.16.
 */
public abstract class BasisObjekt {
	public Vektor2D pos;
	public Vektor2D speed;
	public double masse;
	Behavior behavior;
	ObjektManager om;

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse, ObjektManager om, Behavior behavior) {
		this.pos = pos;
		this.speed = speed;
		this.masse = masse;
		om.add(this);
		this.behavior = behavior;
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse, ObjektManager om) {
		this(pos, speed, masse, om, null);
		behavior = new Schwarmverhalten(this);
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		this(pos, speed, masse, new ObjektManager(), null);
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed) {
		this(pos, speed, 1, new ObjektManager(), null);
	}

	public BasisObjekt(Vektor2D pos) {
		this(pos, new Vektor2D(), 1, new ObjektManager(), null);
	}

	public BasisObjekt() {
		this(new Vektor2D(), new Vektor2D(), 1, new ObjektManager(), null);
	}

	public abstract void render();
}
