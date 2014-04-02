package labeleven.minspantree.prim;


import labnine.graph.Graph;
import labnine.graph.WeightedGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    private final float[] key;
    private final int NIL = Integer.MIN_VALUE;
    private final int INFINITY = Integer.MAX_VALUE;
    private final int[] predecessor;

    public PrimAlgorithm(WeightedGraph G) {
        key = new float[G.getV()];
        predecessor = new int[G.getV()];
        primAlgo(G, 0);
    }

    public void primAlgo(WeightedGraph G, int r) {
        for (int u = 0; u < G.getV(); u++) {
            key[u] = INFINITY;
            predecessor[u] = NIL;
        }
        key[r] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(G.getV());
        for (int i = 0; i < G.getV(); i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v : G.adj(u)) {
                if (queue.contains(v) && G.getWeight(u, v) < key[v]) {
                    predecessor[v] = u;
                    key[v] = G.getWeight(u, v);
                }
            }
        }
    }

    public Iterable<Integer> path() {
        LinkedList<Integer> path = new LinkedList<>();
        float weight = 0;
        boolean edge = false;
        int sentinel = 0;
        for (int i = 0; i < key.length;) {
            for (int j = 0; j < predecessor.length; j++) {
                if (predecessor[j] == i && !edge) {
                    weight = key[j];
                    edge = true;
                    sentinel = j;
                } else if (predecessor[j] == i && edge) {
                    if (key[j] < key[sentinel]) {
                        weight = key[sentinel];
                        sentinel = j;
                    }
                }
                path.add(sentinel);
                i = sentinel;
            }
            edge = false;
        }
        return path;
    }
}
