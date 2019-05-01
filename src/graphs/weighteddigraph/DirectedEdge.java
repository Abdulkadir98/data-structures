package graphs.weighteddigraph;

public class DirectedEdge implements Comparable<DirectedEdge> {

    private int v, w;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(DirectedEdge other) {
        if (this.weight < other.weight) return -1;
        else if (this.weight > other.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
