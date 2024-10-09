public class Game extends Control {
    private static int hops(int startLocation, int hopDistance) {
        boolean reachedDestination = false;
        int hopTargetIndex = hopDistance + startLocation;
        int currentIndex = startLocation;
        while (!reachedDestination) {
            if (getJump(decapitaliseChar(getChar(currentIndex))) != 0) {
                currentIndex = currentIndex + 1;
            }
            if ((currentIndex == startLocation )|| currentIndex > textLength) {
                reachedDestination = true;

            }
        }
        return currentIndex;
    }

    // A acces modiffyer change for "hops" or its variables may be required
    ----------------------------------------------------------------

    private static char getChar(int location) {
        character = text.charAt(location);
        return character;
    }

    // takes a start index and follows the given rules to determine the end location
    public int movePlayer(int startLocation) {
        respectiveChar = getChar(startLocation); // gets char at start location
        respectiveChar = decapitaliseChar(respectiveChar); // replaces capital with snail case letters
        jumpWidth = getJump(respectiveChar);  // gets respective jump distance to respective char
        destinationIndex = hops(startLocation, jumpWidth); // does the hopsing
        if (destinationIndex >= textLength) { // controlls weather the text has no intersection
            noIntersection = true;  // sets the noIntersection flag
            intersection = 0; // sets the intersaction value to 0 to rebuild a save state
            return textLength;
        }
        noIntersectoin = false; // indicates that a intersection was found
        intersection = destinationIndex; //  sets intersection index
        return destinationIndex;
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