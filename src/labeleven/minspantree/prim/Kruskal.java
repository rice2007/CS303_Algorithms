package labeleven.minspantree.prim;

import labnine.graph.WeightedGraph;

import java.util.*;

public class Kruskal {

    private double totalWeight;
    private HashMap<Integer, ArrayList<Integer>> kPath;
    private LinkedList<Integer> A;
    private StringBuilder sb;

    public Kruskal(WeightedGraph G) {
        totalWeight = 0.0;
        kPath = new HashMap<>();
        A = new LinkedList<>();
        sb = new StringBuilder();
        sb.append("Kruskal's algorithm\n");
        for (WeightedGraph.Edge edge : G.sortedEdges()) {
            if (!A.contains(edge.getvTwo())) {
                A.add(edge.getvTwo());
                totalWeight += edge.getWeight();
                sb.append(edge.getvOne() + "-" + edge.getWeight() + "-" + ">" + edge.getvTwo() + " ");
            }
            if (A.size() == G.getV()) {
                break;
            }
        }
    }

    public String toString() {
        sb.append("\nTotal weight: " + totalWeight);
        return sb.toString();
    }


}

