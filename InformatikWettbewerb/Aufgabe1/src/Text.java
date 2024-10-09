//the edit method lifes in here

public class Text extends Control
{
    public void edit()
    {
        //if NoIntersection is true, no action is needed
        //if NoIntersection is false, the original .txt file will be updated

        Game GameObject = new Game();           //create new Game object
        int currentIndex = Game.currentIndex;   //get current index from Game object
        int HopDistance = Game.HopDistance;     //get hop distance from Game object

        Control ControlObject = new Control();                  //create new Control object
        boolean noIntersection = ControlObject.noIntersection;  //get noIntersection flag from Control object
        String text = ControlObject.text;                       //get original text from Control object

        char IntersectionChar = '$';                            //set intersection character to '$'

        if (!noIntersection)                                    //function for inserting a '$' at the index of the inersection
        {
            int previousIndex = currentIndex - HopDistance;
            StringBuilder sb = new StringBuilder(text);
            sb.setCharAt(previousIndex, IntersectionChar);
            System.out.println(sb);
            String OutString = sb.concat();
        }
    }
}