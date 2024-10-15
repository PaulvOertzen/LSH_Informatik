public class Game extends Control {
    Game() {

    }

    private static char getChar(int location) {
        return textString.charAt(location);
    }

    public char decapitaliseChar(char character) {

        return Character.toLowerCase(character);
    }

    //getJump*F* because of Function so it does not use a constructor name
    public int getJump(char character) {
        //Parameter is given by getChar(), when function is called
        //Goal: Look up what Index the character has and return
        // check weather some character is in the hashmap
        int LengthOfJump;
        if (map.containsKey(character)) {
            //look up character in Hashmap and same value
            LengthOfJump = map.get(character);
        } else {
            // sets length to 0 to indicate that no character in the hashmap matches the given character
            LengthOfJump = 0;
        }
        return LengthOfJump; //return value of HashMap
    }

    public int movePlayer(int startLocation) {
        char respectiveChar = getChar(startLocation); // gets char at start location
        respectiveChar = decapitaliseChar(respectiveChar); // replaces capital with lower case letters
        int jumpWidth = getJump(respectiveChar);  // gets respective jump distance to respective char
        //System.out.println(jumpWidth);
        latestHopDistance = jumpWidth;
        int destinationIndex = hops(startLocation, jumpWidth); // does the hopsing
        if (destinationIndex >= textLength) { // controlls weather the text has no intersection
            noIntersection = true;  // sets the noIntersection flag
            intersection = 0; // sets the intersaction value to 0 to rebuild a save state
            return textLength;
        }
        noIntersection = false; // indicates that a intersection was found
        intersection = destinationIndex; //  sets intersection index
        return destinationIndex;
    }

    public int hops(int startLocation, int hopDistance) {
        boolean reachedDestination = false;
        int hopTargetIndex = hopDistance + startLocation; //hopDistance = latestHopDistance??? startlocation = Position (Player1/Player2)???
        int currentIndex = startLocation;

        while (!reachedDestination) {
            currentIndex += 1;
            char charAtIndex = decapitaliseChar(getChar(currentIndex));
            if (getJump(charAtIndex) == 0) {
                System.out.println(charAtIndex + "not valid");
                hopTargetIndex++;
            }
            if (currentIndex >= hopTargetIndex) {
                reachedDestination = true;
            }
            if (currentIndex > textLength){
                reachedDestination = true;
            }
            System.out.println(charAtIndex);
            System.out.println(currentIndex);
        }
        return currentIndex;
    }
}



