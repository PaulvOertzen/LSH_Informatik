import java.util.List;

//Class that utilizes Kmeans to generate the 3 Tours/Products
import java.io*;
import java.util.*;

public class TourGen {
    public List<Point> dataPoints = null; 
    private Kmeans algorythmInstance = null;
    
    //Constuctor that saves  given dataset list
    public TourGen(List<Point> givenSets) {
        this.dataPoints = givenSets; 
        //Init Kmeans with datapoints, 3
        //this.algorythmInstance = new Kmeans(dataPoints, 3, 5)
    }

    public void runAlgo(int countCentroid, int maxIterations) {
          
    }

}