package labtwelve.sssp;

import labnine.graph.WeightedGraph;
import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SSPathDriver {

    public static void main(String[] args) throws IOException {

        LabTimer timer = new LabTimer();

        BufferedReader br = new BufferedReader(
                new FileReader("tinyDG.txt"));
        WeightedGraph wGraph = new WeightedGraph(br);
        timer.startTimer();
        Dijkstra dPath = new Dijkstra(wGraph, 0);
        System.out.println(dPath);
        timer.stopTimer();

        br = new BufferedReader(
                new FileReader("mediumDG.txt"));
        WeightedGraph mGraph = new WeightedGraph(br);
        timer.startTimer();
        Dijkstra mPath = new Dijkstra(mGraph, 0);
        System.out.println(mPath);
        timer.stopTimer();

        br = new BufferedReader(
                new FileReader("largeDG.txt"));
        WeightedGraph lGraph = new WeightedGraph(br);
        timer.startTimer();
        Dijkstra lPath = new Dijkstra(lGraph, 0);
        System.out.println(lPath);
        timer.stopTimer();

        br = new BufferedReader(
                new FileReader("XtraLargeDG.txt"));
        WeightedGraph xGraph = new WeightedGraph(br);
        timer.startTimer();
        Dijkstra xPath = new Dijkstra(xGraph, 0);
        System.out.println(xPath);
        timer.stopTimer();
    }
}