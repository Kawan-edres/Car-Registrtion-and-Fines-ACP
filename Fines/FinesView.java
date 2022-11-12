package CarFines;


import Admin.AdminAccount;

import java.text.ParseException;
import java.util.Scanner;
public class FinesView {

    static Scanner scan = new Scanner(System.in);



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
            System.out.println("1-Add Fines ");
            System.out.println("2-Delete Fines");
            System.out.println("3-Display All Fines ");
            System.out.println("4-Search for spesfic Car");
            System.out.println("5-Exit");
            c = scan.next().charAt(0);


            switch (c) {
                case '1':
                    FinesController.addFinesData();
                    break;
                case '2':

                    System.out.println("Deleting a Fines ");
                    System.out.print("Enter Type of Vehechle: ");
                    String typeToDelete = scan.next();
                    System.out.print("Enter Plate Number of Vehechle: ");
                    int plateNumberToDelete = scan.nextInt();

                    FinesController.deleteFines(plateNumberToDelete, typeToDelete);
                    System.out.println("Deleted");
                    break;
                case '3':
                    System.out.println("Display All Fines");
                    FinesController.printFines();
                    break;


                case '4':
                    System.out.println("Search For Spesfic Car Fines");
                    System.out.print("Enter Type of Vehechle: ");
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
                case '5':
                    System.out.println("Exit...");
                default:
                    System.out.println("Choose on of the above options to start !");
                    break;

            }

        } while (c != '5');


    }


}
