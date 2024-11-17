import java.util.*;

public class Graph {
    private Map<Character, List<Character>> map = new HashMap<>();
    private List<Character> visitedNodes;
    private List<Character> sortedNodes;

    public void addNode(Character node) {
        map.put(node, new LinkedList<Character>());
    }

    public void addEdge(Character sourceNode, Character destinationNode) {
        if (!map.containsKey(sourceNode)) {
            addNode(sourceNode);
        }
        if (!map.containsKey(destinationNode)) {
            addNode(destinationNode);
        }
        map.get(sourceNode).add(destinationNode);
    }

    private Character getSmallestNode() {
        return ('c');
    }

    private Boolean hasBeenVisited(Character node) {
        return (visitedNodes.contains(node));
    }

    private void addToVisited(Character node) {
        visitedNodes.add(node);
    }

    public Boolean traverseGraph(Character startNode, Character endNode) {
        ArrayList<List<Character>> availableNodes;
        availableNodes = new ArrayList<List<Character>>();
        // https://iq.opengenus.org/topological-sorting-dfs/
        return false;
    }
}
