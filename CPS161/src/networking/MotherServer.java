package networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MotherServer implements Runnable {

    ServerSocket serverSocket = null;
    int portNum=-1;
    ConnectListener connectListener= null;
    boolean continueListening = true;
    Thread myThread = null;

    boolean startServer(int portNum, ConnectListener connectListener)
    {
        this.portNum = portNum;
        try {
            serverSocket = new ServerSocket(portNum);
        } catch (IOException e) {
            System.out.println("ServerSocket connect error: " + e);
            return false;
        }
        this.connectListener = connectListener; 
        myThread = new Thread(this);
        myThread.start();
        return true;
    }

    public void run() // This is where the Server executes
    {
        continueListening = true;
        while(continueListening)
        {
            try {
                Socket sock = serverSocket.accept();
                connectListener.handleConnect(sock);
            } catch (IOException e) {
                System.out.println("ServerSocket accept error: " + e);
                continueListening = false;
            }
        }
        System.out.println("MyServer run thread exitting");
    }

    public void stopServer()
    {
        continueListening = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("stopServer error: " + e);            
        }
    }

    static String getHostInfo()
    {
        String retStr="";
        try {
            InetAddress iaddr = InetAddress.getLocalHost();
            retStr= String.format("Host:%s ipaddr=%s",
                    iaddr.getHostName(), iaddr.getHostAddress());
        } 
        catch (UnknownHostException e) {
            retStr = e.toString();
        }
        
        return retStr;
    }
}