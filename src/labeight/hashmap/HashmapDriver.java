package labeight.hashmap;

import labeight.hashmap.*;

import java.util.Scanner;

public class HashmapDriver {

    public static void main(String[] args) {

        Hashmap map = new Hashmap();
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        String v;
        while (!exit)
        {
            System.out.println("Select an option: ");
            System.out.println("1: put data");
            System.out.println("2: get data");
            System.out.println("3: exit \n");
            String input = scan.nextLine();
            int i = Integer.parseInt(input);
            switch (i)
            {
                case 1:
                    System.out.println("Enter key: ");
                    input = scan.nextLine();
                    System.out.println("Enter value: ");
                    v = scan.nextLine();
                    map.put(Integer.parseInt(input), v);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter key: ");
                    input = scan.nextLine();
                    System.out.println(map.get(Integer.parseInt(input)));
                    System.out.println();
                    break;

                case 3:
                    exit = true;
            }
        }
    }
}
