package networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HttpServer extends EchoServer{
    // Overriding processStream from EchoServer

    void processStream(InputStream is, OutputStream os)
    {
        System.out.println("HttpServer.processStream begins");

        PrintStream ps = new PrintStream(os);
        BufferedReader input = new BufferedReader(new InputStreamReader(is));
        
        String cmd;
        try
        {
            // We are only looking at GET requests: 
            // We will be looking for something like:
            // GET /like.html HTTP/1.1

            cmd= input.readLine(); // We are only looking at the first line 
            System.out.println(cmd);
            StringTokenizer parse = null;
            if (cmd != null)
                parse = new StringTokenizer(cmd);
            String fileName="home.html";
            if (parse!= null && parse.countTokens() >= 2)
            {
                String method = parse.nextToken();  // Should contain GET
                String tempFileName=parse.nextToken().trim();         // Could contain a filename
             // We expect either "/"  or "/someFileName"
                if (!tempFileName.equals("/"))
                    fileName = tempFileName.substring(1); // strip off leading "/"
                
                System.out.println("method="+method);
                System.out.println("fileName="+fileName);
            }
        
            
            ps.println("HTTP/1.1 200 OK");
            ps.println("content-type: text/html");

// This blank line says we are done with HTTP headers and ready to send the data
            ps.println(); 
   
// Send out our html file to the browser
            File f = new File(fileName);
            Scanner readIt = new Scanner(f);
            while (readIt.hasNextLine())
            {
                String s = readIt.nextLine();
                ps.println(s);
            }
// closing the TCP/IP connection tells the browser we are done. 
            input.close();
            ps.close();
            is.close();
            os.close();
        }
        catch (IOException e)
        {
            System.out.println("HttpServer.processStream IOException: "+e);
        }
        System.out.println("Exitting processStream");
    }
    public static void main(String[] args) {
        HttpServer es = new HttpServer();
        es.monitorServer();
        System.out.println("Exitting HttpServer");

    }

}
