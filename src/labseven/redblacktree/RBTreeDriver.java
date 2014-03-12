package labseven.redblacktree;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import labutils.LabTimer;

public class RBTreeDriver {

    public static void main(String[] args) {
        LabTimer timer = new LabTimer();
        RBTree<Long> csvTree = new RBTree<>();
        Scanner scan = null;
        String line;
        String[] lineArray;

        try {
            scan = new Scanner(new File("UPC.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scan != null;
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            line = scan.nextLine();
            lineArray = line.split(",");
            csvTree.insert(new RBNode<>(Long.parseLong(lineArray[0]), lineArray[1], lineArray[2], null, null));
        }
        scan.close();

        Scanner dat = new Scanner(System.in);
        try {
            dat = new Scanner(new
                    File("input.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (dat.hasNext()) {
            line = dat.nextLine();
            timer.startTimer();
            try {
                System.out.println(csvTree.search(Long.parseLong(line)));
            } catch (NumberFormatException e) {
                String exceptionSubvalue = line.substring(line.length() - 2, line.length());
                System.out.println(csvTree.search(Long.parseLong(exceptionSubvalue)));
            }
            timer.stopTimer();
        }
    }
}
