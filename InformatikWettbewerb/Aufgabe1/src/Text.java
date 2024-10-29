/*import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Text extends Control
{
    public void hasIntersection() throws IOException {

        int Length = PositionPlayer1Arr.size();
        PositionPlayer1Arr.removeAll(PositionPlayer2Arr);
        System.out.println(PositionPlayer1Arr);

        if (Length == PositionPlayer1Arr.size())
        {
            System.out.println("No intersection found");
        } else
        {
            System.out.println("Intersection Found");
            noIntersection = false;
            intersection();
        }
    }

    public void intersection() throws IOException {
        int i = PositionPlayer1Arr.size();
        System.out.println(i);
        String sb;
        String OutputString;
        char IntersectionChar = '$';
        intersection = PositionPlayer1Arr.get(i / 2);
        sb = textString.substring(0, intersection) + IntersectionChar + textString.substring(intersection+ 1);
        OutputString = sb;
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test1.txt"));  //Cosntructor for a bufered writer
        writer.write(OutputString);
        writer.close();
    }
}*/