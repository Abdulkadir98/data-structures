package graphs.directedgraph;

import graphs.undirectedgraph.Bag;

public class Digraph {

    private int V;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;

        adj = (Bag<Integer>[]) new Bag[V];
        for (int v=0; v<V; v++)
            adj[v] = new Bag<>();

    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int V() {
        return V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
