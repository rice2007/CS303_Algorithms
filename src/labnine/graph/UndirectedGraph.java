package labnine.graph;

import java.io.BufferedReader;
import java.io.IOException;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(BufferedReader in) throws IOException {
        super(in);
    }

    @Override
    public void addEdge(int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }
}
