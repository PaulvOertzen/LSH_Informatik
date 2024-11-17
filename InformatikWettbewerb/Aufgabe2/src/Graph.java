import java.util.*;

public class Graph {
    private Map<Node, List<Node>> adjList; // Adjacency list for the graph

    public Graph() {
        adjList = new HashMap<>();
    }

    private List<Character> shrinkToOnlyValuesOfInterest(String toBeSplit) {
        List<Character> splitItems;
        splitItems = new ArrayList<Character>();
        for (Character item : toBeSplit.toCharArray()) {
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(item.toString())) {
                splitItems.add(item);
            }
        }
        return splitItems;
    }

    public void BuildGraphByList(ArrayList<String> comparisonsList) {
        for (int i = 1; i < (comparisonsList.size() - 1); i++)  // loops through lines of file but not the first and last one so only the comparison lines
        {
            List<Character> comparedItems = shrinkToOnlyValuesOfInterest(comparisonsList.get(i));
            int comparedItemsSize = comparedItems.size();
            System.out.println(comparedItems.toString() + (comparedItemsSize));
            for (int x = 1; x < (comparedItemsSize); x++) {
                System.out.println(comparedItems.get(x - 1).toString() + comparedItems.get(x).toString() + x);
                Node to = new Node(comparedItems.get(x));
                Node from = new Node(comparedItems.get(x - 1));
                this.addEdge(from, to);
            }
        }
    }

    // Add a directed edge from 'from' to 'to'
    public void addEdge(Node from, Node to) {
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);

            // Add the reverse edge for the dual graph
    }

    // Get neighbors of a node in the original graph
    public List<Node> getNeighbors(Node node) {
        return adjList.getOrDefault(node, new ArrayList<>());
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
    public ArrayList getAllKeys() {
        return new ArrayList<>(adjList.keySet());
    }
}
