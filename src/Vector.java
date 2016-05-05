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

    //Copy Constructor
    Vector(Vector vec){
        this.length = vec.length;
        this.vectorelements = vec.vectorelements.clone();
    }

    //Exceptionhandling in Vec2D + Vec3D
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

    void add(Vector vec){
        for (int i = 0; i < length;i++){
            if(Double.MAX_VALUE - this.vectorelements[i] <  vec.vectorelements[i])
                    throw new ArithmeticException();
            if(-Double.MAX_VALUE - this.vectorelements[i] >  vec.vectorelements[i])
                throw new ArithmeticException();
            this.vectorelements[i] += vec.vectorelements[i];
        }
    }
    // ########################### i need some help here
    void sub(Vector vec){
        for (int i = 0; i < length;i++ ){
            if(Double.MAX_VALUE-this.vectorelements[i] < vec.vectorelements[i]){
                throw new ArithmeticException();
            }
            if(-Double.MAX_VALUE + this.vectorelements[i] > vec.vectorelements[i]){
                throw new ArithmeticException();
            }
            vectorelements[i] -= vec.vectorelements[i];
        }
    }

    void mult(double scalar){

        for (int i = 0; i < length; i++){
            if(Double.MAX_VALUE/vectorelements[i] < scalar)
                throw new ArithmeticException();
            if(-Double.MAX_VALUE/vectorelements[i] > scalar)
                throw new ArithmeticException();
            vectorelements[i] *= scalar;
        }
    }

    void div(double scalar){
        if(scalar == 0){
            throw new ArithmeticException();
        }
        for (int i = 0; i < vectorelements.length;i++){
            if(scalar > 0 && scalar < 1){
                if(Double.MAX_VALUE*scalar < this.vectorelements[i]){
                throw new ArithmeticException();
                }
            }
            if(scalar > -1 && scalar < 0){
                if(-Double.MAX_VALUE*scalar < this.vectorelements[i]){
                    throw new ArithmeticException();
                }
            }
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
            if(Double.MAX_VALUE -vectorelements[i] < 0 ){
                throw new ArithmeticException();
            }
        }
        return Math.sqrt(sum);
    }

    void normalize(){

        div(length);
    }

    @Override
    public String toString() {
        String str = this.getClass() + " ";
        for (double vectorelement : vectorelements) {
            str += vectorelement+" ";
        }
        return str;
    }
}
