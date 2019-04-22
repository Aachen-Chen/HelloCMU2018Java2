package CLeetCode;

import java.util.HashMap;

public class DisjointForest {
    public static void main(String[] args) {
        int[] v = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[][] e = new int[][]{
                new int[]{0, 1}, new int[]{0, 4}, new int[]{6, 8},
                new int[]{2, 1}, new int[]{5, 7},
                new int[]{3, 1}, new int[]{7, 8}
        };
//        DisjointSet set = new ForestDisjointSetTree(v, e);
        DisjointSet set = new ForestDisjointSetArray(v, e);
        System.out.println(String.format("0, 2, %s", String.valueOf(set.sameSet(0, 2))));
        System.out.println(String.format("0, 4, %s", String.valueOf(set.sameSet(0, 4))));
        System.out.println(String.format("0, 5, %s", String.valueOf(set.sameSet(0, 5))));
        System.out.println(String.format("5, 6, %s", String.valueOf(set.sameSet(5, 6))));
        System.out.println(String.format("0, 9, %s", String.valueOf(set.sameSet(0, 9))));
        System.out.println(String.format("5, 9, %s", String.valueOf(set.sameSet(5, 9))));
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Set of %d is %d", i, set.findSet(i)));
        }
        set.union(0, 5);
        System.out.println("Union");
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("Set of %d is %d", i, set.findSet(i)));
        }
    }
}

interface DisjointSet {
    /**
     * Make x a representative in a new set
     * @param x Element to be new set.
     */
    void makeSet(int x);
    void union(int x, int y);
    int findSet(int x);
    boolean sameSet(int x, int y);
}

class ForestDisjointSetArray implements DisjointSet{
    private int[] parent;
    private int[] rank;

    ForestDisjointSetArray(int[] v, int[][] e) {
        parent = new int[v.length];
        rank = new int[v.length];
        for (int vertex: v) makeSet(vertex);
        for (int[] edge: e) if (!sameSet(edge[0], edge[1])) union(edge[0], edge[1]);
    }

    @Override
    public void makeSet (int x) {
        parent[x] = x;
    }

    @Override
    public void union(int x, int y) {
        linkHead(findSet(x), findSet(y));
    }

    private void linkHead(int x, int y) {
        if (rank[x] > rank[y]) {
            parent[y] = parent[x];
        } else {
            parent[x] = parent[y];
            if (rank[x] == rank[y]) rank[y]++;
        }
    }

    @Override
    public int findSet (int x) {
        if (x != parent[x]) {
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    @Override
    public boolean sameSet(int x, int y) {
        return x == y || findSet(x) == findSet(y);
    }
}

class Node {
    int key;
    Node parent;
    int rank;
    Node(int k){
        key = k;
    }
}

class ForestDisjointSetTree implements DisjointSet {
    private HashMap<Integer, Node> map = new HashMap<>();

    ForestDisjointSetTree (int[] v, int[][] e) {
        for (int vertex: v) makeSet(vertex);
        for (int[] edge: e) if (!sameSet(edge[0], edge[1])) union(edge[0], edge[1]);
    }

    @Override
    public void makeSet (int x) {
        Node node = new Node(x);
        node.parent = node;
        node.rank = 0;
        map.put(x, node);
    }

    @Override
    public void union (int x, int y) {
        linkHead(findSet(map.get(x)), findSet(map.get(y))); // must be root node.
    }

    private void linkHead (Node headX, Node headY) {        // must use root node only.
        if (headX == headY) return;                         // MUST HAVE!
        if (headX.rank > headY.rank) {
            headY.parent = headX;
        } else {
            headX.parent = headY;
            if (headX.rank == headY.rank) {
                headY.rank++;
            }
        }
    }

    @Override
    public int findSet (int x) {
        return findSet(map.get(x)).key;
    }

    private Node findSet (Node x){
        if (x.parent != x) {
            x.parent = findSet(x.parent);
        }
        return x.parent;
    }

    @Override
    public boolean sameSet(int x, int y) {
        return x == y || findSet(x) == findSet(y);
    }
}


// ??????
class UnionFind {
    private int count;
    private int[] parent, rank;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {    // ???????????
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;         // !!!! avoid map[i][i] == 1 and double count--.
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        }
        else {
            parent[rootQ] = rootP;
            if (rank[rootP] == rank[rootQ]) {
                rank[rootP]++;
            }
        }
        count--;            // ????????????n-1???
    }

    public int count() {
        return count;
    }
}

class FriendCirclesUnionFind {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}