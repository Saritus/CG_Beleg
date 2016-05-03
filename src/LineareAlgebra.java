/**
 * Created by Matze on 03.05.16.
 */
abstract public class LineareAlgebra
{

    Vector add2D(Vector2D vec1, Vector2D vec2){
        Vector2D vec3 = new Vector2D(vec1);
        vec3.add(vec2);
        return vec3;
    }

    Vector add3D(Vector3D vec1, Vector3D vec2){
        Vector3D vec3 = new Vector3D(vec1);
        vec3.add(vec2);
        return vec3;
    }


    Vector sub2D(Vector2D vec1, Vector2D vec2){
        Vector2D vec3 = new Vector2D(vec1);
        vec3.sub(vec2);
        return vec3;
    }

    Vector sub3D(Vector3D vec1, Vector3D vec2){
        Vector3D vec3 = new Vector3D(vec1);
        vec3.sub(vec2);
        return vec3;
    }

    Vector mult2D(Vector2D vec1, double scalar){
        Vector2D vec2 = new Vector2D(vec1);
        vec2.mult(scalar);
        return vec2;
    }

    Vector mult3D(Vector3D vec1, double scalar){
        Vector3D vec2 = new Vector3D(vec1);
        vec2.mult(scalar);
        return vec2;
    }


    Vector div2D(Vector2D vec1,double scalar){
        Vector2D vec2 = new Vector2D(vec1);
        vec2.div(scalar);
        return vec2;
    }

    Vector div3D(Vector3D vec1,double scalar){
        Vector3D vec2 = new Vector3D(vec1);
        vec2.div(scalar);
        return vec2;
    }

    boolean isEqual2D(Vector2D vector1, Vector2D vector2){
        if(vector1.isEqual(vector2))
            return true;
        else
            return false;
    }

    boolean isEqual3D(Vector3D vector1, Vector3D vector2){
        if(vector1.isEqual(vector2))
            return true;
        else
            return false;
    }

    boolean isNotEqual(Vector2D vector, Vector2D vector1){
        for (int i = 0; i < vector.length; i++){
            if(vector.vectorelements[i] != vector1.vectorelements[i]){
                return true;
            }
        }
        return false;
    }

    double veclength2D(Vector2D vector) {
        return vector.veclength();
    }

    double veclength3D(Vector3D vector) {
        return vector.veclength();
    }

    Vector normalize2D(Vector2D vector){
        vector.normalize();
        return vector;
    }
    Vector normalize3D(Vector2D vector){
        vector.normalize();
        return vector;
    }
}
