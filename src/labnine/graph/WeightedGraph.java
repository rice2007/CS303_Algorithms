package labnine.graph;

import labnine.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class WeightedGraph extends Graph {

    private float[][] weight;
    LinkedList<LinkedList<Float>> edges;

    public static class Edge extends HashMap<Integer, Float> {

        private final int vOne;
        private final int vTwo;
        private final float weight;

        public Edge(int first, int second, float edgeWeight) {
            vOne = first;
            vTwo = second;
            weight = edgeWeight;
            put(vTwo, weight);
        }

        public float getWeight() {
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
        weight = new float[e][e];
        edges = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            edges.add(i, new LinkedList<Float>());
            for (int j = 0; j < v; j++) {
                edges.get(i).add(j, null);
            }
        }
        String[] str;
        for (int i = 0; i < v; i++) {
            str = in.readLine().split(" ");
            Edge e = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Float.parseFloat(str[2]));
            Edge f = new Edge(Integer.parseInt(str[1]), Integer.parseInt(str[0]), Float.parseFloat(str[2]));
            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            weight[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Float.parseFloat(str[2]);
            addEdge(e);
        }
    }

    public float getWeight(int u, int v) {
        return weight[u][v];
    }

    public void addEdge(Edge e) {
        edges.get(e.getvOne()).set(e.getvTwo(), e.getWeight());
    }

    public LinkedList<Float> edges(int vertex) {
        return edges.get(vertex);
    }
}
