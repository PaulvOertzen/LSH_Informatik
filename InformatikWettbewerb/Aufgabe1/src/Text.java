public class Text extends Control {
    String text;
public int getChar(){
    String str = text;
    String text = str.replaceAll("[^a-zA-Z]", "");
        // Use regular expression to match all non-alphabetic characters and replace with empty string
    char[] charArray = new char[str.length()];
    str.getChars(0, str.length(), charArray, 0);
    return charArray.length;
}
    public void edit() {

    }

}
