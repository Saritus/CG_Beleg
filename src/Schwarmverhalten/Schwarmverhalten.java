package Schwarmverhalten;

import math.*;

public class Schwarmverhalten implements Behavior {

    private BasisObjekt obj;

    Schwarmverhalten(BasisObjekt obj) {
        this.obj = obj;
    }


    @Override
    public void update() throws Exception{
        Vektor2D beschleunigung = new Vektor2D();
        //  beschleunigung = ...
        Vektor2D alignment = new Vektor2D();
        Vektor2D cohesion = (Vektor2D) obj.om.getAveragePosition().sub(obj.pos);
        Vektor2D separation = new Vektor2D();
        //beschleunigung = LineareAlgebra.add(alignment, cohesion);
        obj.geschwindigkeit.add(beschleunigung);
        obj.pos.add(obj.geschwindigkeit);
    }
}
