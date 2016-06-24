package verhalten;

import math.Vektor2D;
import math.Vektor3D;

public abstract class StatischesObjekt extends BasisObjekt {

	protected StatischesObjekt() {
		super();
	}

	protected StatischesObjekt(Vektor2D pos, Vektor3D color) {
		super(pos, color);
	}

	protected StatischesObjekt(Vektor2D pos) {
		super(pos);
	}

	protected StatischesObjekt(Vektor3D color) {
		super(color);
	}

}
