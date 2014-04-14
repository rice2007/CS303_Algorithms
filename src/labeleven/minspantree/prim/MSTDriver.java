package labeleven.minspantree.prim;

import labnine.graph.WeightedGraph;
import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MSTDriver {

    public static void main(String[] args) throws IOException{

        LabTimer timer = new LabTimer();
        timer.startTimer();
        timer.stopTimer();

/*        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labeleven\\minspantree\\prim\\mediumGraph.txt"));
        WeightedGraph mGraph = new WeightedGraph(br);

        System.out.print("Medium timer Prim: ");
        timer.startTimer();
        PrimAlgorithm mpa = new PrimAlgorithm(mGraph);
        System.out.println(mpa);
        timer.stopTimer();


        System.out.print("Medium timer Kruskal: ");
        timer.startTimer();
        Kruskal mK = new Kruskal(mGraph);
        System.out.println(mK);
        timer.stopTimer();



        br = new BufferedReader(new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labeleven\\minspantree\\prim\\LargeGraph.txt"));
        WeightedGraph lGraph = new WeightedGraph(br);
        System.out.print("Large timer Prim: ");
        timer.startTimer();
        PrimAlgorithm lpa = new PrimAlgorithm(lGraph);
        System.out.println(lpa);
        timer.stopTimer();

        System.out.print("Large timer Kruskal: ");
        timer.startTimer();
        Kruskal lK = new Kruskal(lGraph);
        System.out.print(lK);
        timer.stopTimer();*/

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labeleven\\minspantree\\prim\\XtraLargeGraph.txt"));
        WeightedGraph xGraph = new WeightedGraph(br);
        System.out.print("XL timer Prim: ");
        timer.startTimer();
        PrimAlgorithm xpa = new PrimAlgorithm(xGraph);
        System.out.println(xpa);
        timer.stopTimer();


        System.out.print("XL timer Kruskal: ");
        timer.startTimer();
        Kruskal xK = new Kruskal(xGraph);
        System.out.println(xK);
        timer.stopTimer();

        br = new BufferedReader(new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labeleven\\minspantree\\prim\\tinyGraph.txt"));
        WeightedGraph tGraph = new WeightedGraph(br);
        System.out.println("Tiny timer Prim: ");
        timer.startTimer();
        PrimAlgorithm tpa = new PrimAlgorithm(tGraph);
        System.out.println(tpa);
        timer.stopTimer();

        System.out.println("Tiny timer Kruskal: ");
        timer.startTimer();
        Kruskal tK = new Kruskal(tGraph);
        System.out.println(tK);
        timer.stopTimer();

    }
}
