package Schwarmverhalten;
import org.lwjgl.opengl.Display;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL20.*;

/**
 * Created by Matze on 27.05.16.
 */
public class Shader2
{
    int shaderProgramm = glCreateProgram();
    int vertexShader = glCreateShader(GL_VERTEX_SHADER);
    int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

    public int getShaderProgrammVar() {
        return shaderProgramm;
    }

    public int getVertexShader() {
        return vertexShader;
    }

    public int getFragmentShader() {
        return fragmentShader;
    }


    public void getShaderProgramm(){

        shaderProgramm = glCreateProgram();
        vertexShader = glCreateShader(GL_VERTEX_SHADER);
        fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);

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



    }

    public void useShaderBeforeGL_Begin(){
        glUseProgram(shaderProgramm);
    }
    public void useShaderAfterGL_End(){
        glUseProgram(shaderProgramm);
    }
    public void deleteShader(){

        glDetachShader(shaderProgramm,vertexShader);
        glDetachShader(shaderProgramm,fragmentShader);
        glDeleteProgram(shaderProgramm);
        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);
    }

}
