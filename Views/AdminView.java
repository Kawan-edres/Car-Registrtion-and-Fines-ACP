package Views;

import Addmin.AdminAccount;
import Controllers.FinesController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Scanner;

public class AdminView{
    static void menu(PrintWriter out, BufferedReader in) throws ParseException, IOException {
//        AdminAccount.Login();

        String c;
        do {
            out.println("Welcome Admin to the system   ");
            out.println("------------------------------------");
            out.println("Choose On bellow options to Login to the system  :");
            out.println("1-Fines System");
            out.println("2-Renew Annual System");
            out.println("3-Register new Car System");
            out.println("4-Exit");
            out.println("k");
            c = in.readLine();


            switch (c) {
                case "1":
                    out.println("Fines System");
                    FinesView.menu(out,in);
                    break;
                case "2":
                    out.println("Renew Annuall System");
                    RenewAnnualView.menu(out,in);
                    break;
                case "3":
                    out.println("New Car Registertion System");

                    break;
                case "4":
                    out.println("exit");
                default:
                    out.println("Choose on of the above options to start !");
                    break;

            }

        } while (c != "4");


    }


}
