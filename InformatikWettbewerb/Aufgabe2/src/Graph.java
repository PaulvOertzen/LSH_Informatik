import java.util.*;

public class Graph {
    private Map<Node, List<Node>> adjList; // Adjacency list for the graph
    private Map<Node, List<Node>> dualAdjList; // Adjacency list for the dual (reversed) graph

    public Graph() {
        adjList = new HashMap<>();
        dualAdjList = new HashMap<>();
    }
    public void BuildGraphByList(ArrayList comparisonsList) {
        for (int i = 1; i < comparisonsList.size() - 1; i ++)  // loops through lines of file but not the first and last one so only the comparison lines
        {
            comparisonsList.get(i);

        }
    }
    // Add a directed edge from 'from' to 'to'
    public void addEdge(Node from, Node to) {
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

        // Add the reverse edge for the dual graph
        dualAdjList.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }

    // Get neighbors of a node in the original graph
    public List<Node> getNeighbors(Node node) {
        return adjList.getOrDefault(node, new ArrayList<>());
    }

    // Get neighbors of a node in the dual (reversed) graph
    public List<Node> getDualNeighbors(Node node) {
        return dualAdjList.getOrDefault(node, new ArrayList<>());
    }

    // Display the graph
    public void printGraph() {
        System.out.println("Graph:");
        for (Node node : adjList.keySet()) {
            System.out.print(node + " -> ");
            for (Node neighbor : adjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Display the dual graph
    public void printDualGraph() {
        System.out.println("Dual Graph:");
        for (Node node : dualAdjList.keySet()) {
            System.out.print(node + " -> ");
            for (Node neighbor : dualAdjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
