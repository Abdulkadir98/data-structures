package graphs.directedgraph;

import stack.dynamicarray.StackArray;

public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Digraph graph, int s) {

        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph, s);
    }

    private void dfs(Digraph graph, int v) {

        marked[v] = true;

        for (int w: graph.adj(v)) {

            if (!marked[w]) {
                dfs(graph, w);
                edgeTo[w] = v;
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!visited(v)) return null;

        StackArray<Integer> path = new StackArray<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);

        return path;
    }

    public boolean visited(int v){
        return marked[v];
    }

}
