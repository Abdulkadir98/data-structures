package graphs.weightedgraph;

import graphs.undirectedgraph.Bag;
import queue.linkedlist.QueueLinkedList;

public class EdgeWeightedGraph {

    private Bag<Edge>[] adj;
    private QueueLinkedList<Edge> edges = new QueueLinkedList<>();
    private int V;
    private int E;

    public EdgeWeightedGraph(int V) {

        adj = (Bag<Edge>[]) new Bag[V];
        this.V = V;
        E = 0;

        for (int i=0; i<V; i++)
            adj[i] = new Bag<>();
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        edges.enQueue(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Edge> edges() {
        return edges;
    }
}
