public class Game extends Control {
    //getJump*F* because of Function so it does not use a constructor name
    public int getJumpF(char character) {
        //Parameter is given by getChar(), when function is called
        //Goal: Look up what Index the character has and return

        //call Function fill Hashmap


        //look up character in Hasmap and same value
        int LengthOfJump = map.get(character);

        return LengthOfJump; //return value of HashMap
    }
    private static int hops(int startLocation, int hopDistance) {

    }
    public char decapitaliseChar(char character) {

        return Character.toLowerCase(character);

    }
    private static char getChar(int location) {
        character = text.charAt(location);
        return character;
    }
}