import java.util.List;
import java.util.ArrayList;

//Control class with all Data
public class Control {
    public int distances[][]; //Data given by Reader Class
    public List<Point> dataPoints = null; //Point List later used by TourGen and its tools
    private Reader reader = null; //Instance of Reader Class

    //Constructer Creates new Instance of Reader Class
    public Control() {
        this.reader = new Reader();
        this.dataPoints = new ArrayList<>();
    }

    //Converts the dinstances into a List
    public void convert2dimArraytoList() {
        for (int i = 0; i < distances.length; i++) {
            //creates, for every entry in distances, a point instance and adds it to the dataPoints list
            dataPoints.add(i, new Point(distances[i][0], distances[i][1]));
        }
    }

    //Runs test of Reader Class
    public void runtest() {
        reader.askPath();
        reader.openFile();
        reader.InitBufferedReader();
        reader.readDataFile(this);
        reader.close();

        //Convert
        this.convert2dimArraytoList();

        System.out.println("Getting Datasets Done");
        this.showData();
    }

    //Shows all datasets in 2Dim array
    public void showData() {
        System.out.println("Showing Data from 2dim Array...");
        for (int i = 0; i < distances.length; i++) {
            System.out.print("Set Number " + i + ": ");
            System.out.println(distances[i][0] + " & " + distances[i][1]);
        }
        System.out.println("Showing data from Arraylist...");
        //For Each point in dataPoints run getx and gety
        for (Point point : dataPoints) {
            System.out.println("x: " + point.getX() + " y: " + point.getY());
        }

        System.out.println("Done Showing Data.");
    }

}
