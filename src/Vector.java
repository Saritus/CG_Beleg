/**
 * Created by Matze on 03.05.16.
 */
abstract public class Vector
{
    int length;
    protected double[] vectorelements;

    Vector(int length){
        this.length = length;
       vectorelements = new double[length];
    }

    //Constructor
    Vector(Vector vec){
        this.length = vec.length;
        this.vectorelements = vec.vectorelements.clone();
    }

    public double get(int pos){
        return vectorelements[pos];
    }

    void setPosition(double[] vecelem){
        for (int i = 0; i < vecelem.length;i++){
            vectorelements[i]=vecelem[i];
        }
    }

    boolean isNullVector(){
        for(int i=0; i < length;i++ ){
            if(this.vectorelements[i] != 0){
                return false;
            }
        }
        return true;
    }

    void add(Vector vector){
        for (int i = 0; i < length;i++){
            this.vectorelements[i] += vector.vectorelements[i];
        }
    }

    void sub(Vector vector){
        for (int i = 0; i < length;i++ ){
            vectorelements[i] -= vector.vectorelements[i];
        }
    }

    void mult(double scalar){
        for (int i = 0; i < length; i++){
            vectorelements[i] *= scalar;
        }
    }

    void div(double scalar){
        for (int i = 0; i < vectorelements.length;i++){
            vectorelements[i] /= scalar;
        }
    }

    boolean isEqual(Vector vector){
        for (int i = 0; i < length; i++){
           if(vectorelements[i] != vector.vectorelements[i]){
               return false;
           }
        }
        return true;
    }
    boolean isNotEqual(Vector vector){
        for (int i = 0; i < length; i++){
            if(vectorelements[i] != vector.vectorelements[i]){
                return true;
            }
        }
        return false;
    }

    double veclength(){
        double sum = 0;
        for (int i = 0; i < length;i++){
             sum += Math.pow(vectorelements[i],2);
        }
        return Math.sqrt(sum);
    }

    void normalize(){

        div(length);
    }
}
