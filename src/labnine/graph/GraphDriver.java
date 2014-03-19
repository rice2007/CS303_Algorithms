package labnine.graph;

import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphDriver  {

    public static void main(String[] args) throws IOException {
        LabTimer timer = new LabTimer();
        BufferedReader br = new BufferedReader(
                new FileReader("mediumG.txt"));
        DirectedGraph dGraph = new DirectedGraph(br);
        BreadthFirstPath bf = new BreadthFirstPath(dGraph, dGraph.graph.get(2).getFirst());
        timer.startTimer();
        System.out.println("There is an edge from " + dGraph.graph.get(2).getFirst() + " to " + dGraph.graph.get(203)
                + ":" + bf.hasPathTo(203));
        timer.stopTimer();
        System.out.println("Distance from " + dGraph.graph.get(2).getFirst() + " to " + dGraph.graph.get(203) + ":"
                + bf.distTo(203));
        System.out.println(bf.pathTo(203));
        System.out.println();

        br = new BufferedReader(
                new FileReader("tinyDG.txt"));
        DirectedGraph dGraph2 = new DirectedGraph(br);
        System.out.println(dGraph2.toString());
        BreadthFirstPath bf2 = new BreadthFirstPath(dGraph2, dGraph2.graph.get(7).getFirst());
        timer.startTimer();
        System.out.println("There is an edge from " + dGraph2.graph.get(7).getFirst() + " to " + dGraph2.graph.get(5)
                + ":" + bf2.hasPathTo(5));
        timer.stopTimer();
        System.out.println("Distance from " + dGraph2.graph.get(7).getFirst() + " to " + dGraph2.graph.get(5) + ":"
                + bf2.distTo(5));
        System.out.println(bf2.pathTo(5));
        System.out.println();

        br = new BufferedReader(
                new FileReader("mediumG.txt"));
        DirectedGraph dGraph3 = new DirectedGraph(br);
        BreadthFirstPath bf3 = new BreadthFirstPath(dGraph3, dGraph3.graph.get(2).getFirst());
        timer.startTimer();
        System.out.println("There is an edge from " + dGraph3.graph.get(2).getFirst() + " to " + dGraph3.graph.get(203)
                + ":" + bf3.hasPathTo(203));
        timer.stopTimer();
        System.out.println("Distance from " + dGraph3.graph.get(2).getFirst() + " to " + dGraph3.graph.get(203) + ":"
                + bf3.distTo(203));
        System.out.println(bf3.pathTo(203));
    }
}
