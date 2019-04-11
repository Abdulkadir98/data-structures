package graphs.directedgraph;

import queue.linkedlist.QueueLinkedList;
import stack.dynamicarray.StackArray;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Digraph graph, int s) {

        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;

        bfs(graph, s);
    }

    private void bfs(Digraph graph, int v) {

        QueueLinkedList<Integer> queue = new QueueLinkedList<>();
        queue.enQueue(v);
        marked[v] = true;

        while (!queue.isEmpty()) {
            int x = queue.deQueue();
            for (int w: graph.adj(x)) {
                if (!marked[w]) {

                    queue.enQueue(w);
                    marked[w] = true;
                    edgeTo[w] = x;
                }
            }
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {

        if (!visited(v)) return null;
        StackArray<Integer> path = new StackArray<>();

        for (int x=v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);

        return path;
    }
}
