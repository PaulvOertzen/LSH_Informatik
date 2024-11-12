import java.util.List;
import java.util.ArrayList;

//Control class with all Data
public class Control {
    public int distances[][]; //Data given by Reader Class
    private List<Point> dataPoints = null; //Point List later used by TourGen and its tools
    private Reader reader = null; //Instance of Reader Class
    private TourGen tourgen = null;
    public double tours[]; //Finished Tours given by Tourgen

    //Constructer Creates new Instance of Reader Class
    public Control() {
        this.dataPoints = new ArrayList<>();
    }

    //Runs test of Reader Class
    public void runProgram() {
        //initReader 
        this.initReader();

        //Let the Reader Class do its things
        this.reader.askPath();
        this.reader.openFile();
        this.reader.InitBufferedReader();
        this.reader.readDataFile(this);
        this.reader.close();

        System.out.println("Getting Datasets Done!");

        //Convert list read by Reader
        this.convert2dimArraytoList();

        System.out.println("Converting Done!");

        //Run Algorythm
        initTourgen();
        this.tourgen.initKmeans();
        this.tourgen.runAlgorythm();
        this.tourgen.calculateTours(this);

        System.out.println("Algorythm Done!");
        
        this.showTours();
    }

    //Shows calculated Tours
    private void showTours() {
        System.out.println("Showing calculated Tours... ");
        for (int i = 0; i < tours.length; i++) {
            System.out.println("Tour Number " + i + ": " + tours[i]);
        }
        System.out.println("Done Showing Data.");
    }

    //Converts the dinstances into a List
    private void convert2dimArraytoList() {
        for (int i = 0; i < distances.length; i++) {
            //creates, for every entry in distances, a point instance and adds it to the dataPoints list
            dataPoints.add(i, new Point(distances[i][0], distances[i][1]));
        }
    }

    //InitReaderInstance
    private void initReader() {
        this.reader = new Reader();
    }
    
    //InitTourgenInstance
    private void initTourgen() {
        this.tourgen = new TourGen(dataPoints);
    }

    //Set value in tours for index i
    public void setTourAtIndex(double value, int index) {
        tours[index] = value;
    }
}
