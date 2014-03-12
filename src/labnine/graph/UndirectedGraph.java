package labnine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(BufferedReader in) throws IOException {
        super(in);
    }

    @Override
    public void addEdge(int v, int w) {
        graph[v].add(w);
        graph[w].add(v);
    }
}
