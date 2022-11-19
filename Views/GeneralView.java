package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

public class GeneralView {

  //    public static void main(String[] args) throws ParseException {
  //        menu();
  //
  //    }

  public static void menu(PrintWriter out, BufferedReader in)
    throws ParseException, IOException {
    String c;
    do {
      out.println("Welcome to the  Car registertion and Fines System  ");
      out.println("------------------------------------");
      out.println("Choose On bellow options to Login to the system  :");
      out.println("1-Admin Login ");
      out.println("2-User Fines View ");
      out.println("3-Exit");
      out.println("k");
      c = in.readLine();

      switch (c) {
        case "1":
          AdminView.menu(out, in);
          break;
        case "2":
          UserView.menu(out, in);
          break;
        case "3":
          out.println("exit");
        default:
          out.println("Choose on of the above options to start !");
          break;
      }
    } while (c != "3");
  }
}
