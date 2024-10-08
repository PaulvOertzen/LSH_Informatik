public class Game extends Control {
    private static int hops(int startLocation, int hopDistance) {

    }

    private static char getChar(int location) {
        character = text.charAt(location);
        return character;
    }

    //getJump*F* because of Function so it does not use a constructor name
    public int getJumpF(char character) {
        //Parameter is given by getChar(), when function is called
        //Goal: Look up what Index the character has and return
        // check weather some character is in the hashmap
        if (map.containsKey( char)){
            //look up character in Hasmap and same value
            int LengthOfJump = map.get(character);
        } else{
            // sets length to 0 to indicate that no character in the hashmap matches the given character
            int LengthOfJump = 0;
        }
        return LengthOfJump; //return value of HashMap
    }

    public char decapitaliseChar(char character) {

        return Character.toLowerCase(character);

    }
}