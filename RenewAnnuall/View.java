package RenewAnnual;


import Admin.AdminAccount;

import java.text.ParseException;
import java.util.Scanner;

public class View {


    static Scanner scan= new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        AdminAccount.Login();
        menu();

    }
    static void menu() throws ParseException {

        char c;
        do {
            System.out.println("Welcome to the  Car Fines System ");
            System.out.println("------------------------------------");
            System.out.println("Choose What do you want :");
            System.out.println("1-Add Annual ");
            System.out.println("2-Delete Annual");
            System.out.println("3-Display All Annual ");
            System.out.println("4-Search for spesfic Car");
            System.out.println("5-Exit");
            c = scan.next().charAt(0);


            switch (c) {
                case '1':
                    RenewController.addRenewAnnualData();
                    break;
                case '2':

                    System.out.println("Deleting a Annuals ");

                    System.out.print("Enter Plate Number of Vehechle: ");
                    int plateNumberDelete = scan.nextInt();

                    RenewController.delete(plateNumberDelete);


//
                    break;
                case '3':
                    System.out.println("Display All Annuals");
                    RenewController.print();
                    break;


                case '4':
                    System.out.println("Search For Spesfic Car Fines");
//
                    System.out.print("Enter Plate Number of Vehechle: ");
                    int plateNumberForSearch=scan.nextInt();
                    RenewController.search(plateNumberForSearch);
                    break;
                case '5':
                    System.out.println("Exit...");
                default:
                    System.out.println("Choose on of the above options to start !");
                    break;

            }

        } while (c != '5');

    }
}
