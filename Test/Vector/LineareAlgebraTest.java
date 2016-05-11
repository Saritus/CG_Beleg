package Vector;

import Vector.Vector;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * Created by Matze on 09.05.16.
 */
public class LineareAlgebraTest
{
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @org.junit.Test
    public void testAdd()throws Exception{
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE,Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vector vec3 = LineareAlgebra.add2D(vec1, vec2);
    }

    @org.junit.Test
    public void testSub() throws Exception{
        expected.expect(ArithmeticException.class);
        Vector3D vec1 = new Vector3D(-Double.MAX_VALUE, -Double.MAX_VALUE,-Double.MAX_VALUE);
        Vector3D vec2 = new Vector3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vector   vec3 = LineareAlgebra.sub3D(vec1, vec2);
    }

    @org.junit.Test
    public void testMult2D() throws Exception{
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(-Double.MAX_VALUE, 2);
        Vector  vec3 = LineareAlgebra.mult2D(vec1, 2);

    }

    @org.junit.Test
    public void testDiv2D() throws Exception{
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(2,3);
        Vector vec = LineareAlgebra.div2D(vec1, 0);
    }

    @org.junit.Test
    public void testEuclideanDist2d() throws Exception{
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(-Double.MAX_VALUE,-Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);

        double dist = 0;
        dist = LineareAlgebra.euclideandist2D(vec1, vec2);


    }

    @org.junit.Test
    public void testManhattenDist(){
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);

        double dist = 0;
        dist = LineareAlgebra.manhattendist2D(vec1, vec2);

    }
    @org.junit.Test
    public void testCrossProduct2D(){
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(-Double.MAX_VALUE, -Double.MAX_VALUE);
        double dist = 0;
        dist = LineareAlgebra.cosEquation2D(vec1, vec2);

    }

    // hier gehts weiter mit ################ hey ho lets go !!
    @org.junit.Test
    public void testCrossProduct3D(){
        expected.expect(ArithmeticException.class);
        Vector3D vec1 = new Vector3D(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE);
        Vector3D vec2 = new Vector3D(Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE);

        Vector vec;
        vec = LineareAlgebra.crossProduct3D(vec1, vec2);


    }
}
