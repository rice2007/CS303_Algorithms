package labeight.hashmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import labutils.LabTimer;

public class HashmapDriver {

    public static void main(String[] args) {

        boolean exit = false;
        Hashmap csvMap = new Hashmap();
        LabTimer timer = new LabTimer();
        Scanner scan = new Scanner(System.in);
        String line;
        String v;
        String[] lineArray;

        try {
            scan = new Scanner(new File("C:\\Users\\Ajay\\Documents\\GitHub\\CS303_Algorithms\\src\\UPC.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            line = scan.nextLine();
            lineArray = line.split(",");
            csvMap.put(Integer.parseInt(lineArray[0]), lineArray[2]);
        }
        scan.close();

        while (!exit)
        {
            System.out.println("Select an option: ");
            System.out.println("1: put data");
            System.out.println("2: get data");
            System.out.println("3: exit \n");
            line = scan.nextLine();
            int i = Integer.parseInt(line);
            switch (i)
            {
                case 1:
                    System.out.println("Enter key: ");
                    line = scan.nextLine();
                    System.out.println("Enter value: ");
                    v = scan.nextLine();
                    csvMap.put(Integer.parseInt(line), v);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter key: ");
                    line = scan.nextLine();
                    timer.startTimer();
                    System.out.println(csvMap.get(Integer.parseInt(line)));
                    timer.stopTimer();
                    System.out.println();
                    break;

                case 3:
                    exit = true;
            }
        }
    }
}
