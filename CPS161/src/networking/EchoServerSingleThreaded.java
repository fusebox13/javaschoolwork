package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerSingleThreaded {
 
 public static void main(String[] args) throws IOException {
     int portNum = 4444;
     InetAddress iaddr=null;
   
     ServerSocket serverSocket = null;
        
     try {
            serverSocket = new ServerSocket(portNum);

            iaddr = InetAddress.getLocalHost();
            System.out.println("Host:" + iaddr.getHostName()+ 
                 " ipaddr=" + iaddr.getHostAddress()+
                 " portnum="+ portNum);
        } 
     catch (IOException e) 
        {
            System.err.println("Socket Err:" + e);
            System.exit(1);
        }

     Socket clientSocket = null;
    
     try{
            clientSocket = serverSocket.accept();
        } 
     catch (IOException e) {
            System.err.println("Accept failed." + e);
            System.exit(1);
        }

     PrintStream out = new PrintStream(
                           clientSocket.getOutputStream(), true);

    
     InputStream is = clientSocket.getInputStream();
     Scanner scanStream = new Scanner(is);

   
     while (scanStream.hasNextLine()) // Read from socket 
       {
             out.println(scanStream.nextLine()); // Echo data read
       }
     out.close();
     scanStream.close();
     clientSocket.close();
     serverSocket.close();
     System.out.println("Exitting ");
    }
}