package Vector;

import Vector.Vector2D;
import Vector.Vector3D;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class VectorTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @org.junit.Test
    public void testAddToBigException() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE,Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(Double.MAX_VALUE,Double.MAX_VALUE);
        vec1.add(vec2);
    }
    @org.junit.Test
    public void testAddToBigNoException() throws Exception {
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE,Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(0,0);
        vec1.add(vec2);
    }
    @org.junit.Test
    public void testAddToSmallException() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(-Double.MAX_VALUE,-Double.MAX_VALUE);
        Vector2D vec2 = new Vector2D(-Double.MAX_VALUE,-Double.MAX_VALUE);
        vec1.add(vec2);
    }
    @org.junit.Test
    public void testAdd() throws Exception {
        Vector2D vec1 = new Vector2D(1,2);
        Vector2D vec2 = new Vector2D(3,4);
        Vector2D expected = new Vector2D(4,6);
        vec1.add(vec2);
        assertEquals(expected.get(0),vec1.get(0),0.0001);
        assertEquals(expected.get(1), vec1.get(1), 0.00001);
    }




    @org.junit.Test
    public void testSub() throws Exception {
        Vector3D vec1 = new Vector3D(3,2,1);
        Vector3D vec2 = new Vector3D(4,3,2);
        Vector3D expected = new Vector3D(-1,-1,-1);
        vec1.sub(vec2);
        assertEquals(expected.get(0),vec1.get(0),0.0001);
        assertEquals(expected.get(1),vec1.get(1),0.0001);
        assertEquals(expected.get(2),vec1.get(2),0.0001);

    }
    @org.junit.Test
    public void testSubToBig() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector3D vec1 = new Vector3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vector3D vec2 = new Vector3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        vec1.sub(vec2);
    }


    @org.junit.Test
    public void testSubToSmall() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector3D vec1 = new Vector3D(-Double.MAX_VALUE, -Double.MIN_VALUE, -Double.MIN_VALUE);
        Vector3D vec2 = new Vector3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
        vec1.sub(vec2);
    }

    @org.junit.Test
    public void testSubToBigNoException() throws Exception {
        Vector3D vec1 = new Vector3D(-Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE);
        Vector3D vec2 = new Vector3D(-1, 0,0);
        vec1.sub(vec2);
    }

    @org.junit.Test
    public void testMult2DToBigException() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE,2);
        vec1.mult(Double.MAX_VALUE);

    }

    @org.junit.Test
    public void testMult2DToSmallException() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(-Double.MAX_VALUE,-2);
        vec1.mult(Double.MAX_VALUE);

    }

    @org.junit.Test
    public void testDivToBig() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);
        vec1.div(Double.MIN_VALUE);
    }

    @org.junit.Test
    public void testDivToSmall() throws Exception {
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);
        vec1.div(-Double.MIN_VALUE);
    }

    @org.junit.Test
    public void testIsEqual() throws Exception {
        Vector2D vec1 = new Vector2D(2,3);
        Vector2D vec2 = new Vector2D(2,3);
        vec1.isEqual(vec2);
        assertEquals(vec1.get(0),vec2.get(0),0);
        assertEquals(vec1.get(1),vec2.get(1), 0);
    }
    @org.junit.Test
    public void testVecLengthToBig(){
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(Double.MAX_VALUE,2);
        vec1.veclength();

    }

    @org.junit.Test
    public void testVecLengthToSmall(){
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(-Double.MAX_VALUE,2);
        vec1.veclength();

    }

    @org.junit.Test
    public void testNormalize(){
        expected.expect(ArithmeticException.class);
        Vector2D vec1 = new Vector2D(0,0);
        vec1.veclength();
        vec1.normalize();

    }


}
