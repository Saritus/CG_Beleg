package verhalten;

import math.Vektor2D;

public interface Behavior {

	public static ObjektManager om = ObjektManager.getInstance();

	void update() throws Exception;
}
