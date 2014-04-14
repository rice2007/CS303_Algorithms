package labtwelve.sssp;

import labnine.graph.WeightedGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstra {

    private final int INFINITY = Integer.MAX_VALUE;
    private final int NIL = Integer.MIN_VALUE;
    private double totalWeight;
    private double[] distance;
    private int[] predecessor;
    private LinkedList<Integer> S;
    private LinkedList<Integer> Q;

    public Dijkstra(WeightedGraph G, int source) {
        totalWeight = 0;
        distance = new double[G.getV()];
        predecessor = new int[G.getV()];
        S = new LinkedList<>();
        Q = new LinkedList<>();

        initializeSingleSource(G, source);
        for (int i = 0; i < G.getV(); i++) {
            Q.add(i);
        }
        while(!Q.isEmpty()) {
            int u = extractMin(Q);
            S.add(u);
            for (int v : G.adj(u)) {
                relax(G, u, v);
            }
        }
        for (int i = 0; i < distance.length; i++) {
            totalWeight += distance[i];
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total weight: " + getTotalWeight());

        return sb.toString();
    }

    private void initializeSingleSource(WeightedGraph G, int source) {
        for (int i = 0; i < G.getV(); i++) {
            distance[i] = INFINITY;
            predecessor[i] = NIL;
        }
        distance[source] = 0;
    }

    private int extractMin(LinkedList<Integer> queue) {
        double weight = INFINITY;
        int vertex = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < weight) {
                weight = distance[i];
                vertex = i;
            }
        }
        return queue.remove(vertex);
    }

    private void relax(WeightedGraph G, int u, int v) {
        if (distance[v] > distance[u] + G.getWeight(u, v)) {
            distance[v] = distance[u] + G.getWeight(u, v);
            predecessor[v] = u;
        }
    }
}