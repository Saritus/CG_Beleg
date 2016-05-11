package Schwarmverhalten;

import math.*;

/**
 * Created by Besitzer on 09.05.2016.
 */
public class ObjektManager {
    BasisObjekt[] objects;
    int count;

    ObjektManager() {

    }

    public void add(BasisObjekt obj) {
        BasisObjekt[] array = new BasisObjekt[objects.length+1];
        for (int i=0;i<objects.length;i++) {
            array[i]=objects[i];
        }
        array[objects.length]=obj;
        count++;
    }

    public boolean check(BasisObjekt obj) {
        return false;
    }

    public void remove(BasisObjekt obj) {

    }

    public BasisObjekt[] getObjects() {
        return objects;
    }

    public Vektor2D getAveragePosition() throws Exception{
        Vektor2D avgpos = new Vektor2D();
        for (int i=0;  i<this.count; i++) {
            avgpos.add(this.objects[i].pos);
        }
        avgpos.div(count);
        return avgpos;
    }
}
