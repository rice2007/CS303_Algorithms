package labtwelve.sssp;

import labnine.graph.WeightedGraph;

public class BellmanFord {

    private final int INFINITY = Integer.MAX_VALUE;
    private final int NIL = Integer.MIN_VALUE;
    private double totalWeight;
    private double[] distance;
    private int[] predecessor;

    public BellmanFord(WeightedGraph G, int source) {
        totalWeight = 0;
        distance = new double[G.getV()];
        predecessor = new int[G.getV()];
        initializeSingleSource(G, source);
        for (WeightedGraph.Edge edge : G.sortedEdges()) {
            relax(G, edge.getvOne(), edge.getvTwo());
        }
        negativeCycle(G);
        for (double aDistance : distance) {
            if (aDistance != INFINITY) {
                totalWeight += aDistance;
            }
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return ("Total weight: " + getTotalWeight());
    }

    private void initializeSingleSource(WeightedGraph G, int source) {
        for (int i = 0; i < G.getV(); i++) {
            distance[i] = INFINITY;
            predecessor[i] = NIL;
        }
        distance[source] = 0;
    }

    private void relax(WeightedGraph G, int u, int v) {
        if (distance[v] > distance[u] + G.getWeight(u, v)) {
            distance[v] = distance[u] + G.getWeight(u, v);
            predecessor[v] = u;
        }
    }

    private boolean negativeCycle(WeightedGraph G) {
        for (WeightedGraph.Edge edge : G.sortedEdges()) {
            if (distance[edge.getvTwo()] > distance[edge.getvOne()] + edge.getWeight()) {
                return false;
            }
        }
        return true;
    }
}
