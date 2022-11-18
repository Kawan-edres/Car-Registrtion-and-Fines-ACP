package Views;

import Admin.AdminAccount;
import Controllers.FinesController;

import java.text.ParseException;
import java.util.Scanner;

public class AdminView {




    static void menu() throws ParseException {
        AdminAccount.Login();
        Scanner scan = new Scanner(System.in);
        char c;
        do {
            System.out.println("Welcome Admin to the system   ");
            System.out.println("------------------------------------");
            System.out.println("Choose On bellow options to Login to the system  :");
            System.out.println("1-Fines System");
            System.out.println("2-Renew Annual System");
            System.out.println("3-Register new Car System");
            System.out.println("4-Exit");
            c = scan.next().charAt(0);


            switch (c) {
                case '1':
                    System.out.println("Fines System");
                    FinesView.menu();
                    break;
                case '2':
                    System.out.println("Renew Annuall System");
                    RenewAnnualView.menu();
                    break;
                case '3':
                    System.out.println("New Car Registertion System");

                    break;
                case '4':
                    System.out.println("Exit...");
                default:
                    System.out.println("Choose on of the above options to start !");
                    break;

            }

        } while (c != '4');


    }


}
