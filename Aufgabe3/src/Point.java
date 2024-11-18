//Point Class that is needed by Kmeans
public class Point {
    private double x;
    private double y;

    //Constructor, that sets X,Y Instance Vars to given Parameters
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Returns X Position
    public double getX() {
        return x;
    }

    //Returns Y Position
    public double getY() {
        return y;
    }

    //Returns distance to another Point
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
