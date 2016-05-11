package Schwarmverhalten;

import math.Vektor2D;
import org.lwjgl.opengl.Display;
import org.omg.PortableServer.THREAD_POLICY_ID;
import java.lang.Thread.*;


import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Matze on 10.05.16.
 */
public class Fonzies extends BasisObjekt
{

    public Fonzies(Vektor2D pos, Vektor2D geschwindigkeit, double masse) {
        super(pos, geschwindigkeit, masse);
        super.setBehavior(new Schwarmverhalten(this));
    }

    @Override
    public void render() throws Exception{
        //glColor3d(r, g, b);
        glBegin(GL_TRIANGLE_FAN);


        glVertex2f((float)pos.getElem(0)+50, (float)pos.getElem(1)-30);
        glColor3d(0,1,0);
        glVertex2f((float)pos.getElem(0)+50,(float)pos.getElem(1)+100);
        glColor3d(1,0,0);
        glVertex2f((float)pos.getElem(0)-50,(float)pos.getElem(1)+10);

        glEnd();



    }
}
