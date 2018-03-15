// File Name GreetingServer.java
import java.net.*;
import java.io.*;

public class BufferServer  {
   
   public static void main(String [] args){
      try{
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(6066);
            serverSocket.setSoTimeout(100000);
   
            Socket server = serverSocket.accept();
             
            System.out.println("Write message to client");
            BufferedReader readKeyboard = new BufferedReader(new InputStreamReader(System.in));
            String message = readKeyboard.readLine();

            OutputStream out = server.getOutputStream();
            PrintWriter pwrite = new PrintWriter(out, true);
            pwrite.println(message);

            InputStream in = server.getInputStream();
            BufferedReader readSocket = new BufferedReader(new InputStreamReader(in));

            System.out.println("Message received from server " + readSocket.readLine());
            serverSocket.close();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}