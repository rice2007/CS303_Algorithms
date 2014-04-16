package labtwelve.sssp;

import labnine.graph.WeightedGraph;
import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SSPathDriver {

    public static void main(String[] args) throws IOException {

        LabTimer timer = new LabTimer();
        timer.startTimer();
        timer.stopTimer();

/*        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labtwelve\\sssp\\tinyDG.txt"));
        WeightedGraph tGraph = new WeightedGraph(br);

        System.out.println("Dijkstra tiny: ");
        timer.startTimer();
        Dijkstra dTiny = new Dijkstra(tGraph, 0);
        System.out.println(dTiny);
        timer.stopTimer();

        System.out.println("Bellman-Ford tiny: ");
        timer.startTimer();
        BellmanFord bfTiny = new BellmanFord(tGraph, 0);
        System.out.println(bfTiny);
        timer.stopTimer();

        br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labtwelve\\sssp\\mediumDG.txt"));
        WeightedGraph mGraph = new WeightedGraph(br);

        System.out.println("Dijkstra medium: ");
        timer.startTimer();
        Dijkstra dMedium = new Dijkstra(mGraph, 0);
        System.out.println(dMedium);
        timer.stopTimer();

        System.out.println("Bellman-Ford medium: ");
        timer.startTimer();
        BellmanFord bfMedium = new BellmanFord(mGraph, 0);
        System.out.println(bfMedium);
        timer.stopTimer();*/

        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labtwelve\\sssp\\largeDG.txt"));
        WeightedGraph lGraph = new WeightedGraph(br);

        System.out.println("Dijkstra large: ");
        timer.startTimer();
        Dijkstra dLarge = new Dijkstra(lGraph, 0);
        System.out.println(dLarge);
        timer.stopTimer();

        System.out.println("Bellman-Ford large: ");
        timer.startTimer();
        BellmanFord bfLarge = new BellmanFord(lGraph, 0);
        System.out.println(bfLarge);
        timer.stopTimer();

        br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labtwelve\\sssp\\XtraLargeDG.txt"));
        WeightedGraph xGraph = new WeightedGraph(br);

        System.out.println("Dijkstra XL: ");
        timer.startTimer();
        Dijkstra dX = new Dijkstra(xGraph, 0);
        System.out.println(dX);
        timer.stopTimer();

        System.out.println("Bellman-Ford XL: ");
        timer.startTimer();
        BellmanFord bfX = new BellmanFord(xGraph, 0);
        System.out.println(bfX);
        timer.stopTimer();
    }
}