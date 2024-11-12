import java.util.ArrayList;
import java.util.List;

//Class that utilizes Kmeans to generate the 3 Tours/Products
public class TourGen {
    public List<Point> dataPoints = null; 
    private Kmeans algorythmInstance = null;
    private List<Point> finishedCrentroids = null;
    
    //Constuctor that saves  given dataset list
    public TourGen(List<Point> givenSets) {
        this.dataPoints = givenSets; 
        this.finishedCrentroids = new ArrayList<>();
    }

    //Inits Kmeans algorythm with standard settings
    public void initKmeans() {
        this.algorythmInstance = new Kmeans(dataPoints, 3, 5);
    }

    //Inits Kmeans algorythm with given count of Centroids
    public void initKmeans(int numberCentroids) {
        this.algorythmInstance = new Kmeans(dataPoints, numberCentroids, 5);
    }

    public void runAlgorythm() {
        //Run Algo
        algorythmInstance.run();
        this.finishedCrentroids = algorythmInstance.getCentroids();
    }

    //Calculate Tours and save into Control
    public void calculateTours(Control cInstance) {
        double numberBuffer = 0; //Buffer to save Result
        double bufferedX = 0;
        double bufferedY = 0;
        int counter = 0;

        //Initialise Array in Control
        cInstance.tours = new double[finishedCrentroids.size()];
        //For every point getX,Y and Median
        for (Point point : finishedCrentroids) {
            //Get X and Y from point in List
            bufferedX = point.getX();
            bufferedY = point.getY();
            //calculate Median from them
            numberBuffer = this.simpleMedian(bufferedX, bufferedY);
            //Save the result of Median in Tours list from Control Class Instance
            cInstance.setTourAtIndex(numberBuffer, counter);;
            counter++;
        }
    }

    //Simple Median Function of 2 Numbers
    private double simpleMedian(double a, double b) {
        double sum = a + b;
        double div = 2;
        return sum / div;
    }

}