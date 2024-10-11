import java.io.*;
import java.util.HashMap;

public class Control {
    public static String textString;         // string which contains given text
    public int textLength;                  // int which gives the length of given text
    public int intersection;                // integer which is set to determine the point of intersection
    public boolean noIntersection;          // boolean which displays weather or not the given text has an intersection
    public int latestHopDistance;
    public static HashMap<Character, Integer> map = new HashMap<>();        // hashmap which defines character to jump width relations
    public Game game;
    public Text text;
    int player1Position = 0;
    int player2Position = 1;


    Control() {
        //map = new HashMap<>();
        fillHashMap();
        noIntersection = false;
        game = new Game();
        text = new Text();
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

    public static String setText(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/tobi/Dokumente/Dokumente/LSH-Marquartstein/Q12/Wahlkurs_Info/Div1/InformatikWettbewerb/Aufgabe1/TestTexts.txt")); // Directory where the .txt file is stored in, should be given at function call
        String input;
        String data = "";
        while ((input = reader.readLine()) != null)
        {
            data = data.concat(input);
        }
        reader.close();
        textString = data;
        return textString;
    }

    //functoin wich is called by main
    public void Run() {
        gameLoop();

        // reads text in 'text' value
        // runns 'the game loop'
        // starts edit
    }

    // the game loop
    public void gameLoop() {
        boolean run = true;

        while (run) {
            player1Position = game.movePlayer(player1Position);
            player2Position = game.movePlayer(player2Position);
        }

        // player 1 moves
        // player 2 moves
    }
    public void getPlayerPosition(int player1Position, int player2Position )
    {
        this.player1Position = player1Position;
        this.player2Position= player2Position;
    }

    public int getPlayer1Position()
    {
        return player1Position;
    }

    public int getPlayer2Position()
    {
        return player2Position;
    }

    public void export() throws IOException {

        Text TextObject = new Text();                    //Creating a new Text object
        String outputString = TextObject.OutputString;   //getting the output string from Text object

        BufferedWriter writer = new BufferedWriter(new FileWriter(""));  //Cosntructor for a buufered writer
        writer.write(outputString);  //writes the contence of outputString to the file
        writer.close();
    }


    public boolean hasIntersection()
    {
        if (player1Position == player2Position)
        {
            noIntersection = false;

        } else
        {
            noIntersection = true;
        }
        return noIntersection;
    }

    public int intersection()
    {
        if (!noIntersection)
        {
            int instersection = player1Position - latestHopDistance;
        }
        return intersection;
    }







}