package Schwarmverhalten;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import math.Vektor.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Matze on 27.05.16.
 */

/*
* Dieser Shader war nur zu Testzwecken.
* */
public class Shader
{

    public static void main(String[] args) {

        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.setTitle("Shader");
            Display.create();
        }
        catch (LWJGLException e){
            e.printStackTrace();
            Display.destroy();
        }

        int shaderProgramm = glCreateProgram();
        int vertexShader = glCreateShader(GL_VERTEX_SHADER);
        int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);


        StringBuilder vertexShaderSource = new StringBuilder();
        StringBuilder fragmentShaderSource = new StringBuilder();

        // Vertexshader
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Schwarmverhalten/shader.vert"));
            String line;
            while((line = reader.readLine())!= null){
                vertexShaderSource.append(line).append("\n");
            }
            reader.close();

        }
        catch (IOException e){
            System.err.println("Vertexshader wasnt loaded properly");
            Display.destroy();
        }
        // Fragmentshader
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Schwarmverhalten/shader.frag"));
            String line;
            while((line = reader.readLine())!= null){
                fragmentShaderSource.append(line).append("\n");
            }
            reader.close();

        }
        catch (IOException e){
            System.err.println("Fragmentshader wasnt loaded properly");
            Display.destroy();
        }
        // Lets go
        glShaderSource(vertexShader,vertexShaderSource);
        glCompileShader(vertexShader);
        System.out.println(glGetShaderInfoLog(vertexShader,1024));

        glShaderSource(fragmentShader,fragmentShaderSource);
        glCompileShader(fragmentShader);
        System.out.println(glGetShaderInfoLog(fragmentShader,1024));


        glAttachShader(shaderProgramm,vertexShader);
        glAttachShader(shaderProgramm,fragmentShader);
        glLinkProgram(shaderProgramm);
        glValidateProgram(shaderProgramm);



        while(!Display.isCloseRequested()){
            glClear(GL_COLOR_BUFFER_BIT);

            glUseProgram(shaderProgramm);


            glBegin(GL_TRIANGLE_FAN);
            glColor3f(1,0,0);
            glVertex2f(-0.5f, -0.5f);

            glColor3f(0,1,0);
            glVertex2f(0.5f,-0.5f);

            glColor3f(0,0,1);
            glVertex2f(0f,0.5f);
            glEnd();

            glUseProgram(0);


            Display.update();
            Display.sync(60);
        }




        glDeleteProgram(shaderProgramm);
        glDeleteShader(vertexShader);
        glDeleteShader(vertexShader);

        Display.destroy();
        System.exit(0);
    }


}
