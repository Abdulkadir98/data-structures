package graphs.weightedgraph;

public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {

        if (vertex == v) return w;
        return v;
    }

    @Override
    public int compareTo(Edge other) {
        if (this.weight < other.weight) return -1;
        else if (this.weight > other.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
