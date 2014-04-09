package labeleven.minspantree.prim;

import labnine.graph.WeightedGraph;
import labutils.LabTimer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MSTDriver {

    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new FileReader("mediumGraph.txt"));
//        WeightedGraph mGraph = new WeightedGraph(br);
//        LabTimer timer = new LabTimer();
//        timer.startTimer();
//        System.out.print("Medium timer: ");
//        PrimAlgorithm mpa = new PrimAlgorithm(mGraph);
//        timer.stopTimer();
//
//        br = new BufferedReader(new FileReader("LargeGraph.txt"));
//        WeightedGraph lGraph = new WeightedGraph(br);
//        timer.startTimer();
//        System.out.print("Large timer: ");
//        PrimAlgorithm lpa = new PrimAlgorithm(lGraph);
//        timer.stopTimer();
//
//        br = new BufferedReader(new FileReader("XtraLargeGraph.txt"));
//        WeightedGraph xGraph = new WeightedGraph(br);
//        timer.startTimer();
//        System.out.print("XL timer: ");
//        PrimAlgorithm xpa = new PrimAlgorithm(xGraph);
//        timer.stopTimer();

        HashMap<Integer, WeightedGraph.Edge> map = new HashMap<>();
        map.put(10,new WeightedGraph.Edge(10, 15, 5));
        map.put(3,new WeightedGraph.Edge(3, 9, 6));
        map.put(18,new WeightedGraph.Edge(18, 54, 36));
        System.out.println(map.entrySet());
        System.out.println(map.get(10).get(15));

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labeleven\\minspantree\\prim\\tinyGraph.txt"));
        WeightedGraph mGraph = new WeightedGraph(br);
        Kruskal k = new Kruskal(mGraph);
        System.out.println(k);
    }
}
