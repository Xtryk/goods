import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        try
        {
            PrintWriter drukarz = new PrintWriter(new FileWriter(("done.txt")));

            drukarz.println((12345678));

            drukarz.close();

            drukarz = new PrintWriter(new FileWriter("done.txt", true));
            //drukarz.append("This is new password");
            drukarz.printf("The new password is: %d", 12345678);

            drukarz.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }



    }
}
