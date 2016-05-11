package Schwarmverhalten;


import math.Vektor2D;

/**
 * Created by Matze on 10.05.16.
 */
public abstract class BasisObjekt
{
    public int id;
    public Vektor2D pos;
    public Vektor2D geschwindigkeit;
    public double masse;
    Behavior behavior;
    ObjektManager om;

    public BasisObjekt() throws Exception{
        this(new Vektor2D(), new Vektor2D(), 1);
    }

    public BasisObjekt(Vektor2D pos, Vektor2D geschwindigkeit, double masse){
        this.pos = pos.clone();
        this.geschwindigkeit = geschwindigkeit.clone();
        this.masse = masse;
    }

    public abstract void render() throws Exception;

    public void setBehavior(Behavior behavior) {
        this.behavior=behavior;
    }
}
