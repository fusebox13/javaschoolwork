package IOLecture;

import java.io.*;

public class CopyBuffered {
    static void byteCopy(String from, String to) throws IOException
    {
       int b;
    // Using Buffered I/O byte(8 bit) stream operations    
       
        FileInputStream insrc = new FileInputStream(from);
        FileOutputStream outsrc = new FileOutputStream(to);
        BufferedInputStream in = new BufferedInputStream(insrc);
        BufferedOutputStream out = new BufferedOutputStream(outsrc);


        while ((b = in.read()) != -1)
           out.write(b);

        in.close();
        out.close();
    }
    
    static void charCopy(String from, String to) throws IOException
    {
     int c;

    // Using Buffered I/O char(16 bit Unicode) stream operations    
        
        FileReader insrc = new FileReader(from);
        FileWriter outsrc = new FileWriter(to);
        BufferedReader in = new BufferedReader(insrc);
        BufferedWriter out= new BufferedWriter(outsrc);


        while ((c = in.read()) != -1)
           out.write(c);

        in.close();
        out.close();
    }
    
    public static void main(String[] args) throws IOException {
        charCopy("src/IOLecture/CopyBuffered.java", "junk1.txt");
        byteCopy("junk1.txt", "junk2.txt");       
    }
}