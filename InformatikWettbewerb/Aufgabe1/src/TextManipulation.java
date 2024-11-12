import java.io.*;
import java.util.Scanner;

public class TextManipulation extends Control {

    public String setText() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String inputText;
            String rawText = "";
            while ((inputText = reader.readLine()) != null) {
                rawText = rawText.concat(inputText);
            }
            reader.close();
            textString = rawText;
        } catch (IOException f) {
            System.out.println("You have not specified a valid directory");
            System.out.println("Please specify a filepath");
            Scanner input = new Scanner(System.in);
            filepath = input.next();
            setText();
        }
        return textString;
    }

    public void IntersectionPlace(int intersection) {
        try {
            String output = textString.substring(0, intersection) + '$' + textString.substring(intersection+ 1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(output);
            writer.close();
        }catch (IOException f)
        {
            System.out.println("You have not specified a valid directory!");
        }
    }
}
