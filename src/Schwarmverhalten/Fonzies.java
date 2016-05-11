package Schwarmverhalten;

import org.lwjgl.opengl.Display;
import org.omg.PortableServer.THREAD_POLICY_ID;
import java.lang.Thread.*;


import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Matze on 10.05.16.
 */
public class Fonzies extends BasisObjekt
{
    private float radius;
    private float r, g, b;

    public Fonzies() {
        this(0, 0, 20.0f, 1, 1, 0);
    }

    public Fonzies(float xPos, float yPos) {
        this(xPos, yPos, 30.0f, 1, 1, 0);
    }

    public Fonzies(float xPos, float yPos, float radius, float r, float g, float b) {
        super(xPos, yPos);
        this.radius = radius;
        this.r=r;
        this.g=g;
        this.b=b;
    }



    @Override
    public void render() {
        glColor3d(r, g, b);
        glBegin(GL_TRIANGLE_FAN);


        glVertex2f(xPos+50, yPos-30);
        glColor3d(0,1,0);
        glVertex2f(xPos+50,yPos+100);
        glColor3d(1,0,0);
        glVertex2f(xPos-50,yPos+10);

        glEnd();



    }
}
