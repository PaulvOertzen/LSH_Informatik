public class Control //extends main
 {

    String text;    // string wich contains given text
    int textLength;     // int wich gives the length of given text
    int intersection; // integer wich is set to determine the point of intersection
    boolean noIntersection; // boolean wich dieplays weather or not the given text has an intersection
    private HashMap<Character, Integer> map; // hashmap wich defines character to jump width relations

    Control() {
        fillHashMap();
        map = new HashMap<>();
        noIntersection = false;
    }

    public static void setText(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("")); // Directory where the .txt file is stored in, should be given at function call
        String input;
        String data = "";
        while ((input = reader.readLine()) != null)
        {
            data = data.concat(input);
        }
        reader.close();
        String text = data;
    }

    //functoin wich is called by main
    public void Run() {
        // reads text in 'text' value

        // runns 'the game loop'

        // starts edit
    }

    // the game loop
    public void gameLoop() {
        // runs until end of text or intersection

        // player 1 moves
        // player 2 moves
        // checks for intersection

    }

    public void export() {

    } // saves 'text's string as .txt file

    public boolean hasIntersection() {
    }

    public int findIntersection() {
    }

    public void fillHashMap() {
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
}