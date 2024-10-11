//the edit method lifes in here

import com.sun.source.doctree.IndexTree;

public class Text extends Control
{
    String sb;
    public String OutputString = sb;

    public void edit()
    {
        //if NoIntersection is true, no action is needed
        //if NoIntersection is false, the original .txt file will be updated

        Control ControlObject = new Control();                  //create new Control object
        boolean noIntersection = ControlObject.noIntersection;  //get noIntersection flag from Control object
        String text = textString;                               //get the original text which needs to be edited
        int previousIndex = intersection;

        int currentIndex = intersection;
        int HopDistance = latestHopDistance;

        char IntersectionChar = '$';

        if (!noIntersection)                                    //function for inserting a '$' at the index of the inersection
        {
            sb = text.substring(0, previousIndex) + IntersectionChar + text.substring(previousIndex + 1);
            System.out.println(sb);
        }
    }
}