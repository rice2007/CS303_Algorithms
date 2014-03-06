package labseven.redblacktree;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RBTreeDriver {

    public static void main(String[] args) {
        RBTree<Long> csvTree = new RBTree<>();
        Scanner scan = null;
        String line;
        String[] lineArray;
        try {
            scan = new Scanner(new File("C:\\Users\\Ajay\\IdeaProjects\\CS303_Algorithms\\src\\labseven\\redblacktree\\UPC.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            line = scan.nextLine();
            lineArray = line.split(",");
            csvTree.insert(new RBNode<>(Long.parseLong(lineArray[0]), lineArray[1], lineArray[2], null, null));
        }
        scan.close();
        RBNode<Long> node = new RBNode<>(1090L);
        System.out.println(csvTree.search(node));



    }
}
