import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Control {
    public static String textString;         // string which contains given text
    public static int textLength;           // int which gives the length of given text
    public int intersection;                // integer which is set to determine the point of intersection
    public boolean noIntersection;          // boolean which displays weather or not the given text has an intersection
    public boolean run;
    public int latestHopDistance;
    public static HashMap<Character, Integer> map = new HashMap<>();        // hashmap which defines character to jump width relations
    public Game game;
    public Text text;
    int player1Position = 0;
    int player2Position = 1;

    ArrayList<Integer> PositionPlayer1Arr = new ArrayList<>();
    ArrayList<Integer> PositionPlayer2Arr = new ArrayList<>();

    public void control() throws IOException {

        noIntersection = true;
        game = new Game();
        text = new Text();
        fillHashMap();
        setText();
        TextLength();
        Run();
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
        BufferedReader reader = new BufferedReader(new FileReader("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestTexts/tst2.txt")); // Directory where the .txt file is stored in, should be given at function call
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


    //functoin wich is called by main
    public void Run() throws IOException {
        gameLoop();
    }



    //-----------------------------------------------------------------------------------------------------------------



    // the game loop
    public void gameLoop() throws IOException {
        run = true;
        while (run) {

            player1Position = game.movePlayer(player1Position); //player 1 moves                                                //
            PositionPlayer1Arr.add(player1Position);

            player2Position = game.movePlayer(player2Position); //player 2 moves                                                //
            PositionPlayer2Arr.add(player2Position);

            hasIntersection();



            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test2.txt"));  //Cosntructor for a bufered writer
            writer.write(String.valueOf(PositionPlayer1Arr));
            writer.newLine();
            writer.newLine();
            writer.write(String.valueOf(PositionPlayer2Arr));
            writer.close();

        }
    }

    public boolean hasIntersection() throws IOException {
        if (player1Position == player2Position)
        {
            run = false;
            noIntersection = false;
            intersection();
            System.out.println("Intersection found");
        } else
        {
            run = true;
        }
        return run;
    }

    public int intersection() throws IOException {
        if (!noIntersection)
        {
            intersection = player1Position - latestHopDistance;
            text.edit();
        }
        return intersection;
    }

    public void export(String outputString) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestResult/test1.txt"));  //Cosntructor for a bufered writer
        writer.write(outputString);
        writer.close();
    }
}