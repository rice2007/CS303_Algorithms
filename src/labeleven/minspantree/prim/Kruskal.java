package labeleven.minspantree.prim;

import labnine.graph.WeightedGraph;

import java.util.*;

public class Kruskal {

    private double totalWeight;
    private StringBuilder sb;

    public Kruskal(WeightedGraph G) {
        totalWeight = 0.0;
        LinkedList<Integer> A = new LinkedList<>();
        sb = new StringBuilder();

        for (WeightedGraph.Edge edge : G.sortedEdges()) {
            if (!A.contains(edge.getvTwo())) {
                A.add(edge.getvTwo());
                totalWeight += edge.getWeight();
                sb.append(edge.getvOne()).append("-").append(edge.getWeight()).append("-")
                        .append(">").append(edge.getvTwo()).append(" ");
            }
            if (A.size() == G.getV()) {
                break;
            }
        }
    }

    public String toString() {
        sb.append("\nTotal weight: ").append(totalWeight);
        return sb.toString();
    }


}

