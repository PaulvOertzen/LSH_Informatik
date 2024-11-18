import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IO_functions iof = new IO_functions();
        Graph graph = new Graph();
        iof.setFilePath(iof.getFilePath("Aufgabe2/files/schwierigkeiten0.txt"));
        iof.readFile();
        // Create the graph and nodes by content from file
        ArrayList<String> fileContent = iof.getContent();
        graph.BuildGraphByList(fileContent);
        // Perform topological sorting
        List<Node> nodes = new ArrayList<>(graph.getAllKeys());
        List<Node> topologicalOrder = TopologicalSort.topologicalSort(graph, nodes);
        // sorted without douplicates
        List<Node> sorted = iof.removedDuplicates(topologicalOrder);

        List<Character> wanted = graph.shrinkToOnlyValuesOfInterest(fileContent.getLast());

        //get wanted assigmnts
        List<Character> cleanSorted = new ArrayList<>();
        // remove unwanted
        for (Node node : sorted) {
            if (wanted.contains(node.getValue())) {
                cleanSorted.add(node.getValue());
            }
        }
        System.out.println("Sorted assignments:");
        System.out.println(cleanSorted);
    }
}
