package verhalten;

import math.Vektor2D;

public class Alphatier extends BeweglichesObjekt {

	public Alphatier(int id, Vektor2D pos, Vektor2D speed, double masse, Behavior behavior) {
		super(id, pos, speed, masse, behavior);
	}

	public Alphatier(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, Behavior behavior) {
		super(id, pos, speed, masse, maxSpeed, behavior);
	}

	public Alphatier(int id, Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(id, pos, speed, masse, maxSpeed);
	}

	public Alphatier(int id, Vektor2D pos, Vektor2D speed, double masse) {
		super(id, pos, speed, masse);
	}

	public Alphatier(Vektor2D pos, Vektor2D speed, double masse, Behavior behavior) {
		super(pos, speed, masse, behavior);
	}

	public Alphatier(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed, Behavior behavior) {
		super(pos, speed, masse, maxSpeed, behavior);
	}

	public Alphatier(Vektor2D pos, Vektor2D speed, double masse, double maxSpeed) {
		super(pos, speed, masse, maxSpeed);
	}

	public Alphatier(Vektor2D pos, Vektor2D speed, double masse) {
		super(pos, speed, masse);
	}

	@Override
	public void render() {

	}

}
