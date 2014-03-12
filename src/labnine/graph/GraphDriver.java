package labnine.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphDriver  {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\Ajay\\IdeaProjects\\CS303_Algorithms\\src\\labnine\\graph\\tinyDG.txt"));
        DirectedGraph dGraph = new DirectedGraph(br);
        System.out.println(dGraph.toString());
    }
}
