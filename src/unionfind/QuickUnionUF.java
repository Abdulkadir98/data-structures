package unionfind;

/**
 * Quick union algorithm is used to solve the problem of dynamic connectivity in connected components
 *  union operation is performed in constant time
 * find operation can take O(N) in worst case if the tree is very tall
 */
public class QuickUnionUF {

    private int id[];

    public QuickUnionUF(int N) {

        id = new int[N];
        for (int i=0; i<N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q) {

        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j; //setting the root of p to be the child of the root of q
    }
}
