public class Game extends Control {
    Game()  {}

    public int movePlayer(int startLocation)  {
        char currentPositionChar = getChar(startLocation); // gets char at start location
        int jumpWidth = getJump(currentPositionChar);  // gets respective jump distance to respective char
        return hops(startLocation, jumpWidth);
    }

    private char getChar(int location) {
        char characterAtPosition;
        characterAtPosition = textString.charAt(location);
        characterAtPosition = Character.toLowerCase(characterAtPosition);
        return characterAtPosition;
    }

    public int getJump(char character) {
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
        int currentIndex = startLocation;
        int hopTargetIndex = hopDistance + startLocation;

        while (!reachedDestination) {
            try {
                currentIndex++;
                char charAtIndex = getChar(currentIndex);
                if (getJump(charAtIndex) == 0) {
                    hopTargetIndex++;
                }
                if (currentIndex >= hopTargetIndex) {
                    reachedDestination = true;
                }

            }catch (StringIndexOutOfBoundsException e) {
                reachedDestination = true;
                stringIndexOutOfBounds = true;
            }
        }
        return currentIndex;
    }
}