import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Control {
    public static String filepath;
    public static String textString;
    public int intersection;
    public static boolean stringIndexOutOfBounds = false;
    public static HashMap<Character, Integer> map = new HashMap<>();
    public Game game;
    int player1Position = 0;
    int player2Position = 1;

    ArrayList<Integer> positionPlayer1Array = new ArrayList<>();
    ArrayList<Integer> positionPlayer2Array = new ArrayList<>();

    public void control() {

        filePath();
        fillHashMap();
        setText();
        game = new Game();
        gameLoop();
    }

    public static String filePath() {
        System.out.println("Please specify a filepath");
        Scanner input = new Scanner(System.in);
        filepath = input.next();
        return filepath;
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

    public void gameLoop() {

        while (!stringIndexOutOfBounds) {

            player1Position = game.movePlayer(player1Position);
            positionPlayer1Array.add(player1Position);

            player2Position = game.movePlayer(player2Position);
            positionPlayer2Array.add(player2Position);

            if (stringIndexOutOfBounds)
            {
                IntersectionCheck();
            }
        }

        System.out.println(positionPlayer1Array);
        System.out.println("");
        System.out.println("");
        System.out.println(positionPlayer2Array);
    }

    public void IntersectionCheck() {
        myLoop:
        for (int i = 0; i < positionPlayer1Array.size(); i++)
        {
            for (int j = 0; j < positionPlayer2Array.size(); j++)
            {
                if (positionPlayer1Array.get(i) == positionPlayer2Array.get(j))
                {
                  intersection = positionPlayer1Array.get(i - 1);

                    System.out.println("Intersection found" + intersection);
                    IntersectionPlace(intersection);
                    break myLoop;
                } else {
                    System.out.println("Weite rgewhts du dummer nigger");
                }
            }
        }
    }

    public void IntersectionPlace(int intersection) {
        try {
            String output = textString.substring(0, intersection) + '$' + '$' + '$'  + textString.substring(intersection+ 1);
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            writer.write(output);
            writer.close();
        }catch (IOException f)
        {
            System.out.println("You have not specified a valid directory!");
        }
    }
}