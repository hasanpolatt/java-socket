
package SocketApp;

import java.io.*;
import java.net.*;

public class client {
    
    public static void main(String[] args) throws IOException {
          process();
     }
 
     public static void process() throws UnknownHostException, IOException {
          Socket socket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          String value;
          try {
               // Connection to the Server via localhost and port 7755 is provided
               socket = new Socket("localhost", 7755);
          } catch (Exception e) {
               System.out.println("Port Error!");
          }
          
          // The PrintWriter object we use to send data to the server is created
          out = new PrintWriter(socket.getOutputStream(), true);
 
          // BufferedReader object creating that holds data from the server
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
          System.out.println("Enter the number to be sent to the Server: ");
 
          // Entering the number to be sent
          BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
 
          while((value = data.readLine()) != null) {
               out.println(value);
               System.out.println("Conclusion coming from the Server = " + in.readLine());
               System.out.println("Enter the number to be sent to the Server: ");
          }
          out.close();
          in.close();
          data.close();
          socket.close();
     }
}
