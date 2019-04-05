package symboltable.graphs.undirectedgraph;

import queue.dynamicarray.QueueDynamicArray;
import queue.linkedlist.QueueLinkedList;
import stack.dynamicarray.StackArray;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s; //source vertex
    public BreadthFirstPaths(Graph g, int s) {

        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;

        bfs(g, s);
    }

    private void bfs(Graph g, int s) {

        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enQueue(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.deQueue();

            for (int w: g.adj(v)) {

                if (!marked[w]) {

                    queue.enQueue(w);
                    marked[w] = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        StackArray<Integer> path = new StackArray<>();

        for (int x=v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);

        return path;
    }
}
