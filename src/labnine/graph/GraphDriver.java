package labnine.graph;

import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphDriver  {

    public static void main(String[] args) throws IOException {
        LabTimer timer = new LabTimer();
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labnine\\graph\\largeG.txt"));
        DirectedGraph dGraph = new DirectedGraph(br);
        //System.out.println(dGraph.toString());
        BreadthFirstPath bf = new BreadthFirstPath(dGraph, dGraph.graph.get(235).getFirst());
        timer.startTimer();
        System.out.println("There is an edge from " + dGraph.graph.get(235).getFirst() + " to " + dGraph.graph.get(238)
                + ":" + bf.hasPathTo(245));
        timer.stopTimer();
        System.out.println("Distance from " + dGraph.graph.get(235).getFirst() + " to " + dGraph.graph.get(238) + ":"
                + bf.distTo(245));
        System.out.println(bf.pathTo(245));
    }
}
