//the edit method lifes in here

public class Text extends Control
{
    String sb;
    public String OutputString = sb;

    public void edit()
    {
        //if NoIntersection is true, no action is needed
        //if NoIntersection is false, the original .txt file will be updated

        int previousIndex = intersection ;
        char IntersectionChar = '$';

        if (!noIntersection)                                    //function for inserting a '$' at the index of the inersection
        {
            sb = textString.substring(0, previousIndex) + IntersectionChar + textString.substring(previousIndex + 1);
        }
    }
}