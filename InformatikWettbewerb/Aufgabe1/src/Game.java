import java.io.IOException;

public class Game extends Control {
    Game() throws IOException {
        Control ControlObject = new Control();
        ControlObject.setText();
    }

    private char getChar(int location) {
        // if location > string length
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
        latestHopDistance = jumpWidth;
        int destinationIndex = hops(startLocation, jumpWidth); // does the hopsing
        if (destinationIndex > textLength) { // controlls weather the text has no intersection
            noIntersection = true;  // sets the noIntersection flag
            intersection = 0; // sets the intersaction value to 0 to rebuild a save state
            return textLength;
        }
        return destinationIndex;
    }

    public int hops(int startLocation, int hopDistance) {
        boolean reachedDestination = false;
        int hopTargetIndex = hopDistance + startLocation;
        System.out.println("HopTargetIndex:"+ hopTargetIndex);
        int checkIndex = hopTargetIndex +1;
        System.out.println("CheckIndex:"+checkIndex);
        int currentIndex = startLocation;

        if (checkIndex >= textLength)
        {
            reachedDestination = true;
            System.out.println("Hopping stopped");
        }

        try {
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
        }catch (StringIndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());

        }

        return currentIndex;
    }
}



