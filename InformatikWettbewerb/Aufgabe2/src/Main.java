import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public HashMap<Character, BooleanOfKeys> keyMap;
    public String comparisonsFromFile;
    public ArrayList<BooleanOfKeys> keyList;
    public static void main(String args[]) {
    }
    public void buildMap(){
        for (BooleanOfKeys key : keyList) {
            keyMap.put(key.getKey(), key);
        }
    }
}
