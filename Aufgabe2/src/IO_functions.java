import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO_functions {
    private final ArrayList<String> sourceFileContent;
    private String sourceFilePath;

    IO_functions() {
        sourceFileContent = new ArrayList<>();
    }

    public String getFilePath(String defaultValue) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("example path: " + defaultValue);
        System.out.print("Enter file path: ");

        String path = scanner.nextLine();
        if (path.isEmpty()) {
            path = defaultValue;
        }
        System.out.println("file '" + path + "' selected");
        return path;
    }

    public ArrayList<String> getContent() {
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
            boolean isDouplicate = false;
            for (Node usedNode : cleanList) {
                if (usedNode.value() == node.value()) {
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
