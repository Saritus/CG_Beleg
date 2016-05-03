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
        for(int i = 0; i < vec1.length; i++){
            det -= (vec1.vectorelements[i]*vec2.vectorelements[i]);
        }
        return det;
    }

    static Vector crossProduct3D(Vector3D vec1, Vector3D vec2){
        Vector3D vec = new Vector3D();
        vec.vectorelements[0]= (vec1.vectorelements[1]*vec2.vectorelements[2])-(vec1.vectorelements[2]*vec2.vectorelements[1]);
        vec.vectorelements[1]= (vec1.vectorelements[2]*vec2.vectorelements[0])-(vec1.vectorelements[0]*vec2.vectorelements[2]);
        vec.vectorelements[2]= (vec1.vectorelements[0]*vec2.vectorelements[1])-(vec1.vectorelements[1]*vec2.vectorelements[0]);
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

    


    public static void main(String[] args)
    {
        Vector2D vec1 = new Vector2D(3,1);
        Vector2D vec2 = new Vector2D(2,3);
        double dist = 0;
        dist = LineareAlgebra.dotProduct2D(vec1,vec2);
        System.out.print(dist);

    }
}
