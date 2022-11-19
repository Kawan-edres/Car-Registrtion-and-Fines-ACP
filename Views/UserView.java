package Views;

import Controllers.FinesController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class UserView {

  static void menu(PrintWriter out, BufferedReader in)
    throws ParseException, IOException {
    Scanner scan = new Scanner(System.in);

    String c;
    do {
      out.println("Welcome to the  Car Fines System ");
      out.println("------------------------------------");
      out.println("Choose What do you want :");
      out.println("1-Search for spesfic Car");
      out.println("2-Exit");
      out.println("k");
      c = in.readLine();
      switch (c) {
        case "1":
          out.println("Search For Spesfic Car Fines");
          out.println("Enter Type of Vehechle: truck or transport or private ");
          out.println("k");
          String typeToSearch = in.readLine();

          boolean check = true;
          while (check) {
            if (
              !(
                typeToSearch.equals("truck") ||
                typeToSearch.equals("private") ||
                typeToSearch.equals("transport")
              )
            ) {
              out.println("the type shuld be truck or private or transport");
              out.println("k");
              typeToSearch = in.readLine();
            } else {
              check = false;
              break;
            }
          }
          out.println("Enter Plate Number of Vehechle: ");
          out.println("k");
          int plateNumberForSearch = Integer.parseInt(in.readLine());
          FinesController.search(out, plateNumberForSearch, typeToSearch);
          break;
        case "2":
          out.println("exit");
        default:
          out.println("Choose on of the above options to start !");
          break;
      }
    } while (c != "2");
  }
}
