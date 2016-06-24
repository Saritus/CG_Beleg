package verhalten;

public interface Behavior {

	public static ObjektManager om = ObjektManager.getInstance();

	void update() throws Exception;
}
