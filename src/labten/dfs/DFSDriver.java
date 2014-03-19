package labten.dfs;

import labnine.graph.DirectedGraph;
import labnine.graph.UndirectedGraph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DFSDriver {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new FileReader("tinyDG.txt"));
        UndirectedGraph uGraph = new UndirectedGraph(br);
        System.out.println(uGraph.toString());
        DepthFirstPaths dfp = new DepthFirstPaths(uGraph, 0);
        for (int i = 0; i < uGraph.getV(); i++) {
            if (dfp.hasPathTo(i)) {
                System.out.println(dfp.getSource() + " to " + i + ": " + dfp.pathTo(i));
            }
        }
    }
}
