package labnine.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class DirectedGraph extends Graph {

    public DirectedGraph(BufferedReader in) throws IOException {
        super(in);
        String[] str;
        for (int i = 0; i < e; i++) {
            str = in.readLine().split(" ");
            graph[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
        }
    }

    @Override
    public void addEdge(int v, int w) {
        graph[v].add(w);
    }
}
