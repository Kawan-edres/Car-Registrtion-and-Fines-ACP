

import java.util.Scanner;

public class AdminAccount {
    
    static Scanner scan= new Scanner(System.in);
    static String staticEmail="admin@gmail.com";
    static String staticPassword="12345";


    //instance
    private   String emaill;
    private String passwordd;

    public   AdminAccount( String email,String password){

        this.emaill=email;
        this.passwordd=password;
    }

    public static void Login(){
        System.out.print("enter yout email :");
        String emailInput =scan.next();
        System.out.print("enter your password :");
        String passwordInput =scan.next();

        String validEmail=emailInput.trim().toLowerCase();


        if(validEmail.contains("@") && validEmail.equals(staticEmail) && passwordInput.equals(staticPassword)){
            System.out.println("you are loggd in ");


        }
        else{
            System.out.println("email or passwor is not correct try again");
            Login();
        }


    }

    public String getEmail() {
        return emaill;
    }

    public void setEmail(String email) {
        this.emaill = email;
    }

    public String getPassword() {
        return passwordd;
    }

    public void setPassword(String password) {
        this.passwordd = password;
    }





    @Override
    public String toString() {
        return "AdminLogin{" +
                "email='" + emaill + '\'' +
                ", password='" + passwordd + '\'' +
                '}';
    }
}
