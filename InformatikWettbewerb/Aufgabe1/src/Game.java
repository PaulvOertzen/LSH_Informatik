public class Game extends Control {
    Game()  {}

    public int movePlayer(int startLocation)  {
        char currentPositionChar = getChar(startLocation); // gets char at start location
        currentPositionChar = decapitalizeChar(currentPositionChar); // replaces capital with lower case letters
        int jumpWidth = getJump(currentPositionChar);  // gets respective jump distance to respective char
        return hops(startLocation, jumpWidth);
    }

    private char getChar(int location) {
        return textString.charAt(location);
    }

    public char decapitalizeChar(char character) {
        return Character.toLowerCase(character);
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
        int hopTargetIndex = hopDistance + startLocation;
        int currentIndex = startLocation;

        while (!reachedDestination) {
            try {
                currentIndex += 1;
                char charAtIndex = decapitalizeChar(getChar(currentIndex));
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