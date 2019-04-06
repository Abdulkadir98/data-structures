package symboltable.graphs.undirectedgraph;

public class GraphDemo {

    public static void main(String[] args) {

        Graph graph = new Graph(13);

        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);

        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println(cc.count());
        System.out.println(cc.connected(0, 7));
        System.out.println(cc.connected(7, 8));
        System.out.println(cc.connected(9, 12));
        System.out.println(cc.id(12));


      //DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
//        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
//      System.out.println(paths.hasPathTo(3));
//
//      for (int x: paths.pathTo(3)) {
//          System.out.print(x + " ");
//      }

    }
}
