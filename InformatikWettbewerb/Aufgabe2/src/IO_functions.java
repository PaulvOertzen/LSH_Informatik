import java.io.*;
import java.util.*;

public class IO_functions {
    private String sourceFilePath;
    private ArrayList<String> sourceFileContent;

    IO_functions () {
        sourceFileContent = new ArrayList<String>();
    }
    public ArrayList getContent() {
        return this.sourceFileContent;
    }
    public void setFilePath(String path) {
        this.sourceFilePath = path;
    }
    public void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                sourceFileContent.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("file " + sourceFilePath + " was not found");
            //  e.printStackTrace();
        }
    }
}
