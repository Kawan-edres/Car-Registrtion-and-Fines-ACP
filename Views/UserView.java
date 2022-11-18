package Views;

import Controllers.FinesController;

import java.text.ParseException;
import java.util.Scanner;

public class UserView {


    static void menu() throws ParseException {
        Scanner scan = new Scanner(System.in);

        char c;
        do {
            System.out.println("Welcome to the  Car Fines System ");
            System.out.println("------------------------------------");
            System.out.println("Choose What do you want :");
            System.out.println("1-Search for spesfic Car");
            System.out.println("2-Exit");
            c = scan.next().charAt(0);


            switch (c) {
                case '1':
                    System.out.println("Search For Spesfic Car Fines");
                    System.out.print("Enter Type of Vehechle: truck or transport or private ");
                    String typeToSearch = scan.next();

                    boolean check = true;
                    while (check) {
                        if (!(typeToSearch.equals("truck") || typeToSearch.equals("private") || typeToSearch.equals("transport"))) {
                            System.out.println("the type shuld be truck or private or transport");
                            typeToSearch = scan.next();
                        } else {
                            check = false;
                            break;
                        }

                    }
                    System.out.print("Enter Plate Number of Vehechle: ");
                    int plateNumberForSearch = scan.nextInt();
                    FinesController.search(plateNumberForSearch, typeToSearch);
                    break;
                case '2':
                    System.out.println("Exit...");
                default:
                    System.out.println("Choose on of the above options to start !");
                    break;

            }

        } while (c != '2');


    }

}
