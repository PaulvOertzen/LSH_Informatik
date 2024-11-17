import java.util.*;

public class Main {

    public static void main(String[] args) {
        IO_functions iof = new IO_functions();
        iof.setFilePath("/home/paul/IdeaProjects/LSH_Informatik/InformatikWettbewerb/Aufgabe2/files/schwierigkeiten0.txt");
        iof.readFile();
        System.out.println("------------------------------------------------------");
        // Create the graph and nodes
        Graph graph = new Graph();

        graph.BuildGraphByList(iof.getContent());

        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');

        // Add edges to the graph (A->B, A->C, B->D, C->D, D->E)
        graph.addEdge(a, b);
        graph.addEdge(a, c);
        graph.addEdge(b, d);
        graph.addEdge(c, d);
        graph.addEdge(d, e);

        // Print the graph and its dual
        graph.printGraph();
        graph.printDualGraph();

        // Perform topological sorting
        List<Node> nodes = new ArrayList<>(List.of(a, b, c, d, e));
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
