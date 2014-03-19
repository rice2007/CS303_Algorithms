package labnine.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphDriver  {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labnine\\graph\\tinyDG.txt"));
        DirectedGraph dGraph = new DirectedGraph(br);
        System.out.println(dGraph.toString());
        BreadthFirstPath bf = new BreadthFirstPath(dGraph, dGraph.graph[7].getFirst());
        System.out.println("There is an edge from " + dGraph.graph[7].getFirst() + " to 5: " + bf.hasPathTo(5));
        System.out.println("Distance from " + dGraph.graph[7].getFirst() + " to 5: " + bf.distTo(5));
        System.out.println(bf.pathTo(5));
        BreadthFirstPath bf2 = new BreadthFirstPath(dGraph, dGraph.graph[7]);
        System.out.println("There is an edge from " + dGraph.graph[7].getFirst() + " to 5: " + bf2.hasPathTo(5));
        System.out.println("Distance from " + dGraph.graph[7].getFirst() + " to 5: " + bf2.distTo(5));
        System.out.println(bf2.pathTo(5));
    }
}
