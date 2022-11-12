package Addmin;
import java.util.Scanner;
import java.io.*;

public class AdminAccount {

    static Scanner scan = new Scanner(System.in);


    // instance
    private String emaill;
    private String passwordd;

    public AdminAccount(String email, String password) {

        this.emaill = email;
        this.passwordd = password;
    }

    public static void Login() {
        System.out.print("enter yout email :");
        String emailInput = scan.next();
        System.out.print("enter your password :");
        String passwordInput = scan.next();

        String validEmail = emailInput.trim().toLowerCase();

        try{
            BufferedReader br= new BufferedReader(new FileReader("admin.txt"));

            String line = br.readLine();//

            while (line !=null){
                if(validEmail.equals(line)){

                    line=br.readLine(); //12345
                    if(passwordInput.equals(line)){
                        break;

                    }
                }
                    else {
                        System.out.println("email or passwor is not correct try again");
                        Login();
                    }
            }
        br.close();
        }catch(IOException e){
            e.printStackTrace();
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
