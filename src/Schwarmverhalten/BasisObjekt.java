package Schwarmverhalten;

import math.Vektor2D;

public abstract class BasisObjekt {

	protected int id;
	protected Vektor2D pos;

	protected BasisObjekt(int id, Vektor2D pos) {
		this.id = id;
		this.pos = pos;
	}

	protected BasisObjekt(Vektor2D pos) {
		this(-1, pos);
	}

	protected BasisObjekt(int id) {
		this(id, new Vektor2D());
	}

	protected BasisObjekt() {
		this(-1, new Vektor2D());
	}

	public abstract void render();
}
