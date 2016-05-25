package Schwarmverhalten;

import org.lwjgl.input.Mouse;

import math.*;

public class ObjektManager {
	protected BeweglichesObjekt[] objects;
	protected int count;
	protected StatischesObjekt[] obstacles;

	ObjektManager() {
		objects = new BeweglichesObjekt[10];
		count = 0;
		obstacles = new StatischesObjekt[1];
	}

	public void add(BeweglichesObjekt obj) {
		BeweglichesObjekt[] array = new BeweglichesObjekt[count + 1];
		for (int i = 0; i < count; i++) {
			array[i] = objects[i];
			array[i].id = i;
		}
		obj.om = this;
		array[count++] = obj;
		objects = array;
	}

	public boolean check(BeweglichesObjekt obj) {
		if ((obj.id < 0) || (obj.id >= objects.length))
			return false;
		else if (obj.pos.isEqual(objects[obj.id].pos))
			return true;
		else
			return false;
	}

	public void remove(BeweglichesObjekt obj) {
		remove(obj.id);
	}

	public void remove(int id) {
		if ((id < 0) || (id >= count)) {
			return;
		}
		BeweglichesObjekt[] array = new BeweglichesObjekt[count - 1];
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

	public void add(StatischesObjekt obj) {
		if (!check(obj)) {
			StatischesObjekt[] array = new StatischesObjekt[obstacles.length + 1];
			for (int i = 0; i < obstacles.length; i++) {
				array[i] = obstacles[i];
			}
			array[obstacles.length] = obj;
			obstacles = array;
		}
	}

	public boolean check(StatischesObjekt obj) {
		for (int i = 1; i < obstacles.length; i++) {
			if (obj.pos.isEqual(obstacles[i].pos)) {
				return true;
			}
		}
		return false;
	}

	public void removeAllObstacles() {
		StatischesObjekt mouse = obstacles[0];
		obstacles = new StatischesObjekt[1];
		obstacles[0] = mouse;
	}

	public BeweglichesObjekt[] getObjects() {
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

	public Vektor getCohesion(BeweglichesObjekt obj, double abstand) throws Exception {
		Vektor2D average = new Vektor2D();
		int anzahl = 0;
		for (int i = 0; i < count; i++) {
			if (LineareAlgebra.sub(obj.pos, objects[i].pos).length() < abstand) {
				average.add(objects[i].pos);
				anzahl++;
			}
		}
		return average.div(anzahl).sub(obj.pos);
	}

	public Vektor getAverageSpeed() throws Exception {
		Vektor2D avgspeed = new Vektor2D();
		for (int i = 0; i < this.count; i++) {
			avgspeed.add(this.objects[i].speed);
		}
		avgspeed.div(count);
		return avgspeed;
	}

	public Vektor getAlignment(BeweglichesObjekt obj, double abstand) throws Exception {
		Vektor2D average = new Vektor2D();
		int anzahl = 0;
		for (int i = 0; i < count; i++) {
			if (LineareAlgebra.sub(obj.pos, objects[i].pos).length() < abstand) {
				average.add(objects[i].speed);
				anzahl++;
			}
		}
		return average.div(anzahl);
	}

	public Vektor getSeparation(BeweglichesObjekt obj, double abstand) throws Exception {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < count; i++) {
			if (obj.id != objects[i].id) {
				Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.pos, objects[i].pos);
				if ((dif.lengthsquare() < abstand * abstand)) {
					result.add(dif.div(dif.lengthsquare()));
				}
			}
		}
		return result;
	}

	public Vektor getObstacleSeparation(BeweglichesObjekt obj, double abstand) throws Exception {
		Vektor2D result = new Vektor2D();
		for (int i = 0; i < obstacles.length; i++) {
			Vektor2D dif = (Vektor2D) LineareAlgebra.sub(obj.pos, obstacles[i].pos);
			if ((dif.lengthsquare() < abstand * abstand)) {
				result.add(dif.div(dif.lengthsquare()));

			}
		}
		return result;
	}

	public void render() {
		for (int i = 0; i < obstacles.length; i++) {
			obstacles[i].render();
		}
		for (int i = 0; i < count; i++) {
			objects[i].render();
		}

	}

	public void update() throws Exception {
		obstacles[0] = new HindernisObjekt(Mouse.getX(), 768 - Mouse.getY());
		if (Mouse.isButtonDown(0)) {
			add(obstacles[0]);
		} else if (Mouse.isButtonDown(1)) {
			removeAllObstacles();
		}

		if (count > 0) {
			for (int i = 0; i < count; i++) {
				objects[i].behavior.update();
			}
		}
	}
}
