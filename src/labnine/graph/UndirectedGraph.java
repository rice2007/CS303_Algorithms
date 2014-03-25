package labnine.graph;

import java.io.BufferedReader;
import java.io.IOException;

public class UndirectedGraph extends Graph {

    public UndirectedGraph(BufferedReader in) throws IOException {
        super(in);
        String[] str;
        for (int i = 0; i < e; i++) {
            str = in.readLine().split(" ");
            graph.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
        }
    }

    @Override
    public void addEdge(int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }
}
