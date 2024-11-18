import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Node, List<Node>> adjacencyListMap; // Adjacency list for the graph

    public Graph() {
        adjacencyListMap = new HashMap<>();
    }

    public List<Character> shrinkToOnlyValuesOfInterest(String toBeSplit) {
        List<Character> splitItems;
        splitItems = new ArrayList<>();
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
            List<Character> comparedItems = shrinkToOnlyValuesOfInterest(comparisonsList.get(i)); // removes everything from line that is junk
            int comparedItemsSize = comparedItems.size(); // values for loop length
            for (int x = 1; x < (comparedItemsSize); x++) {
                // creates Node objects for edges
                Node to = new Node(comparedItems.get(x));
                Node from = new Node(comparedItems.get(x - 1));
                this.addEdge(from, to); // adds edges to graph
            }
        }
    }

    public void addEdge(Node from, Node to) {
        adjacencyListMap.computeIfAbsent(from, _ -> new ArrayList<>()).add(to); // adds edge if not already present
    }

    public List<Node> getNeighbors(Node node) {
        return adjacencyListMap.getOrDefault(node, new ArrayList<>());
    }

    public ArrayList<Node> getAllKeys() {
        return new ArrayList<>(adjacencyListMap.keySet());
    }
}
