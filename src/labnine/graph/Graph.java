package labnine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Graph {

    int e;
    int v;
    LinkedList<LinkedList<Integer>> graph;

    public Graph() {
    }

    public Graph(BufferedReader in) throws IOException {
        v = Integer.parseInt(in.readLine());
        e = Integer.parseInt(in.readLine());
        graph = new LinkedList<>();
        for (int i = 0; i < e; i++) {
            graph.add(i, new LinkedList<Integer>());
        }
    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v) {
        return graph.get(v);
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public LinkedList<LinkedList<Integer>> getGraph() {
        return graph;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v; i++) {
            sb.append("Vertex " + i + ": ");
            for (int j : graph.get(i)) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
