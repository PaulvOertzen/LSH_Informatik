import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Control {
    public static String textString;         // string which contains given text
    public static int textLength;           // int which gives the length of given text
    public int intersection;                // integer which is set to determine the point of intersection
    public boolean run;
    public static boolean stringIndexOutOfBounds = false;
    public int latestHopDistance;
    public static HashMap<Character, Integer> map = new HashMap<>();        // hashmap which defines character to jump width relations
    public Game game;
    int player1Position = 0;
    int player2Position = 1;

    ArrayList<Integer> PositionPlayer1Arr = new ArrayList<>();
    ArrayList<Integer> PositionPlayer2Arr = new ArrayList<>();

    public void control() throws IOException {

        setText();
        game = new Game();
        fillHashMap();
        TextLength();
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
        run = true;
        while (run) {

            player1Position = game.movePlayer(player1Position); //player 1 moves
            PositionPlayer1Arr.add(player1Position);

            player2Position = game.movePlayer(player2Position); //player 2 moves
            PositionPlayer2Arr.add(player2Position);

            //Bedingung, wenn Spieler 1 String IndexOutOfBounds dann nur noch Spieler 2 bewegen, bis auch dieser StringIndexOutOfBounds ist

            run = false;

            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test2.txt"));  //Cosntructor for a bufered writer
            writer.write(String.valueOf(PositionPlayer1Arr));
            writer.newLine();
            writer.newLine();
            writer.write(String.valueOf(PositionPlayer2Arr));
            writer.close();

            if (stringIndexOutOfBounds)
            {
                run = false;
                hasIntersection();
            } else
            {
                run = true;
            }
        }
    }

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
            intersection();
        }
    }

    public void intersection() throws IOException {
        int i = PositionPlayer1Arr.size();
        String sb;
        char IntersectionChar = '$';
        intersection = PositionPlayer1Arr.get(i /2);
        sb = textString.substring(0, intersection) + IntersectionChar + textString.substring(intersection+ 1);
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test1.txt"));  //Cosntructor for a bufered writer
        writer.write(sb);
        writer.close();
    }
}