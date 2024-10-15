//the edit method lifes in here

import java.io.IOException;

public class Text extends Control
{
    String sb;
    public String OutputString = sb;

    public void edit() throws IOException {
        Control ControlObject = new Control();

        int previousIndex = intersection;
        char IntersectionChar = '$';

        if (!noIntersection)                             //function for inserting a '$' at the index of the inersection
        {
            sb = textString.substring(0, previousIndex) + IntersectionChar + textString.substring(previousIndex + 1);
            ControlObject.export();
        }
    }
}