package Views;

import Admin.AdminAccount;
import Controllers.FinesController;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        menu();

    }


    static void menu() throws ParseException {
        Scanner scan = new Scanner(System.in);
        char c;
        do {
            System.out.println("Welcome to the  Car registertion and Fines System  ");
            System.out.println("------------------------------------");
            System.out.println("Choose On bellow options to Login to the system  :");
            System.out.println("1-Admin Login ");
            System.out.println("2-User Fines View ");
            System.out.println("3-Exit");
            c = scan.next().charAt(0);


            switch (c) {
                case '1':
                    AdminView.menu();
                    break;
                case '2':

                    UserView.menu();


                    break;
                case '3':
                    System.out.println("Exit...");
                default:
                    System.out.println("Choose on of the above options to start !");
                    break;

            }

        } while (c != '3');


    }
}
