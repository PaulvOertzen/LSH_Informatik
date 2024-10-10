//the edit method lifes in here

import com.sun.source.doctree.IndexTree;

public class Text extends Control
{
    public void edit()
    {
        //if NoIntersection is true, no action is needed
        //if NoIntersection is false, the original .txt file will be updated


        int currentIndex = intersection;   //get current index from Game object
        int HopDistance = latestHopDistance;     //get hop distance from Game object
        //get noIntersection flag from Control object

        char IntersectionChar = '$';                            //set intersection character to '$'

        if (!noIntersection)                                    //function for inserting a '$' at the index of the inersection
        {
            int previousIndex = currentIndex - HopDistance;
            String sb = textString;
            sb = textString.substring(0, previousIndex) + IntersectionChar + textString.substring(previousIndex + 1);
            System.out.println(sb);
            finalString = sb;
        }
    }
}