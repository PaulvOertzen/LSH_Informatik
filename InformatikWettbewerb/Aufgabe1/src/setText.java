import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class setText
{
    String text;
    public static void main (String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("")); // Directory where the .txt file is stored in
        String input;
        String data;
        while ((input = reader.readLine()) != null)
        {
            //System.out.println(input);
            data = data.concat(input);
        } reader.close();
        text = data;
    }
}