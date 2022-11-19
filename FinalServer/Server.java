package FinalServer;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;

import Views.GeneralView;

public class Server {

    public void startConnection(){



        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("waiting for client connection");
            clientSocket = serverSocket.accept();
            System.out.println("Connected to a client");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            GeneralView.menu(out,in);





        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }





    }

}
