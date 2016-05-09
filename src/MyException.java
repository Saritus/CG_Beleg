/**
 * Created by Matze on 07.05.16.
 */
public class MyException extends Exception
{
    MyException(){
        super("Fehler ist aufgetreten");
    }

    void überlauf(){

        System.out.println("Überlauf aufgetreten");
    }

    void divnull(){

        System.out.println("Es wird durch 0 dividiert");
    }
}
