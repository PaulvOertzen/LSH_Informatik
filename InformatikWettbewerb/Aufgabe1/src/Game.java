public class Game extends Text_Manipulation {
    Game()  {}

    public int movePlayer(int startLocation)  {
        char respectiveChar = getChar(startLocation); // gets char at start location
        respectiveChar = decapitaliseChar(respectiveChar); // replaces capital with lower case letters
        int jumpWidth = getJump(respectiveChar);  // gets respective jump distance to respective char
        return hops(startLocation, jumpWidth);
    }

    private char getChar(int location) {
        return textString.charAt(location);
    }

    public char decapitaliseChar(char character) {
        return Character.toLowerCase(character);
    }

    public int getJump(char character) {
        //Parameter is given by getChar(), when function is called
        //Goal: Look up what Index the character has and return
        // check weather some character is in the hashmap
        int LengthOfJump;
        if (map.containsKey(character)) {
            LengthOfJump = map.get(character);
        } else {
            LengthOfJump = 0;
        }
        return LengthOfJump;
    }

    public int hops(int startLocation, int hopDistance)  {
        boolean reachedDestination = false;
        int hopTargetIndex = hopDistance + startLocation;
        int currentIndex = startLocation;

        while (!reachedDestination) {
            try
            {
                currentIndex += 1;
                char charAtIndex = decapitaliseChar(getChar(currentIndex));
                if (getJump(charAtIndex) == 0) {
                    hopTargetIndex++;
                }
                if (currentIndex >= hopTargetIndex) {
                    reachedDestination = true;
                }

            }catch (StringIndexOutOfBoundsException e)
            {
                reachedDestination = true;
                stringIndexOutOfBounds = true;
            }
        }
        return currentIndex;
    }
}