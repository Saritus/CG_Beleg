/**
 * Created by Matze on 03.05.16.
 */
public class Vector3D extends Vector
{
    @Override
    public double get(int pos) {
        if(pos > length)
            throw new IndexOutOfBoundsException();
        return super.get(pos);
    }

    Vector3D(){

        super(3);
    }
    Vector3D(double x, double y, double z){
        super(3);
        setPosition(x,y,z);
    }

    //Copy Constuctur

    public Vector3D(Vector3D vector3D){

        super(vector3D);
    }

    public void setPosition(double x, double y, double z){

        super.setPosition(new double[]{x,y,z});
    }

}
