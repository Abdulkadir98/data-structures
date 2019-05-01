package graphs.weightedgraph;

import edu.princeton.cs.algs4.IndexMinPQ;
import priorityqueue.MinPQ;
import queue.linkedlist.QueueLinkedList;

/**
 * Greedily adds minimum weight edge that has one end in the MST
 * time complexity: O(E Log E) worst case, where every edge gets added to the Priority Queue
 */

public class LazyPrimMST {

    private boolean[] marked;
    private MinPQ<Edge> pq;
    private QueueLinkedList<Edge> mst;


    public LazyPrimMST(EdgeWeightedGraph graph) {

        pq = new MinPQ<>(graph.E());
        mst = new QueueLinkedList<>();
        marked = new boolean[graph.V()];

        visit(graph, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue; // both vertices are in MST

            mst.enQueue(e);
            if (!marked[v]) visit(graph, v);
            if (!marked[w]) visit(graph, w);
        }

    }

    public Iterable<Edge> edges() {
        return mst;
    }

    private void visit(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for (Edge e: graph.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) {
                pq.insert(e);
            }

        }
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(8);
        graph.addEdge(new Edge(4, 5, 0.35));
        graph.addEdge(new Edge(4, 7, 0.37));
        graph.addEdge(new Edge(5, 7, 0.28));
        graph.addEdge(new Edge(0, 7, 0.16));
        graph.addEdge(new Edge(1, 5, 0.32));
        graph.addEdge(new Edge(0, 4, 0.38));
        graph.addEdge(new Edge(2, 3, 0.17));
        graph.addEdge(new Edge(1, 7, 0.19));
        graph.addEdge(new Edge(0, 2, 0.26));
        graph.addEdge(new Edge(1, 2, 0.36));
        graph.addEdge(new Edge(1, 3, 0.29));
        graph.addEdge(new Edge(2, 7, 0.34));
        graph.addEdge(new Edge(6, 2, 0.40));
        graph.addEdge(new Edge(3, 6, 0.52));
        graph.addEdge(new Edge(6, 0, 0.58));
        graph.addEdge(new Edge(6, 4, 0.93));

        LazyPrimMST mst = new LazyPrimMST(graph);
        for (Edge e: mst.edges()) {
            int v = e.either(), w = e.other(v);
            System.out.println(e);
        }

    }
}