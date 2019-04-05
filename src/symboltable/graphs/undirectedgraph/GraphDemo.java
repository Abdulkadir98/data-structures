package symboltable.graphs.undirectedgraph;

public class GraphDemo {

    public static void main(String[] args) {

        Graph graph = new Graph(13);

        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);

      //DepthFirstPaths paths = new DepthFirstPaths(graph, 0);
        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);
      System.out.println(paths.hasPathTo(5));

      for (int x: paths.pathTo(6)) {
          System.out.print(x + " ");
      }

    }
}
