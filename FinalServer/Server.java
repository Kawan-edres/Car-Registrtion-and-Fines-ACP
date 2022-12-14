package FinalServer;

import Views.GeneralView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;

public class Server extends Thread {


  private Socket socket = null;
  private BufferedReader input = null;
  private PrintWriter output = null;

  public Server(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      BufferedReader input = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        System.out.println("thread inturupted " + e.getMessage());
      }
     
      GeneralView.menu(output, input);
    } catch (IOException e) {
      System.out.println("Oops: " + e.getMessage());
    } catch (ParseException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        output.close();
        input.close();
        socket.close();
      } catch (IOException e) {}
    }
  }
  
}
