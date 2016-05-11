package Schwarmverhalten;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

public class WeltDerFonzies extends BasisFenster {
    private Fonzies fonzie;

    public WeltDerFonzies() {
        super("Welt eines einsamen Fonzies", 1024, 680);
        fonzie = new Fonzies();
    }

    @Override
    public void renderLoop() {
        while (!Display.isCloseRequested()) {
            glClearColor(0.1f, 0.2f, 0.3f, 1);
            glClear(GL_COLOR_BUFFER_BIT);

            // ist ja 2d
            glMatrixMode (GL_PROJECTION);
            glLoadIdentity ();
            glOrtho (0, 640, 480, 0, 0, 1);
            glMatrixMode (GL_MODELVIEW);
            glDisable(GL_DEPTH_TEST);

            // einen Kreis anzeigen
            fonzie.render();

            Display.update();
        }
    }

    public static void main(String[] args) {
        new WeltDerFonzies().start();
    }
}

