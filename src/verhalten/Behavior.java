package verhalten;

public interface Behavior {

	public static ObjektManager om = ObjektManager.getInstance();
	public static double alignment_value = 225.5;
	public static double cohesion_value = 1.;
	public static double separation_value = 2000.;
	public static double obstacles_value = 10000;
	public static double alpha_value = 2.;

	void update() throws Exception;
}
