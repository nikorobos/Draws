package choose_from;

import java.io.*;
import java.util.*;

class KnuthCI {
  public static void main(String[] args) {
    boolean start = true;
    while (start) {
      ArrayList<String> list = new ArrayList<String>();

      Scanner scan = new Scanner(System.in);

      System.out.println(
          "Please type your input items \n -- type 1 item per line \n -- press ENTER for proceeding to the next line \n -- type END to complete your input list \n -- type exit to terminate the application");
      String input = scan.nextLine();
      if (input.equalsIgnoreCase("exit")) {
        System.exit(0);
      }
      while (!input.equalsIgnoreCase("END")) {
        list.add(input);
        input = scan.nextLine();

      }
      if (list.size() == 0) {
        System.out.println("No input provided. Please press ENTER to start over.");
        input = scan.nextLine();
        if (input.equalsIgnoreCase("exit")) {
          System.exit(0);
        }

      } else {
        System.out.println("You submitted " + list.size() + " input items");

        System.out.println("Number of items to select: " + "\n --type an integer number from 1 to " + list.size() + "");
        Scanner scan2 = new Scanner(System.in);

        if (scan2.hasNextInt()) {
          int user_num = scan2.nextInt();

          while (user_num == 0 || user_num > list.size()) {
            System.out.println("Please type an integer number from 1 to " + list.size());
            if (scan2.hasNextInt()) {
              user_num = scan2.nextInt();
            } else {
              String strg = scan2.next();
              if (strg.equalsIgnoreCase("exit")) {
                System.exit(0);
              }
            }
          }

          Random r = new Random();
          int length = list.size();
          int index = 1;

          for (int i = length - 1; i >= length - user_num; --i) {
            Collections.swap(list, i, r.nextInt(i + 1));
          }

          System.out.println("The following items were selected:");

          for (String items : list.subList(length - user_num, length)) {
            System.out.println((index++) + ". " + items);
          }
        } else {
          String strg = scan2.next();
          if (strg.equalsIgnoreCase("exit")) {
            System.exit(0);
          }
        }
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Run again? \n -- type yes for another run \n -- type no to exit");
        String repeat = scan3.nextLine();

        if (!repeat.equalsIgnoreCase("yes")) {

          System.exit(0);

        }
      }
    }

  }
}