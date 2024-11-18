import java.util.List;
import java.util.ArrayList;

//Control class with all Data
public class Control {
    private List<Point> dataPoints = null; //Point List later used by TourGen and its tools
    private Reader reader = null; //Instance of Reader Class
    private TourGen tourgen = null;
    public int distances[][]; //Data given by Reader Class
    public double tours[]; //Finished Tours given by Tourgen
    private List<int[]> foundParticipants = null;
    
    //Constructer Creates new Instance of Reader Class
    public Control() {
        this.dataPoints = new ArrayList<>();
        this.foundParticipants = new ArrayList<>();
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
        
        //Search for matching Datasets
        this.findPeople();

        this.showData();
    }

    //Searches the entries which will participate in one of these tours
    public void findPeople() {
        //Diese Funktion macht: Nimmt einen Dataset, überprüft eine ausgerechnete Tour zischen 
        //min und max liegt wenn ja dann speicher er diese in die BufferArray welche dann zu der 
        //Liste hinzugefügt wird bei dem eintrag 1 für die Tour 1
        for (int i = 0; i < tours.length; i++) {
            for (int j = 0; j < distances.length; j++) {
                //If tours is in betwenn min and max of j. entry of distances
                if (this.tours[i] >= this.distances[j][0] && this.tours[i] <= this.distances[j][1]) {
                    this.foundParticipants.add(new int[]{i, j}); //Save Indeces of Tour and dataset in Distances
                } 
            }
        }
    }

    //Shows calculated Tours
    private void showData() {
        System.out.println("Showing calculated Tours... ");
        for (int i = 0; i < tours.length; i++) {
            System.out.println("Tour Number " + i + ": " + tours[i]);
        }
        System.out.println("Showing Matching Datasets to Tours...");
        for (int[] participant : foundParticipants) {
            //Get saved indeces to print them
            int tour = participant[0];
            int dataset = participant[1];
            System.out.println("Tour mit " + this.tours[tour] + "m liegt im Bereich von " + this.distances[dataset][0] + "m bis " + this.distances[dataset][1] + "m.");
        }
        //Print count of participants
        System.out.println("Insgesamt Teilnehmer: " + foundParticipants.size() + " von " + distances.length);
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
