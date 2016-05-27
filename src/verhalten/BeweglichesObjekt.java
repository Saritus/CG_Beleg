package verhalten;

import math.Vektor2D;

public abstract class BeweglichesObjekt extends BasisObjekt {

	public Vektor2D speed;
	public double masse;
	public double maxSpeed;
	Behavior behavior;
	protected ObjektManager om;

	protected BeweglichesObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed,
			Behavior behavior) {
		super(id, pos);
		this.speed = speed;
		this.masse = masse;
		this.maxSpeed = maxSpeed;
		this.behavior = behavior;
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, Behavior behavior) {
		this(-1, pos, speed, masse, maxSpeed, behavior);
	}

	protected BeweglichesObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, Behavior behavior) {
		this(id, pos, speed, masse, Double.MAX_VALUE, behavior);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed, double masse, Behavior behavior) {
		this(-1, pos, speed, masse, Double.MAX_VALUE, behavior);
	}

	protected BeweglichesObjekt(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		this(id, pos, speed, masse, maxSpeed, null);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		this(-1, pos, speed, masse, maxSpeed, null);
	}

	protected BeweglichesObjekt(int id, Vektor2D pos, Vektor2D speed, double masse) {
		this(id, pos, speed, masse, Double.MAX_VALUE, null);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		this(-1, pos, speed, masse, Double.MAX_VALUE, null);
	}

}
