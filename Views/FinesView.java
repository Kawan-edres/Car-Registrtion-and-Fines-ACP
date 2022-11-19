package Views;

import Addmin.AdminAccount;
import Controllers.FinesController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class FinesView {

  static Scanner scan = new Scanner(System.in);

  static void menu(PrintWriter out, BufferedReader in)
    throws ParseException, IOException {
    String c;
    do {
      out.println("Welcome to the  Car Fines System ");
      out.println("------------------------------------");
      out.println("Choose What do you want :");
      out.println("1-Add Fines ");
      out.println("2-Delete Fines");
      out.println("3-Display All Fines ");
      out.println("4-Search for spesfic Car");
      out.println("5-Exit");

      out.println("k");
      c = in.readLine();

      switch (c) {
        case "1":
          FinesController.addFinesData(out, in);
          break;
        case "2":
          out.println("Deleting a Fines ");
          out.println("Enter Type of Vehechle: ");
          out.println("k");
          String typeToDelete = in.readLine();
          out.println("Enter Plate Number of Vehechle: ");
          out.println("k");
          int plateNumberToDelete = Integer.parseInt(in.readLine());
          FinesController.deleteFines(plateNumberToDelete, typeToDelete);
          out.println("Deleted");
          break;
        case "3":
          out.println("Display All Fines");
          FinesController.printFines(out);
          break;
        case "4":
          out.println("Search For Spesfic Car Fines");
          out.println("Enter Type of Vehechle: ");
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
        case "5":
          out.println("exit");
        default:
          out.println("Choose on of the above options to start !");
          break;
      }
    } while (c != "5");
  }
}
