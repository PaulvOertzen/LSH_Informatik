import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Control {
    public static String textString;
    public static int textLength;
    public int intersection;
    public static boolean stringIndexOutOfBounds = false;
    public int latestHopDistance;
    public static HashMap<Character, Integer> map = new HashMap<>();
    public Game game;
    int player1Position = 0;
    int player2Position = 1;

    ArrayList<Integer> positionPlayer1Array = new ArrayList<>();
    ArrayList<Integer> positionPlayer2Array = new ArrayList<>();

    public void control() throws IOException {

        setText();
        fillHashMap();
        TextLength();
        game = new Game();
        gameLoop();
    }

    public static void fillHashMap() {

        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
        map.put('i', 9);
        map.put('j', 10);
        map.put('k', 11);
        map.put('l', 12);
        map.put('m', 13);
        map.put('n', 14);
        map.put('o', 15);
        map.put('p', 16);
        map.put('q', 17);
        map.put('r', 18);
        map.put('s', 19);
        map.put('t', 20);
        map.put('u', 21);
        map.put('v', 22);
        map.put('w', 23);
        map.put('x', 24);
        map.put('y', 25);
        map.put('z', 26);
        map.put('ä', 27);
        map.put('ö', 28);
        map.put('ü', 29);
        map.put('ß', 30);
    }

    public String setText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestTexts/ChatGPT_Meer.txt")); // Directory where the .txt file is stored in, should be given at function call
        String inputtext;
        String rawtext = "";
        while ((inputtext = reader.readLine()) != null)
        {
            rawtext = rawtext.concat(inputtext);
        }
        reader.close();
        textString = rawtext;
        return textString;
    }

    public int TextLength()
    {
        return textLength = textString.length();
    }

    public void gameLoop() throws IOException {

        while (!stringIndexOutOfBounds) {

            player1Position = game.movePlayer(player1Position); //player 1 moves
            positionPlayer1Array.add(player1Position);

            player2Position = game.movePlayer(player2Position); //player 2 moves
            positionPlayer2Array.add(player2Position);

            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test2.txt"));  //Cosntructor for a bufered writer
            writer.write(String.valueOf(positionPlayer1Array));
            writer.newLine();
            writer.newLine();
            writer.write(String.valueOf(positionPlayer2Array));
            writer.close();

            if (stringIndexOutOfBounds)
            {
                hasIntersection();
            }
        }
    }

    public void hasIntersection() throws IOException {

        int positionPlayer1ArrayLength = positionPlayer1Array.size();
        positionPlayer1Array.removeAll(positionPlayer2Array);
        System.out.println(positionPlayer1Array);

        if ( positionPlayer1ArrayLength == positionPlayer1Array.size())
        {
            System.out.println("No intersection found");
        } else
        {
            System.out.println("Intersection Found");
            intersection();
        }
    }

    public void intersection() throws IOException {
        int i = positionPlayer1Array.size();
        String sb;
        char IntersectionChar = '$';
        intersection = positionPlayer1Array.get(i /2);
        sb = textString.substring(0, intersection) + IntersectionChar + textString.substring(intersection+ 1);
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test1.txt"));
        writer.write(sb);
        writer.close();
    }
}