package graphs.undirectedgraph;

public class Graph {

    private int V;
    private int E;
    private Bag<Integer> adj[]; //Bag implemented using singly-linked list

    public Graph(int V) {
        this.V = V;
        this.E = 0;

        adj = (Bag<Integer>[]) new Bag[V];
        for (int v=0; v<V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }



}
