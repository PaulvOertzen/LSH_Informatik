//in der Text.java lebt die Methode edit();
public class Text extends Control
{
    public void edit()
    {
        //if NoIntersection is true, no action is needed
        //if NoIntersection is false, the original .txt file will be updated

        currentIndex();
        HopDistance();
        text();
        char IntersectionChar = "$$";
        String OutText = "";

        if (!noIntersection)
        {
               int prviousIndex = currentIndex - HopDistance;
               char PreviousChar = text.charAt(previousIndex);
               OutText = text.insertCharAt(text, IntersectionChar, previousIndex);
        }
    }
}