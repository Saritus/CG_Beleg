package Vector;

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
    void sub(Vector vec){
        for (int i = 0; i < length;i++){
            if(Double.MAX_VALUE - this.vectorelements[i] <  -vec.vectorelements[i])
                throw new ArithmeticException();
            if(-Double.MAX_VALUE - this.vectorelements[i] >  -vec.vectorelements[i])
                throw new ArithmeticException();
            this.vectorelements[i] -= vec.vectorelements[i];
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
        mult(1/scalar);
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
        double sum = 0.0;
        for (int i = 0; i < length;i++){
            sum += Math.pow(vectorelements[i],2);

            if((Double.MAX_VALUE/vectorelements[i]) < vectorelements[i] ){
                throw new ArithmeticException();
            }
            if(Double.MAX_VALUE/vectorelements[i] > -vectorelements[i]){
                throw new ArithmeticException();
            }
        }
        return Math.sqrt(sum);

    }


    void normalize(){
        double len = veclength();
        if(len == 0){
            throw new ArithmeticException();
        }
        div(len);

    }

    @Override
    public String toString() {
        String str =  "( "+vectorelements[0];
        for (double vectorelement : vectorelements) {
            str += ", "+vectorelement;
        }
        return str+" )";
    }
}
