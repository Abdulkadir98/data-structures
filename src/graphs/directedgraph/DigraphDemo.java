package graphs.directedgraph;

public class DigraphDemo {
    public static void main(String[] args) {

        Digraph digraph = new Digraph(13);

        digraph.addEdge(4, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(6, 0);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 0);
        digraph.addEdge(11, 12);
        digraph.addEdge(12, 9);
        digraph.addEdge(9, 10);
        digraph.addEdge(9, 11);
        digraph.addEdge(7, 9);
        digraph.addEdge(10, 12);
        digraph.addEdge(11, 4);
        digraph.addEdge(4, 3);
        digraph.addEdge(3, 5);

//        for (int v=0; v<digraph.V(); v++) {
//            for (int w: digraph.adj(v))
//                System.out.println(v + " -> " + w);
//        }
        DepthFirstPaths dfs = new DepthFirstPaths(digraph, 9);
        for (int v: dfs.pathTo(2)) {
            System.out.print(v + " ");
        }
    }
}
