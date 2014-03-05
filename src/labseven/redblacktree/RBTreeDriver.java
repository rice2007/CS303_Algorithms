package labseven.redblacktree;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RBTreeDriver {

    public static void main(String[] args) {
 /*       RBTree<Integer> tree = new RBTree<>();
        System.out.println(tree.toString());

        RBNode<Integer> node = new RBNode<>(16);
        tree.insert(node);
        tree.insert(new RBNode<Integer>(10));
        tree.insert(new RBNode<Integer>(20));
        tree.insert(new RBNode<Integer>(7));
        tree.insert(new RBNode<Integer>(13));
        tree.insert(new RBNode<Integer>(18));
        tree.insert(new RBNode<Integer>(21));
        tree.insert(new RBNode<Integer>(14));
        tree.insert(new RBNode<Integer>(5));
        tree.insert(new RBNode<Integer>(3));
        tree.insert(new RBNode<Integer>(9));
        System.out.println(tree.toString());*/

        RBTree<Long> csvTree = new RBTree<>();
        Scanner scan = null;
        String line;
        String[] lineArray;
        try {
            scan = new Scanner(new File("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\labseven\\redblacktree\\UPC.csv"));
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
