package Views;

import Controllers.RenewController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class RenewAnnualView {

  static Scanner scan = new Scanner(System.in);

  static void menu(PrintWriter out, BufferedReader in)
    throws ParseException, IOException {
    String c;
    do {
      out.println("Welcome to the  Car Fines System ");
      out.println("------------------------------------");
      out.println("Choose What do you want :");
      out.println("1-Add Annual ");
      out.println("2-Delete Annual");
      out.println("3-Display All Annual ");
      out.println("4-Search for spesfic Car");
      out.println("5-Exit");
      out.println("k");
      c = in.readLine();

      switch (c) {
        case "1":
          RenewController.addRenewAnnualData(out, in);
          break;
        case "2":
          out.println("Enter car type truck or transport or private :");
          out.println("k");
          String typeTodelete = in.readLine();
          boolean check = true;
          while (check) {
            if (
              !(
                typeTodelete.equals("truck") ||
                typeTodelete.equals("private") ||
                typeTodelete.equals("transport")
              )
            ) {
              out.println("the type should be truck or private or transport");
              out.println("k");
              typeTodelete = in.readLine();
            } else {
              check = false;
             
            }
          }
          out.println("Deleting a Annuals ");
          out.println("Enter Plate Number of Vehechle: ");
          out.println("k");
          int plateNumberDelete = Integer.parseInt(in.readLine());
          RenewController.delete(plateNumberDelete, typeTodelete);
          out.println("Deleted");
          break;
        case "3":
          out.println("Display All Annuals");
          RenewController.print(out);
          break;
        case "4":
          out.println("Search For Spesfic Car Fines");
          out.println("Enter Plate Number of Vehechle: ");
          out.println("k");

          int plateNumberForSearch = Integer.parseInt(in.readLine());
          out.println("Enter car type truck or transport or private :");
          out.println("k");
          String typeToSearch = in.readLine();
          boolean check2 = true;
          while (check2) {
            if (
              !(
                typeToSearch.equals("truck") ||
                typeToSearch.equals("private") ||
                typeToSearch.equals("transport")
              )
            ) {
              out.println("the type should be truck or private or transport");
              out.println("k");
              typeToSearch = in.readLine();
            } else {
              check2 = false;
              
            }
          }

          RenewController.search(out, plateNumberForSearch, typeToSearch);
          break;
        case "5":
          out.println("exit");
        default:
          out.println("Choose on of the above options to start !");
          break;
      }
    } while (!"5".equals(c));
  }
}
