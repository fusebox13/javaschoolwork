package Webprogramming;


import java.util.Scanner;
import java.net.URL;  
 
public class getUrlContents {
    public static void main(String[] args) throws Exception
    {
    URL aURL = new URL("https://www.facebook.com/daan.berks");

	System.out.println("protocol = " + aURL.getProtocol());
	System.out.println("authority = " + aURL.getAuthority());
	System.out.println("host = " + aURL.getHost());
	System.out.println("port = " + aURL.getPort());
	System.out.println("path = " + aURL.getPath());
	System.out.println("query = " + aURL.getQuery());
	System.out.println("filename = " + aURL.getFile());
	System.out.println("ref = " + aURL.getRef());
	
	
	          
	//Scanner sc = new Scanner(new URL("http://www.reddit.com").openStream());
	        //while (sc.hasNext())
	            //System.out.println(sc.nextLine());         
}
}