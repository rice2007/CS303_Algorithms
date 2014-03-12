package labeight.hashmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import labseven.redblacktree.RBTreeDriver;
import labutils.LabTimer;

public class HashmapDriver {

    public static void main(String[] args) {
        boolean exit = false;
        Hashmap csvMap = new Hashmap();
        LabTimer timer = new LabTimer();
        Scanner dat = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        String line;
        String[] lineArray;

        try {
            scan = new Scanner(new File("UPC.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            line = scan.nextLine();
            lineArray = line.split(",");
            try {
                csvMap.put(Integer.parseInt(lineArray[0]), lineArray[2]);
            } catch (NumberFormatException e) {
                String exceptionSubvalue = lineArray[0].substring(lineArray[0].length() - 2, lineArray[0].length());
                csvMap.put(Integer.parseInt(exceptionSubvalue), lineArray[2]);
            }
        }
        scan.close();

        System.out.println("Hashmap performance: \n");
        try {
            dat = new Scanner(new File("input.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (dat.hasNext()) {
            line = dat.nextLine();
            timer.startTimer();
            try {
                System.out.println(csvMap.get(Integer.parseInt(line)));
            } catch (NumberFormatException e) {
                String exceptionSubvalue = line.substring(line.length() - 2, line.length());
                System.out.println(csvMap.get(Integer.parseInt(exceptionSubvalue)));
            }
            timer.stopTimer();
        }
        dat.close();

        System.out.println("----------------------------------- \n");
        System.out.println("RBTree performance: \n");
        RBTreeDriver.main(null);
    }
}
