public static class Control{
    private HashMap<Character, Integer> map = new HashMap<>();
    String text;
    int textLaenge;
    Control(){
        fillHashMap();
    }
    public void export(){

    } // saves 'text's string as .txt file
    public boolean hasIntersection(){}
    public int findIntersection(){}
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
            int length = data.length();
            System.out.println(length);
        }
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

        //Talk about this again!!!
        //The Desc says, that the Hashmap returns 0 by default if Char is not found. But the Hops method must be so programmed
        //That it wont stay at the same character. If it programmed like this, then following 3 commands are unneccessary.
        map.put(' ', 1);
        map.put(',', 1);
        map.put('.', 1);
    }
}