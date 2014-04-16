package labnine.graph;

import labnine.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class WeightedGraph extends Graph {

    private double[][] weight;
    private LinkedList<Edge> vSet;

    public static class Edge extends HashMap<Integer, Double> {

        private final int vOne;
        private final int vTwo;
        private final double weight;

        public Edge(int first, int second, double edgeWeight) {
            vOne = first;
            vTwo = second;
            weight = edgeWeight;
            put(vTwo, weight);
        }

        public double getWeight() {
            return get(vTwo);
        }

        public int getvOne() {
            return vOne;
        }

        public int getvTwo() {
            return vTwo;
        }
    }

    public WeightedGraph(BufferedReader in) throws IOException {
        super(in);
        weight = new double[e][e];
        vSet = new LinkedList<>();
        for (int i = 0; i < e; i++) {
            vSet.add(new Edge(0, 0, Double.MIN_VALUE));
        }
        String[] str;
        for (int i = 0; i < e; i++) {
            str = in.readLine().replaceAll("(^\\s+|\\s+$)", "").split("\\s+");
            graph.get(Integer.parseInt(str[0].trim())).add(Integer.parseInt(str[1].trim()));
            weight[Integer.parseInt(str[0].trim())][Integer.parseInt(str[1].trim())] = Double.parseDouble(str[2].trim());
            sortWeights(new Edge(Integer.parseInt(str[0].trim()), Integer.parseInt(str[1].trim()),
                    Double.parseDouble(str[2].trim())));
        }
    }

    public double getWeight(int u, int v) {
        return weight[u][v];
    }

    public LinkedList<Edge> sortedEdges() {
        return vSet;
    }

    private void sortWeights(Edge edge) {
        if (vSet.get(0).getWeight() == Double.MIN_VALUE) {
            vSet.set(0, edge);
        } else if (vSet.get(1).getWeight() == Double.MIN_VALUE) {
            if (vSet.get(0).getWeight() < edge.getWeight()) {
                vSet.set(1, edge);
            } else {
                vSet.add(0, edge);
                vSet.remove(vSet.size() - 1);
            }
        } else {
            for (int i = 0; i < vSet.size() - 1; i++) {
                if (vSet.get(i).getWeight() > edge.getWeight()) {
                    vSet.add(i, edge);
                    vSet.remove(vSet.size() - 1);
                    break;
                } else if (vSet.get(i).getWeight() < edge.getWeight() && vSet.get(i + 1).getWeight() > edge.getWeight()) {
                    vSet.add(i + 1, edge);
                    vSet.remove(vSet.size() - 1);
                    break;
                } else if (vSet.get(i).getWeight() < edge.getWeight() && vSet.get(i + 1).getWeight() == Double.MIN_VALUE) {
                    vSet.set(i + 1, edge);
                    break;
                } else if (i == vSet.size() - 1) {
                    vSet.set(i, edge);
                }
            }
        }
    }
}