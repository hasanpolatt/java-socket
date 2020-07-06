
package SocketApp;

import java.io.*;
import java.net.*;

public class server {
    
    public static void main(String[] args) throws IOException {
          String clientincoming;
          ServerSocket serverSocket = null;
          Socket clientSocket = null;
 
          int number;
 
          try {
               // Listening to Client from Server 7755 port
               serverSocket = new ServerSocket(7755);
          } catch (Exception e) {
               System.out.println("Port Error!");
          }
          System.out.println("SERVER READY TO START...");
          
          // The program does not move to the bottom line of code without a connection.(accept)
          clientSocket = serverSocket.accept();
 
          // The PrintWriter object we use to send data to the Client is created
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 
          // BufferedReader object creating that holds data from Client
          BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
          while((clientincoming = in.readLine()) != null) {
               System.out.println("Data from the client = " + clientincoming);
               number = Integer.valueOf(clientincoming);
               out.println(number*number);
          }
          out.close();
          in.close();
          clientSocket.close();
          serverSocket.close();
     }    
}
