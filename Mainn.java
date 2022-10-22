
import java.util.Scanner;

public class Mainn {

    static Scanner scan= new Scanner(System.in);
    public static void menu(){
        System.out.println("Welcome to the car registration System and fines");
        System.out.println("enter one if you want to login : ->");
        System.out.println("1-Login ");
        int option=scan.nextInt();
        switch (option){
            case 1: AdminAccount.Login();

            break;
            default: break;


        }

    }

    public static void main(String[] args) {

        menu();



    }
}
