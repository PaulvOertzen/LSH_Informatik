import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class setText
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("")); // Directory where the .txt file is stored in
        String input;

        while ((input = reder.readLine()) != null)
        {
            System.out.println(input);
        } reader.close();
    }
}