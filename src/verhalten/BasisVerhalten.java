package verhalten;

import math.LineareAlgebra;
import math.Vektor;
import math.Vektor2D;

public abstract class BasisVerhalten implements Behavior {

	protected BeweglichesObjekt obj;
	protected static ObjektManager om = ObjektManager.getInstance();

	public BasisVerhalten(BeweglichesObjekt obj) {
		this.obj = obj;
	}

	public Vektor getCohesion(double abstand) {
		Vektor2D average = new Vektor2D();
		int count = 0;
		for (int i = 0; i < om.getObjectCount(); i++) {
			if (obj.abstand[i] < abstand) {
				average.add(om.getObject(i).pos);
				count++;
			}
		}
		return count == 0 ? average : average.div(count).sub(obj.pos);
	}

	public Vektor2D getAlignment(double abstand) {
		Vektor2D average = new Vektor2D();
		int count = 0;
		for (int i = 0; i < om.getObjectCount(); i++) {
			if (obj.abstand[i] < abstand) {
				average.add(om.getObject(i).speed);
				count++;
			}
		}
		return count == 0 ? average : (Vektor2D) average.div(count);
	}

	public Vektor2D getSeparation(double abstand) {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < om.getObjectCount(); i++) {
			if (obj.id != i) {
				Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.pos, om.getObject(i).pos);
				if ((obj.abstand[i] < abstand) && (obj.abstand[i] > 0)) {
					result.add(dif.div(obj.abstand[i] * obj.abstand[i]));
				}
			}
		}
		return result;
	}

	public Vektor2D getObstacleSeparation(double abstand) {
		Vektor2D result = new Vektor2D();
		double diflength;
		for (int i = 0; i < om.getObstacleCount(); i++) {
			Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.pos, om.getObstacle(i).pos);
			if (((diflength = dif.lengthsquare()) < abstand * abstand) && (diflength > 0)) {
				result.add(dif.div(diflength));
			}
		}
		return result;
	}

	public Vektor2D getAlphaCohesion(double abstand) {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < om.getAlphaCount(); i++) {
			if (LineareAlgebra.manhattanDistance(obj.pos, om.getAlpha(i).pos) < abstand) {
				result.add(LineareAlgebra.sub(om.getAlpha(i).pos, obj.pos));
			}
		}
		return result;
	}
}
