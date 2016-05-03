/**
 * Created by Matze on 03.05.16.
 */
public class Vector2D extends Vector
{
    public Vector2D(){

        super(2);
    }

    public Vector2D(double x, double y){
        super(2);
        setPosition(x, y);
    }
    //Copy Constuctur
    public Vector2D(Vector2D vector2D){

        super(vector2D);
    }

    public void setPosition(double x, double y){

        super.setPosition(new double[]{x,y});
    }

}
