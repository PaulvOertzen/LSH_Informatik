import java.util.*;

public class TopologicalSort {

    // Topological sort for the directed graph
    public static List<Node> topologicalSort(Graph graph, List<Node> nodes) {
        Map<Node, Integer> inDegree = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        List<Node> topOrder = new ArrayList<>();

        // Initialize in-degree for all nodes
        for (Node node : nodes) {
            inDegree.put(node, 0);
        }

        // Calculate in-degree of each node
        for (Node node : nodes) {
            for (Node neighbor : graph.getNeighbors(node)) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        // Add nodes with zero in-degree to the queue
        for (Node node : nodes) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        // Process the nodes in the queue
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            topOrder.add(node);

            // Reduce in-degree of neighbors and add those with zero in-degree to the queue
            for (Node neighbor : graph.getNeighbors(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If the topological sort doesn't include all nodes, there's a cycle
        System.out.println(topOrder);
        if (topOrder.size() != nodes.size()) {
            System.out.println("Graph has a cycle. Topological sort not possible.");
            return new ArrayList<>();
        }

        return topOrder;
    }
}
