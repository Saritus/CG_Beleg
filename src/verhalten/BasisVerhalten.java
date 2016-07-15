package verhalten;

import math.LineareAlgebra;
import math.Vektor;
import math.Vektor2D;
import objekte.BeweglichesObjekt;
import program.ObjektManager;

public abstract class BasisVerhalten implements Behavior {

	protected BeweglichesObjekt obj;
	protected static ObjektManager om = ObjektManager.getInstance();

	public BasisVerhalten(BeweglichesObjekt obj) {
		this.obj = obj;
		obj.setBehavior(this);
	}

	public Vektor getCohesion(double abstand) {
		Vektor2D average = new Vektor2D();
		int count = 0;
		for (int i = 0; i < om.getObjectCount(); i++) {
			if (obj.getAbstand()[i] < abstand) {
				average.add(om.getObject(i).getPos());
				count++;
			}
		}
		return count == 0 ? average : average.div(count).sub(obj.getPos());
	}

	public Vektor2D getAlignment(double abstand) {
		Vektor2D average = new Vektor2D();
		int count = 0;
		for (int i = 0; i < om.getObjectCount(); i++) {
			if (obj.getAbstand()[i] < abstand) {
				average.add(om.getObject(i).getSpeed());
				count++;
			}
		}
		return count == 0 ? average : (Vektor2D) average.div(count);
	}

	public Vektor2D getSeparation(double abstand) {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < om.getObjectCount(); i++) {
			if (obj.getId() != i) {
				Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.getPos(), om.getObject(i).getPos());
				if ((obj.getAbstand()[i] < abstand) && (obj.getAbstand()[i] > 0)) {
					result.add(dif.div(obj.getAbstand()[i] * obj.getAbstand()[i]));
				}
			}
		}
		return result;
	}

	public Vektor2D getObstacleSeparation(double abstand) {
		Vektor2D result = new Vektor2D();
		double diflength;
		for (int i = 0; i < om.getObstacleCount(); i++) {
			Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.getPos(), om.getObstacle(i).getPos());
			if (((diflength = dif.lengthsquare()) < abstand * abstand) && (diflength > 0)) {
				result.add(dif.div(diflength));
			}
		}
		return result;
	}

	public Vektor2D getAlphaCohesion(double abstand) {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < om.getAlphaCount(); i++) {
			if (LineareAlgebra.manhattanDistance(obj.getPos(), om.getAlpha(i).getPos()) < abstand) {
				result.add(LineareAlgebra.sub(om.getAlpha(i).getPos(), obj.getPos()));
			}
		}
		return result;
	}
}
