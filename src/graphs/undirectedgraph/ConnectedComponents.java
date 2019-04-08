package graphs.undirectedgraph;


/**
 * A data type that helps find all the connected components in a graph using dfs.
 * The type can be queried for connectivity in constant time
 */
public class ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents(Graph graph) {

        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        count = 0;

        for (int v=0; v<graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {

        marked[v] = true;
        id[v] = count;  // vertices in the same call of dfs have the same id, i.e they belong to the same component

        for (int w: graph.adj(v)) {
            if (!marked[w])
                dfs(graph, w);
        }
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

}
