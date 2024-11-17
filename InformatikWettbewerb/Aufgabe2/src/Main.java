import java.util.*;

public class Main {

    public static void main(String[] args) {
        IO_functions iof = new IO_functions();
        Graph graph = new Graph();
        iof.setFilePath("InformatikWettbewerb/Aufgabe2/files/schwierigkeiten1.txt");
        iof.readFile();
        // Create the graph and nodes by content from file
        List fileContent = iof.getContent();
        graph.BuildGraphByList((ArrayList<String>) fileContent);
        // Perform topological sorting
        List<Node> nodes = new ArrayList<>(graph.getAllKeys());
        List<Node> topologicalOrder = TopologicalSort.topologicalSort(graph, nodes);
        // sorted without douplicates
        List<Node> sorted = iof.removedDuplicates(topologicalOrder);

        List<Character> wanted = graph.shrinkToOnlyValuesOfInterest(fileContent.getLast().toString());

        //get wanted assigmnts
        List<Character> cleandedSorted = new ArrayList<>();
        // remove unwanted
        for (Node node : sorted) {
            if (wanted.contains(node.getValue())) {
                cleandedSorted.add(node.getValue());
            }
        }

        System.out.println(cleandedSorted.toString());
    }
}
