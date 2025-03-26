import java.util.*;

public class DirectedGraph {

    private Map<String, List<String>> adj = new HashMap<>();

    /**
     * Method to add edge.
     *
     * @param source      Source of edge to be added.
     * @param destination Destination of edge to be added.
     */
    public void addEdge(String source, String destination) {
        adj.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
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
     * ##### Breadth First Search. #####
     * #########################################################################
     * Given a starting node,
     * 1) Check if the node has been visited
     * 2) If not visited earlier, fetch it's neighbours and store it in "queue".
     * 3) For each of it's neighbours in queue, Check if the node has been visited.
     * 4) Repeat step 2 & 3 until all nodes are visited.
     * #########################################################################
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
     * ##### Depth First Search. #####
     * #########################################################################
     * Given a starting node,
     * 1) Check if the node has been visited
     * 2) If not visited earlier, fetch it's neighbours and store it in "stack".
     * 3) For each of it's neighbours in queue, Check if the node has been visited.
     * 4) Repeat step 2 & 3 until all nodes are visited.
     * #########################################################################
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
