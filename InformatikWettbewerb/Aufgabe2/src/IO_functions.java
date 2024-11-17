import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class IO_functions {
    private String sourceFilePath;
    private ArrayList<String> sourceFileContent;
    private String simplifiedFile;

    IO_functions () {
        sourceFileContent = new ArrayList<String>();
    }

    public void readFile() {
        try {
            File fileObject = new File(sourceFilePath);
            Scanner fileReader = new Scanner(fileObject);
            while (fileReader.hasNextLine()) {
                sourceFileContent.add(fileReader.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("file " + sourceFilePath + " was not found");
            //  e.printStackTrace();
        }
    }
    private void simplifyFile() {
        for (int i = 1; i < sourceFileContent.size()-1; i++){
            simplifiedFile.concat(sourceFileContent.get(i));
        }
    }
    public Graph fileToNode(Graph graph) {

    }
}
