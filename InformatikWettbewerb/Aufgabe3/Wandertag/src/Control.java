//Control class with all Data
public class Control {
    int distances[][];
    Reader reader = null;

    //Constructer Creates new Instance of Reader Class
    public Control() {
        reader = new Reader();
    }

    //Runs test of Reader Class
    public void runtest() {
        reader.askPath();
        reader.openFile();
        reader.InitBufferedReader();
        reader.readDataFile(this);
        reader.close();

        System.out.println("Getting Datasets Done");
        this.showData();
    }

    //Shows all datasets in 2Dim array
    public void showData() {
        System.out.println("Showing Data...");
        for (int i = 0; i < distances.length; i++) {
            System.out.print("Set Number " + i + ": ");
            System.out.println(distances[i][0] + " & " + distances[i][1]);
        }
        System.out.println("Done Showing Data.");
    }

}
