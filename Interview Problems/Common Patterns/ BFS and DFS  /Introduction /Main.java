//.............A............
//.........../...\..........
//..........B.....C.........
//......../...\.............
//.......D.....E............
//..........................
//
//  BFS: A B C D E
//  DFS: A B D E C

public class Main {
    public static void main(String[] args) {

        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");

        System.out.print("BFS: ");
        graph.bfs("A");         // start traversing from 'A'.
        System.out.println();

        System.out.print("DFS: ");
        graph.dfs("A");         // start traversing from 'A'.
    }
}
