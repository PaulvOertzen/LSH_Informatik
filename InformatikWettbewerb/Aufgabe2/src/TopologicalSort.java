import java.util.*;

public class TopologicalSort {

    public static List<Node> topologicalSort(Graph graph, List<Node> nodes) {
        Map<Node, Integer> degrees = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        List<Node> highestOrder = new ArrayList<>();

        for (Node node : nodes) {
            degrees.put(node, 0); // makes all nodes start at 0
        }
        for (Node node : nodes) {
            for (Node neighbor : graph.getNeighbors(node)) {
                degrees.put(neighbor, degrees.getOrDefault(neighbor, 0) + 1); // calculatoin of node degree
            }
        }
        for (Node node : nodes) {
            if (degrees.get(node) == 0) {
                queue.offer(node);  // adds nodes with 0 deg to queue
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            highestOrder.add(node);
            for (Node neighbor : graph.getNeighbors(node)) {
                degrees.put(neighbor, degrees.get(neighbor) - 1);
                if (degrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return highestOrder;
    }
}
