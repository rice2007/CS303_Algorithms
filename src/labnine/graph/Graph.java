package labnine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Graph {

    int e;
    int v;
    LinkedList<Integer>[] graph;

    public Graph(BufferedReader in) throws IOException {
        v = Integer.parseInt(in.readLine());
        e = Integer.parseInt(in.readLine());
        graph = new LinkedList[e];
        for (int i = 0; i < e; i++) {
            graph[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {

    }

    public Iterable<Integer> adj(int v) {
        return graph[v];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v; i++) {
            sb.append("Vertex " + i + ": ");
            for (int j : graph[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
