package labeleven.minspantree.prim;

import labnine.graph.WeightedGraph;
import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class primDriver {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("mediumGraph.txt"));
        WeightedGraph mGraph = new WeightedGraph(br);
        LabTimer timer = new LabTimer();
        timer.startTimer();
        System.out.print("Medium timer: ");
        PrimAlgorithm mpa = new PrimAlgorithm(mGraph);
        timer.stopTimer();

        br = new BufferedReader(new FileReader("LargeGraph.txt"));
        WeightedGraph lGraph = new WeightedGraph(br);
        timer.startTimer();
        System.out.print("Large timer: ");
        PrimAlgorithm lpa = new PrimAlgorithm(lGraph);
        timer.stopTimer();

        br = new BufferedReader(new FileReader("XtraLargeGraph.txt"));
        WeightedGraph xGraph = new WeightedGraph(br);
        timer.startTimer();
        System.out.print("XL timer: ");
        PrimAlgorithm xpa = new PrimAlgorithm(xGraph);
        timer.stopTimer();
    }
}
