package labeleven.minspantree.prim;


import labnine.graph.Graph;
import labnine.graph.WeightedGraph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimAlgorithm {

    private final double[] key;
    private final int NIL = Integer.MIN_VALUE;
    private final int INFINITY = Integer.MAX_VALUE;
    private final int[] predecessor;
    private double totalWeight;
    private StringBuilder sb;


    public PrimAlgorithm(WeightedGraph G) {
        key = new double[G.getV()];
        predecessor = new int[G.getV()];
        sb = new StringBuilder();
        primAlgo(G, 0);
    }

    public void primAlgo(WeightedGraph G, int r) {
        for (int u = 0; u < G.getV(); u++) {
            key[u] = INFINITY;
            predecessor[u] = NIL;
        }
        key[r] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < G.getV(); i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int u = extractMin(queue);
            for (int v : G.adj(u)) {
                if (queue.contains(v) && G.getWeight(u, v) < key[v]) {
                    predecessor[v] = u;
                    key[v] = G.getWeight(u, v);
                }
            }
        }
        calculateWeight();
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public String toString() {
        sb.append("Prim's algorithm\n");
        sb.append(Arrays.toString(key));
        sb.append("\nTotal weight: " + totalWeight + "\n");
        return sb.toString();
    }

    private int extractMin(LinkedList<Integer> queue) {
        double weight = INFINITY;
        int vertex = 0;
        for (int i = 0; i < key.length; i++) {
            if (key[i] <= weight) {
                weight = key[i];
                vertex = i;
            }
        }
        return queue.remove(vertex);
    }

    private void calculateWeight() {
        for (int i = 0; i < key.length; i++) {
            if (key[i] != INFINITY) {
                totalWeight += key[i];
            }
        }
    }
}
