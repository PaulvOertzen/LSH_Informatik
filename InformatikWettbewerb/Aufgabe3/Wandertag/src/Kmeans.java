import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Kmeans Algorythm that is utilized by TourGen Class
public class Kmeans {
    public List<Point> points;
    public List<Point> centroids;
    public int k;
    public int maxIterations;

    
    public Kmeans(List<Point> points, int k, int maxIterations) {
        this.points = points;
        this.k = k;
        this.maxIterations = maxIterations;
        this.centroids = new ArrayList<>();
    }

    private void initializeCentroids() {
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int randomIndex = random.nextInt(points.size());
            centroids.add(points.get(randomIndex));
        }
    }

    private List<Integer> assignClusters() {
        List<Integer> clusterAssignments = new ArrayList<>();
        for (Point point : points) {
            double minDistance = Double.MAX_VALUE;
            int clusterIndex = -1;
            for (int i = 0; i < centroids.size(); i++) {
                double distance = point.distance(centroids.get(i));
                if (distance < minDistance) {
                    minDistance = distance;
                    clusterIndex = i;
                }
            }
            clusterAssignments.add(clusterIndex);
        }
        return clusterAssignments;
    }

    private void updateCentroids(List<Integer> clusterAssignments) {
        List<Point> newCentroids = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            double sumX = 0;
            double sumY = 0;
            int count = 0;
            for (int j = 0; j < points.size(); j++) {
                if (clusterAssignments.get(j) == i) {
                    sumX += points.get(j).getX();
                    sumY += points.get(j).getY();
                    count++;
                }
            }
            if (count > 0) {
                newCentroids.add(new Point(sumX / count, sumY / count));
            } else {
                newCentroids.add(centroids.get(i)); // No points assigned to this cluster
            }
        }
        centroids = newCentroids;
    }

    public void run() {
        initializeCentroids();
        List<Integer> clusterAssignments;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            clusterAssignments = assignClusters();
            updateCentroids(clusterAssignments);
        }
    }

    public List<Point> getCentroids() {
        return centroids;
    }

    public List<Integer> getClusterAssignments() {
        return assignClusters(); // Return latest cluster assignments
    }    
}
