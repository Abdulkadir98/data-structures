package symboltable.graphs.undirectedgraph;

public class GraphDemo {

    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(2, 4);
        graph.addEdge(4, 3);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);

       for (int v=0; v < graph.V(); v++) {

           for (int w: graph.adj(v)) {
               System.out.print(w + " ");
           }
           System.out.println("\n");

       }
    }
}
