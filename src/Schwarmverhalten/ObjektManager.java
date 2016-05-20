package Schwarmverhalten;

import math.*;

public class ObjektManager {
	protected BasisObjekt[] objects;
	protected int count;

	ObjektManager() {
		objects = new BasisObjekt[10];
		count = 0;
	}

	public void add(BasisObjekt obj) {
		BasisObjekt[] array = new BasisObjekt[count + 1];
		for (int i = 0; i < count; i++) {
			array[i] = objects[i];
			array[i].id = i;
		}
		obj.om = this;
		array[count++] = obj;
		objects = array;
	}

	public boolean check(BasisObjekt obj) {
		if ((obj.id < 0) || (obj.id >= objects.length))
			return false;
		else if (obj.pos.isEqual(objects[obj.id].pos))
			return true;
		else
			return false;
	}

	public void remove(BasisObjekt obj) {
		remove(obj.id);
	}

	public void remove(int id) {
		if ((id < 0) || (id >= count)) {
			return;
		}
		BasisObjekt[] array = new BasisObjekt[count - 1];
		for (int i = 0; i < id; i++) {
			array[i] = objects[i];
			array[i].id = i;
		}
		for (int i = id; i < count; i++) {
			array[i] = objects[i + 1];
			array[i].id = i;
		}
		objects = array;
		count--;
	}

	public BasisObjekt[] getObjects() {
		return objects;
	}

	public int getCount() {
		return count;
	}

	public Vektor2D getAveragePosition() throws Exception {
		Vektor2D avgpos = new Vektor2D();
		for (int i = 0; i < this.count; i++) {
			avgpos.add(this.objects[i].pos);
		}
		avgpos.div(count);
		return avgpos;
	}

	public Vektor getAverageSpeed() throws Exception {
		Vektor2D avgspeed = new Vektor2D();
		for (int i = 0; i < this.count; i++) {
			avgspeed.add(this.objects[i].speed);
		}
		avgspeed.div(count);
		return avgspeed;
	}

	public Vektor getSeparation(BasisObjekt obj, double abstand) throws Exception {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < count; i++) {
			if (obj.id != objects[i].id) {
				Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.pos, objects[i].pos);
				Vektor2D sep;
				if ((dif.lengthsquare() < abstand*abstand)) {
					sep = (Vektor2D) LineareAlgebra.div(dif, dif.lengthsquare());
					result.add(dif);
					System.out.println(dif.length()+" " + dif.lengthsquare());
				}
			}
		}
		return result;
	}

	public void render() {
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				objects[i].render();
			}
		}
	}

	public void update() throws Exception {
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				objects[i].behavior.update();
			}
		}
	}
}
