package labnine.graph;

import labnine.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class WeightedGraph extends Graph {

    float[][] weight;

    public WeightedGraph(BufferedReader in) throws IOException {
        super(in);
        weight = new float[e][e];
        String[] str;
        for (int i = 0; i < e; i++) {
            str = in.readLine().split(" ");
            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
            weight[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = Float.parseFloat(str[2]);
        }
    }

    public float getWeight(int u, int v) {
        return weight[u][v];
    }
}
