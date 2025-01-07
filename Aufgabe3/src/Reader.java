import java.io.*; //For all Input/Output Libs
import java.util.Scanner;

//Class Only Opens and reads the file and Saves the Datasets
public class Reader implements AutoCloseable {
    private File file; //The File class has no resources that need to be released, so there is no close() method and no need to close the instance.
    private BufferedReader bf = null; //This Instance has resources that have to be released
    private String path;
    private Scanner scanner = null; //scan for Filepath

    //Constructor that Creates Classwide Instance of BufferedReader
    public Reader() {
        scanner = new Scanner(System.in);
    }

    //Inits Buffered Reader with Path saven in Class
    public void InitBufferedReader() {
        try { //Because Filereader() throws FileNotFoundExeption
            bf = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //get Path from User and save in Class String Variable
    public void askPath() {
        System.out.print("Please enter Path to file: ");
        path = scanner.nextLine(); //Read given Path
        System.out.println("The given Path is: " + path);
    }

    //Opens the file at path saven in Class
    public boolean openFile() {
        this.file = new File(path); //Open File and save to Instance

        //Test if file exists, is a file, and readable
        if (!file.exists() && !file.isFile() && !file.canRead()) {
            return false; //File not readable
        }
        else {
            return true;  //File readable
        }
    }

    //Reads all the data from the file and saves it to 2Dim Array in Controll
    public void readDataFile(Control cInstance) {
        //This function must edit the 2dim Array in The Control instance, cInstance is always a Reference to my obj in Java
        try {
            int s = Integer.parseInt(bf.readLine());
            cInstance.distances = new int[s][2]; //Create 2dim Array with s - number of datasets; 2 - Min and Max are 2 ints
            for (int i = 0; i < s; i++) {
                String zeile = bf.readLine(); //GetLine
                String l[] = zeile.split(" "); //Splits Line in 2 at char " " and saves in Array
                //save in 2dmin array of given Reference of Control Class
                cInstance.distances[i][0] = Integer.parseInt(l[0]);
                cInstance.distances[i][1] = Integer.parseInt(l[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } //No finally statement because BufferedReader will be close in close() that is executed by try-with-resources
    }

    //Override Function of close() out of AutoCloseable Interface with try-with-resources
    @Override
    public void close() {
        //Closure of Buffered Reader that throws Exeption
        if (bf != null) {
            try {
                bf.close(); //Closes the buffered Reader again
            } catch (Exception e) {
                e.printStackTrace(); //Prints the catched error
            }
        }
        scanner.close(); //Close Scanner for Filepath
        System.out.println("Closed Succesfully");
    }
}
