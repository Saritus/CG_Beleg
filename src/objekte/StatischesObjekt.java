package objekte;

import math.Vektor2D;
import math.Vektor3D;

public abstract class StatischesObjekt extends BasisObjekt {

	protected StatischesObjekt(Vektor2D pos, Vektor3D color) {
		super(pos, color);
	}

	protected StatischesObjekt(Vektor2D pos) {
		super(pos);
	}

	protected StatischesObjekt(int x, int y) {
		super(new Vektor2D(x, y));
	}

	protected StatischesObjekt(Vektor3D color) {
		super(color);
	}

	protected StatischesObjekt() {
		super();
	}
}
