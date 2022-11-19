package FinalServer;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(6000)) {
      while (true) {
        new Server(serverSocket.accept()).start();
        //                Socket socket = serverSocket.accept(); //accept
        //                Echoer echoer = new Echoer(socket);
        //                echoer.start();
      }
    } catch (IOException e) {
      System.out.println("Server exception " + e.getMessage());
    }
  }
}
