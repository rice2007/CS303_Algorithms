package labeleven.minspantree.prim;

import labnine.graph.WeightedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Kruskal {

    private float totalWeight;
    private HashMap<Integer, Integer> kPath;
    private LinkedList<Integer> vSet;

    public Kruskal(WeightedGraph G) {
        kPath = new HashMap<>();
        vSet = new LinkedList<>();
        for (int i = 0; i < G.getV(); i++) {
            vSet.add(i);
        }
        MSTKruskal(G);
    }

    public void MSTKruskal(WeightedGraph G) {
        PriorityQueue<Float> wQueue = new PriorityQueue<>();
        for (int i = 0; i < G.getV(); i++) {
            for (float weight : G.edges(i)) {
                wQueue.add(weight);
            }
        }
        while (!vSet.isEmpty() || !wQueue.isEmpty()) {
            float weight = wQueue.remove();
            for (int i = 0; i < G.getV(); i++) {
                for (int vertex : vSet) {
                    if (weight == G.edges(i)) {
                        kPath.put(i, vertex);
                        totalWeight += weight;
                        vSet.remove(vertex);
                        break;
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer vertex : kPath.keySet()) {
            sb.append(vertex + " to ");
            sb.append(kPath.get(vertex) + "\n");
        }
        return sb.toString();
    }

}

