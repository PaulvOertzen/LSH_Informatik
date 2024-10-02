import java.util.HashMap;
import java.util.Map; //needed for java.util.HashMap

//provided is a map wich maps any char to the corresponding integer,  this map is refferenced as charMap with type java.util.Map
//if the given char is not found in the charMap, the method returns 0 by value, so that the hops method can skip the given character(s)
//for understanding the map type, see https://www.geeksforgeeks.org/map-interface-java-examples/S
//use decapitalizeChar(char) and getChar(int) to make life easier

//The function getJumpF was put in a class, so the fillHashMap Function is at the same place as Function. Talk about this Structure again!!!
public class getJump {

    //Hashmap called map
    private HashMap<Character, Integer> map = new HashMap<>();

    //Fills the hashMap, run in constructor?
    private void fillHashMap() {
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

    //getJump*F* because of Function so it does not use a constructor name
    public int getJumpF(char character) {
        //Parameter is given by getChar(), when function is called
        //Goal: Look up what Index the character has and return

        //call Function fill Hashmap
        fillHashMap();

        //look up character in Hasmap and same value
        int LengthOfJump = map.get(character);

        return LengthOfJump; //return value of HashMap
    }
}