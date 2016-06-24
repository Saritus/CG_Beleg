package verhalten;

import org.lwjgl.input.Mouse;
import math.*;

public class ObjektManager {

	protected BeweglichesObjekt[] objects;
	protected AlphaObjekt[] alphas;
	protected StatischesObjekt[] obstacles;
	private static ObjektManager instance;

	private ObjektManager() {
		objects = new BeweglichesObjekt[0];
		alphas = new AlphaObjekt[0];
		obstacles = new StatischesObjekt[1];
		obstacles[0] = new HindernisObjekt(Mouse.getX(), 768 - Mouse.getY());
	}

	// Getter

	public static ObjektManager getInstance() {
		if (instance == null)
			instance = new ObjektManager();
		return instance;
	}

	public BeweglichesObjekt[] getObjects() {
		return objects;
	}

	public BeweglichesObjekt getObject(int id) {
		return objects[id];
	}

	public int getObjectCount() {
		return objects.length;
	}

	public AlphaObjekt[] getAlphas() {
		return alphas;
	}

	public AlphaObjekt getAlpha(int id) {
		return alphas[id];
	}

	public int getAlphaCount() {
		return alphas.length;
	}

	public StatischesObjekt[] getObstacles() {
		return obstacles;
	}

	public StatischesObjekt getObstacle(int id) {
		return obstacles[id];
	}

	public int getObstacleCount() {
		return obstacles.length;
	}

	// Setter

	public void add(SchwarmObjekt obj) {
		BeweglichesObjekt[] array = new BeweglichesObjekt[objects.length + 1];
		for (int i = 0; i < objects.length; i++) {
			array[i] = objects[i];
			array[i].id = i;
		}
		array[objects.length] = obj;
		objects = array;
	}

	public void add(AlphaObjekt obj) {
		AlphaObjekt[] array = new AlphaObjekt[alphas.length + 1];
		for (int i = 0; i < alphas.length; i++) {
			array[i] = alphas[i];
			array[i].id = i;
		}
		array[alphas.length] = obj;
		alphas = array;
	}

	public void add(StatischesObjekt obj) {
		if (!check(obj, 20)) {
			StatischesObjekt[] array = new StatischesObjekt[obstacles.length + 1];
			for (int i = 0; i < obstacles.length; i++) {
				array[i] = obstacles[i];
			}
			array[obstacles.length] = obj;
			obstacles = array;
		}
	}

	public boolean check(BeweglichesObjekt obj) {
		if ((obj.id < 0) || (obj.id >= objects.length))
			return false;
		else if (obj.pos.isEqual(objects[obj.id].pos))
			return true;
		else
			return false;
	}

	public boolean check(StatischesObjekt obj) {
		for (int i = 1; i < obstacles.length; i++) {
			if (obj.pos.isEqual(obstacles[i].pos)) {
				return true;
			}
		}
		return false;
	}

	public boolean check(StatischesObjekt obj, double abstand) {
		for (int i = 1; i < obstacles.length; i++) {
			if (LineareAlgebra.manhattanDistance(obj.pos, obstacles[i].pos) < abstand) {
				return true;
			}
		}
		return false;
	}

	public void remove(int id) {
		if ((id < 0) || (id >= objects.length)) {
			return;
		}
		BeweglichesObjekt[] array = new BeweglichesObjekt[objects.length - 1];
		for (int i = 0; i < id; i++) {
			array[i] = objects[i];
			array[i].id = i;
		}
		for (int i = id; i < objects.length; i++) {
			array[i] = objects[i + 1];
			array[i].id = i;
		}
		objects = array;
	}

	public void remove(BeweglichesObjekt obj) {
		remove(obj.id);
	}

	public void removeAllObstacles() {
		StatischesObjekt mouse = obstacles[0];
		obstacles = new StatischesObjekt[1];
		obstacles[0] = mouse;
	}

	// Prozeduren

	public void update() {
		obstacles[0] = new HindernisObjekt(Mouse.getX(), 768 - Mouse.getY());
		if (Mouse.isButtonDown(0)) {
			add(obstacles[0]);
		} else if (Mouse.isButtonDown(1)) {
			removeAllObstacles();
		}

		for (int i = 0; i < objects.length; i++) {
			objects[i].calculateDistances();
			objects[i].behavior.update();
		}
		for (int i = 0; i < alphas.length; i++) {
			alphas[i].calculateDistances();
			alphas[i].behavior.update();
		}
	}

	public void render() {
		for (int i = 0; i < obstacles.length; i++) {
			obstacles[i].render();
		}
		for (int i = 0; i < objects.length; i++) {
			objects[i].render();
		}
		for (int i = 0; i < alphas.length; i++) {
			alphas[i].render();
		}
	}
}
