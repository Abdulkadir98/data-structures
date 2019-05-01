package graphs.weighteddigraph;

import graphs.undirectedgraph.Bag;

public class EdgeWeightedDigraph {

    private Bag<DirectedEdge>[] adj;
    private int V;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int i=0; i<V; i++){
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        adj[v].add(edge);  // add edge to the adjacency list of vertex from which it's coming out
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }
}
