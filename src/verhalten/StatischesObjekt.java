package verhalten;

import math.Vektor2D;

public abstract class StatischesObjekt extends BasisObjekt {

	public StatischesObjekt() {
		super();
	}

	public StatischesObjekt(int id, Vektor2D pos) {
		super(id, pos);
	}

	public StatischesObjekt(int id) {
		super(id);
	}

	public StatischesObjekt(Vektor2D pos) {
		super(pos);
	}

}
