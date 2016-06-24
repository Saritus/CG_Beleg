package verhalten;

import org.lwjgl.input.Mouse;
import math.*;

public class ObjektManager {
	protected BeweglichesObjekt[] objects;
	protected AlphaObjekt[] alphas;
	protected StatischesObjekt[] obstacles;

	private static ObjektManager instance;

	// Singleton-Pattern
	private ObjektManager() {
		objects = new BeweglichesObjekt[0];
		alphas = new AlphaObjekt[0];
		obstacles = new StatischesObjekt[1];
		obstacles[0] = new HindernisObjekt(Mouse.getX(), 768 - Mouse.getY());
	}

	public static ObjektManager getInstance() {
		if (instance == null)
			instance = new ObjektManager();
		return instance;
	}

	// Getter
	// - Objects
	public BeweglichesObjekt[] getObjects() {
		return objects;
	}

	public BeweglichesObjekt getObject(int id) {
		return objects[id];
	}

	public int getObjectCount() {
		return objects.length;
	}

	// - Obstacles
	public StatischesObjekt[] getObstacles() {
		return obstacles;
	}

	public StatischesObjekt getObstacle(int id) {
		return obstacles[id];
	}

	public int getObstacleCount() {
		return obstacles.length;
	}

	// - Alphas
	public AlphaObjekt[] getAlphas() {
		return alphas;
	}

	public AlphaObjekt getAlpha(int id) {
		return alphas[id];
	}

	public int getAlphaCount() {
		return alphas.length;
	}

	// Setter
	// - add
	public void add(SchwarmObjekt obj) {
		BeweglichesObjekt[] array = new BeweglichesObjekt[objects.length + 1];
		for (int i = 0; i < objects.length; i++) {
			array[i] = objects[i];
		}
		array[objects.length] = obj;
		objects = array;
	}

	public void add(AlphaObjekt obj) {
		AlphaObjekt[] array = new AlphaObjekt[alphas.length + 1];
		for (int i = 0; i < alphas.length; i++) {
			array[i] = alphas[i];
		}
		array[alphas.length] = obj;
		alphas = array;
	}

	public void add(StatischesObjekt obj)  {
		if (!check(obj, 20)) {
			StatischesObjekt[] array = new StatischesObjekt[obstacles.length + 1];
			for (int i = 0; i < obstacles.length; i++) {
				array[i] = obstacles[i];
			}
			array[obstacles.length] = obj;
			obstacles = array;
		}
	}

	// - check
	public boolean check(BeweglichesObjekt obj) {
		if ((obj.id < 0) || (obj.id >= objects.length))
			return false;
		else if (obj.pos.isEqual(objects[obj.id].pos))
			return true;
		else
			return false;
	}

	public boolean check(StatischesObjekt obj)  {
		return check(obj, 0);
	}

	public boolean check(StatischesObjekt obj, double abstand)  {
		for (int i = 1; i < obstacles.length; i++) {
			if (LineareAlgebra.manhattanDistance(obj.pos, obstacles[i].pos) < abstand) {
				return true;
			}
		}
		return false;
	}

	// - remove
	public void remove(BeweglichesObjekt obj) {
		remove(obj.id);
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

	public void removeAllObstacles() {
		StatischesObjekt mouse = obstacles[0];
		obstacles = new StatischesObjekt[1];
		obstacles[0] = mouse;
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

	public void update()  {
		mouseHandler();

		for (int i = 0; i < objects.length; i++) {
			objects[i].behavior.update();
		}
		for (int i = 0; i < alphas.length; i++) {
			alphas[i].behavior.update();
		}
	}

	private void mouseHandler()  {
		obstacles[0] = new HindernisObjekt(Mouse.getX(), 768 - Mouse.getY());
		if (Mouse.isButtonDown(0)) {
			add(obstacles[0]);
		} else if (Mouse.isButtonDown(1)) {
			removeAllObstacles();
		}
	}
}
