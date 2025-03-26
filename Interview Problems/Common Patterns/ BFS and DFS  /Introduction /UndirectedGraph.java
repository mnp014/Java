import java.util.*;

public class UndirectedGraph {

    private Map<String, List<String>> adj = new HashMap<>();

    public void addEdge(String source, String destination) {
        adj.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adj.computeIfAbsent(destination, k -> new ArrayList<>()).add(source); // point back to source.
    }

    /**
     * Method to get neighbours.
     *
     * @param source source of neighbours.
     * @return neighbours of source.
     */
    public List<String> getNeighboursForNode(String source) {
        return adj.getOrDefault(source, new ArrayList<>());
    }

    /**
     * Breadth First Search.
     *
     * @param start starting point of BFS.
     */
    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                System.out.print(node + " ");
                visited.add(node);
                for (String neighbor : getNeighboursForNode(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    /**
     * Depth First Search.
     *
     * @param node starting point of BFS.
     */
    public void dfs(String node) {
        Set<String> visited = new HashSet<>();
        dfsHelper(node, visited);
    }

    private void dfsHelper(String node, Set<String> visited) {
        if (!visited.contains(node)) {
            System.out.print(node + " ");
            visited.add(node);
            for (String neighbor : getNeighboursForNode(node)) {
                dfsHelper(neighbor, visited);  // Recursive.
            }
        }
    }
}
