package symboltable.graphs.undirectedgraph;

import stack.dynamicarray.StackArray;

public class DepthFirstPaths {

    private boolean marked[];
    private int edgeTo[];
    private int s;

    public DepthFirstPaths(Graph g, int s) {

        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

        dfs(g, s);
    }

    private void dfs(Graph g, int v) {

        marked[v] = true;
        for (int w: g.adj(v)) {

            if (!marked[w]){
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){

        if (!hasPathTo(v)) return null;
        StackArray<Integer> path = new StackArray<>();

        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
