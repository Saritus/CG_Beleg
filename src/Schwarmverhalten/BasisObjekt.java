package Schwarmverhalten;

import math.Vektor2D;

public abstract class BasisObjekt {
	int id;
	public Vektor2D pos;
	public Vektor2D speed;
	public double masse;
	public double maxSpeed;
	Behavior behavior;
	ObjektManager om;

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, ObjektManager om,
			Behavior behavior) {
		this.id = -1;
		this.pos = pos;
		this.speed = speed;
		this.masse = masse;
		this.maxSpeed = maxSpeed;
		om.add(this);
		this.behavior = behavior;
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, ObjektManager om) {
		this(pos, speed, masse, maxSpeed, om, null);
		behavior = new Schwarmverhalten(this);
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		this(pos, speed, masse, maxSpeed, new ObjektManager(), null);
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		this(pos, speed, masse, Double.MAX_VALUE, new ObjektManager(), null);
	}

	public BasisObjekt(Vektor2D pos, Vektor2D speed) {
		this(pos, speed, 1, Double.MAX_VALUE, new ObjektManager(), null);
	}

	public BasisObjekt(Vektor2D pos) {
		this(pos, new Vektor2D(), 1, Double.MAX_VALUE, new ObjektManager(), null);
	}

	public BasisObjekt() {
		this(new Vektor2D(), new Vektor2D(), 1, Double.MAX_VALUE, new ObjektManager(), null);
	}

	public abstract void render();
}
