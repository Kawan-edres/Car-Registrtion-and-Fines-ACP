package Addmin;

import java.io.*;
import java.util.Scanner;

public class AdminAccount {

  static Scanner scan = new Scanner(System.in);

  //instance
  private String emaill;
  private String passwordd;

  public AdminAccount(String email, String password) {
    this.emaill = email;
    this.passwordd = password;
  }

  public static void Login(PrintWriter out,BufferedReader in) throws IOException {
    out.println("enter your email :");
    out.println("k");
    String emailInput =in.readLine();
    out.println("enter your password :");
    out.println("k");
    String passwordInput = in.readLine();
    String validEmail = emailInput.trim().toLowerCase();
  
    //check
      while (true) {
        if (validEmail.equals("admin@gmail.com")) {
       
          if (passwordInput.equals("12345")) {
            break;
          }
        } else {
          out.println("email or passwor is not correct try again");
          Login(out,in);
        }
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
    return (
      "AdminLogin{" +
      "email='" +
      emaill +
      '\'' +
      ", password='" +
      passwordd +
      '\'' +
      '}'
    );
  }
}
