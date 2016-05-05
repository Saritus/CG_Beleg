import java.util.regex.Matcher;

/**
 * Created by Matze on 03.05.16.
 */
abstract public class LineareAlgebra
{

    static Vector add2D(Vector2D vec1, Vector2D vec2){
        Vector2D vec3 = new Vector2D(vec1);
        vec3.add(vec2);
        return vec3;
    }

    static Vector add3D(Vector3D vec1, Vector3D vec2){
        Vector3D vec3 = new Vector3D(vec1);
        vec3.add(vec2);
        return vec3;
    }


    static Vector sub2D(Vector2D vec1, Vector2D vec2){
        Vector2D vec3 = new Vector2D(vec1);
        vec3.sub(vec2);
        return vec3;
    }

    static Vector sub3D(Vector3D vec1, Vector3D vec2){
        Vector3D vec3 = new Vector3D(vec1);
        vec3.sub(vec2);
        return vec3;
    }

    static Vector mult2D(Vector2D vec1, double scalar){
        Vector2D vec2 = new Vector2D(vec1);
        vec2.mult(scalar);
        return vec2;
    }

    static Vector mult3D(Vector3D vec1, double scalar){
        Vector3D vec2 = new Vector3D(vec1);
        vec2.mult(scalar);
        return vec2;
    }


    static Vector div2D(Vector2D vec1,double scalar){
        Vector2D vec2 = new Vector2D(vec1);
        vec2.div(scalar);
        return vec2;
    }

    static Vector div3D(Vector3D vec1,double scalar){
        Vector3D vec2 = new Vector3D(vec1);
        vec2.div(scalar);
        return vec2;
    }

    static boolean isEqual2D(Vector2D vec1, Vector2D vec2){
        if(vec1.isEqual(vec2))
            return true;
        else
            return false;
    }

    static boolean isEqual3D(Vector3D vec1, Vector3D vec2){
        if(vec1.isEqual(vec2))
            return true;
        else
            return false;
    }

    static boolean isNotEqual(Vector3D vec1, Vector3D vec2){
        if(vec1.isNotEqual(vec2))
            return true;
        else
            return false;
    }

    static double veclength2D(Vector2D vec) {
        return vec.veclength();
    }

    static double veclength3D(Vector3D vec) {
        return vec.veclength();
    }

    static Vector normalize2D(Vector2D vec){
        vec.normalize();
        return vec;
    }
    static Vector normalize3D(Vector2D vec){
        vec.normalize();
        return vec;
    }

    static double euclideandist2D(Vector2D vec1,Vector2D vec2){
        double distance = 0;
        Vector vec3 = sub2D(vec2,vec1);
        for (int i = 0; i < vec3.length;i++){
            distance += Math.pow(vec3.vectorelements[i],2);
        }
        return Math.sqrt(distance);
    }
    static double euclideandist3D(Vector3D vec1,Vector3D vec2){
        double distance = 0;
        Vector vec3 = sub3D(vec2,vec1);
        for (int i = 0; i < vec3.length;i++){
            distance += Math.pow(vec3.vectorelements[i],2);
        }
        return Math.sqrt(distance);
    }
    static double manhattendist2D(Vector2D vec1, Vector2D vec2){
        double dist = 0;
        Vector vec = sub2D(vec1,vec2);
        for (int i = 0; i < vec1.length; i++){
            dist += vec.vectorelements[i];
        }
        return dist;
    }
    static double manhattendist3D(Vector3D vec1, Vector3D vec2){
        double dist = 0;
        Vector vec = sub3D(vec1,vec2);
        for (int i = 0; i < vec1.length; i++){
            dist += vec.vectorelements[i];
        }
        return dist;
    }

    static double crossProduct2D(Vector2D vec1, Vector2D vec2){
        double det = 0;
        det = (vec1.vectorelements[0]*vec2.vectorelements[1])-(vec2.vectorelements[0]*vec1.vectorelements[1]);
        return det;
    }

    static Vector crossProduct3D(Vector3D vec1, Vector3D vec2){
        Vector3D vec = new Vector3D();
        vec.vectorelements[0] = (vec1.get(1)*vec2.get(2))-(vec1.get(2)*vec2.get(1));
        vec.vectorelements[1]= (vec1.get(2)*vec2.get(0))-(vec1.get(0)*vec2.get(2));
        vec.vectorelements[2]= (vec1.get(0)*vec2.get(1))-(vec1.get(1)*vec2.get(0));
        return vec;
    }

    static double dotProduct2D(Vector2D vec1, Vector2D vec2){
        double dotProduct = 0;
        for(int i = 0; i < vec1.length; i++){
            dotProduct += (vec1.vectorelements[i]*vec2.vectorelements[i]);
        }
        return dotProduct;
    }

    static double dotProduct3D(Vector3D vec1, Vector3D vec2){
        double dotProduct = 0;
        for(int i = 0; i < vec1.length; i++){
            dotProduct += (vec1.vectorelements[i]*vec2.vectorelements[i]);
        }
        return dotProduct;
    }

    static double cosEquation2D(Vector2D vec1,Vector2D vec2){
        double cos = (dotProduct2D(vec1,vec2))/(veclength2D(vec1)*veclength2D(vec2));
        return cos;
    }
    static double cosEquation3D(Vector3D vec1,Vector3D vec2){
        double cos = (dotProduct3D(vec1,vec2))/(veclength3D(vec1)*veclength3D(vec2));
        return cos;
    }
    static double sinEquation2D(Vector2D vec1,Vector2D vec2){
        double cos = (crossProduct2D(vec1,vec2))/(veclength2D(vec1)*veclength2D(vec2));
        return cos;
    }
    static double sinEquation3D(Vector3D vec1,Vector3D vec2){
        Vector vec = crossProduct3D(vec1,vec2);
        double cos = (vec.veclength())/(veclength3D(vec1)*veclength3D(vec2));
        return cos;
    }


    static double angleRad2D(Vector2D vec1, Vector2D vec2){
        double angle = cosEquation2D(vec1,vec2);
        angle = Math.acos(angle);
        return angle;
    }

    static double angleRad3D(Vector3D vec1, Vector3D vec2){
        double angle = cosEquation3D(vec1,vec2);
        angle = Math.acos(angle);
        return angle;
    }


    static double angleDegree2D(Vector2D vec1, Vector2D vec2){
        double angle = cosEquation2D(vec1,vec2);
        angle = Math.acos(angle);
        angle = Math.toDegrees(angle);
        return angle;
    }

    static double angleDegree3D(Vector3D vec1, Vector3D vec2){
        double angle = cosEquation3D(vec1,vec2);
        angle = Math.acos(angle);
        angle = Math.toDegrees(angle);
        return angle;
    }

    static double radToDegree2D(double rad){

        return Math.toDegrees(rad);
    }

    static double radToDegree3D(double rad){

        return Math.toDegrees(rad);
    }

    static double degreeToRad2D(double degree){

        return Math.toRadians(degree);
    }


    static double degreeToRad3D(double degree){

        return Math.toRadians(degree);
    }

    static double determinat2D(Vector2D vec1, Vector2D vec2){

        return crossProduct2D(vec1,vec2);
    }

    static double determinant3D(Vector3D vec1, Vector3D vec2, Vector3D vec3){
        double det = 0;
        det = vec1.get(0)*(vec2.get(1)*vec3.get(2))-(vec3.get(1)*vec2.get(2));
        det = det - vec2.get(0)*((vec1.get(1)*vec3.get(2))-(vec3.get(1)*vec1.get(2)));
        det = det + (vec3.get(0)*((vec1.get(1)*vec2.get(2))-(vec2.get(1)*vec1.get(2))));

        return det;
    }

    static Vector abs2D(Vector2D vec1){
        for(int i = 0; i < vec1.length;i++){
            if(vec1.vectorelements[i] < 0){
                vec1.vectorelements[i] *= -1;
            }
        }
        return vec1;
    }

    static Vector abs3D(Vector3D vec1){
        for(int i = 0; i < vec1.length;i++){
            if(vec1.vectorelements[i] < 0){
                vec1.vectorelements[i] *= -1;
            }
        }
        return vec1;
    }

    static void show(Vector vec){

        System.out.println(vec.toString());
    }

    public static void main(String[] args)
    {
        Vector2D vec1 = new Vector2D(1,2);
        Vector2D vec2 = new Vector2D(2,3);
        double cos = 0;
        cos = LineareAlgebra.crossProduct2D(vec1,vec2);
        //System.out.print(cos+"\n");

        Vector3D vec13d = new Vector3D(1,2,3);
        Vector3D vec23d = new Vector3D(4,5,6);
        Vector3D vec33d = new Vector3D(7,8,9);
        double cos3d = 0;
        cos3d = LineareAlgebra.determinant3D(vec13d, vec23d,vec33d);
        //System.out.print(cos3d+"\n");

        LineareAlgebra.show(vec13d);

    }
}
