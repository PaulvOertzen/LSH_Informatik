import java.util.*;

public class Main {

    public static void main(String[] args) {
        IO_functions iof = new IO_functions();
        iof.setFilePath("InformatikWettbewerb/Aufgabe2/files/schwierigkeiten0.txt");
        iof.readFile();
        // Create the graph and nodes
        Graph graph = new Graph();

        graph.BuildGraphByList(iof.getContent());

        // Print the graph and its dual
        graph.printGraph();

        // Perform topological sorting
        List<Node> nodes = new ArrayList<>(graph.getAllKeys());
        List<Node> topologicalOrder = TopologicalSort.topologicalSort(graph, nodes);

        // Output the topological sorted order
        if (!topologicalOrder.isEmpty()) {
            System.out.print("Topological Sort Order: ");
            for (Node node : topologicalOrder) {
                System.out.print(node + " ");
            }
        }
    }
}
