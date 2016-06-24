package verhalten;

import math.*;

public abstract class BeweglichesObjekt extends BasisObjekt {

	protected Vektor2D speed;
	protected double masse;
	protected double maxSpeed;
	protected Behavior behavior;
	protected double abstand[];

	protected BeweglichesObjekt(Vektor2D pos, Vektor3D color, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, color);
		setSpeed(speed);
		setMasse(masse);
		setMaxSpeed(maxSpeed);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor3D color, Vektor2D speed, double masse) {
		this(pos, color, speed, masse, Double.MAX_VALUE);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor3D color, Vektor2D speed) {
		this(pos, color, speed, 1);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor3D color) {
		this(pos, color, new Vektor2D());
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		this(pos, new Vektor3D(), speed, masse, maxSpeed);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed, double masse) {
		this(pos, new Vektor3D(), speed, masse, Double.MAX_VALUE);
	}

	protected BeweglichesObjekt(Vektor2D pos, Vektor2D speed) {
		this(pos, new Vektor3D(), speed, 1);
	}

	protected BeweglichesObjekt(Vektor2D pos) {
		this(pos, new Vektor3D(), new Vektor2D());
	}

	protected BeweglichesObjekt() {
		this(new Vektor2D());
	}

	public Vektor2D getSpeed() {
		return speed;
	}

	public void setSpeed(Vektor2D speed) {
		this.speed = speed;
	}

	public double getMasse() {
		return masse;
	}

	public void setMasse(double masse) {
		this.masse = masse;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Behavior getBehavior() {
		return behavior;
	}

	public void setBehavior(Behavior behavior) {
		this.behavior = behavior;
	}

	public void calculateDistances() {
		abstand = new double[ObjektManager.getInstance().getObjectCount()];
		for (int i = 0; i < ObjektManager.getInstance().getObjectCount(); i++) {
			try {
				abstand[i] = LineareAlgebra.manhattanDistance(pos, ObjektManager.getInstance().objects[i].pos);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void eulerMethod(Vektor2D force) {
		speed.add(force.div(masse));
		speed.truncate(maxSpeed);
		pos.add(speed);
		pos.modulo(1024, 768);
	}
}
