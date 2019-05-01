package graphs.weighteddigraph;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph graph, int s) {

        edgeTo = new DirectedEdge[graph.V()];
        distTo = new double[graph.V()];
        pq = new IndexMinPQ<>(graph.V());

        for (int v=0; v<graph.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        pq.insert(s, 0.0);  //1st argument is index which is the vertex, 2nd is its weight

        while (!pq.isEmpty()) {
            int v = pq.delMin();

            for (DirectedEdge e: graph.adj(v)) {
                relaxEdge(e);
            }
        }
    }

    private void relaxEdge(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.getWeight()) {

            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

    public void shortestPath() {

        Stack<DirectedEdge> stack = new Stack<>();
        for (DirectedEdge e = edgeTo[6]; e != null; e = edgeTo[e.from()]) {
            stack.push(e);
            System.out.println(e);
        }

        //return stack;
    }

    public static void main(String[] args) {

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(16);

        graph.addEdge(new DirectedEdge(0, 1, 5));
        graph.addEdge(new DirectedEdge(0, 4, 9));
        graph.addEdge(new DirectedEdge(0, 7, 8));
        graph.addEdge(new DirectedEdge(1, 2, 12));
        graph.addEdge(new DirectedEdge(1, 3, 15));
        graph.addEdge(new DirectedEdge(1, 7, 4));
        graph.addEdge(new DirectedEdge(2, 3, 3));
        graph.addEdge(new DirectedEdge(2, 6, 11));
        graph.addEdge(new DirectedEdge(3, 6, 9));
        graph.addEdge(new DirectedEdge(4, 5, 4));
        graph.addEdge(new DirectedEdge(4, 6, 20));
        graph.addEdge(new DirectedEdge(4, 7, 5));
        graph.addEdge(new DirectedEdge(5, 2, 1));
        graph.addEdge(new DirectedEdge(5, 6, 13));
        graph.addEdge(new DirectedEdge(7, 5, 6));
        graph.addEdge(new DirectedEdge(7, 2, 7));


        DijkstraSP shortestPath = new DijkstraSP(graph, 0);
        shortestPath.shortestPath();
//        for (DirectedEdge e: shortestPath.shortestPath())
//            System.out.println(e);

    }
}
