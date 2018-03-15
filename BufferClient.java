import java.net.*;
import java.io.*;

public class BufferClient {

   public static void main(String [] args) {
      String serverName = "localhost";
      int port = 6066;
      try {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("In client, Just connected to " + client.getRemoteSocketAddress());
         System.out.println("Write message to server");
         BufferedReader readKeyboard = new BufferedReader(new InputStreamReader(System.in));
         String message = readKeyboard.readLine();

         OutputStream out = client.getOutputStream();
         PrintWriter pwrite = new PrintWriter(out, true);
         pwrite.println(message);

         InputStream in = client.getInputStream();
         BufferedReader readSocket = new BufferedReader(new InputStreamReader(in));

         System.out.println("Message received from server " + readSocket.readLine());
         client.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}