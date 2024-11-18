import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO_functions {
    private String sourceFilePath;
    private final ArrayList<String> sourceFileContent;

    IO_functions() {
        sourceFileContent = new ArrayList<String>();
    }

    public String getFilePath(String defaultValue) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("example path: "+defaultValue);
        System.out.print("Enter file path: ");

        String path = scanner.nextLine();
        if (path == "") {
            path = defaultValue;
        }
        System.out.println("file '"+path+"' selected");
        return path;
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
            System.out.println("file '" + sourceFilePath + "'asa was not found, please reconsider your input");
            e.notify();
        }
    }

    public List<Node> removedDuplicates(List<Node> nodes) {
        List<Node> cleanList;
        cleanList = new ArrayList<>();
        for (Node node : nodes) {
            Boolean isDouplicate = false;
            for (Node usedNode : cleanList) {
                if (usedNode.getValue() == node.getValue()) {
                    isDouplicate = true;
                    break;
                }
            }
            if (!isDouplicate) {
                cleanList.add(node);
            }
        }
        return cleanList;
    }
}
