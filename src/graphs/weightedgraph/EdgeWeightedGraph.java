package graphs.weightedgraph;

import graphs.undirectedgraph.Bag;

public class EdgeWeightedGraph {

    private Bag<Edge>[] adj;
    private int V;

    public EdgeWeightedGraph(int V) {

        adj = (Bag<Edge>[]) new Bag[V];
        this.V = V;

        for (int i=0; i<V; i++)
            adj[i] = new Bag<>();
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}
