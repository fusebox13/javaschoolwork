package IOLecture;

import java.io.*;

public class Copy {
    static void byteCopy(String from, String to) throws IOException
    {
    // Using Non-buffered Low Level I/O byte stream operations
    
        int b;
        // Using byte stream  (8 bit)
        FileInputStream in = new FileInputStream(from);
        FileOutputStream out = new FileOutputStream(to);

        while ((b = in.read()) != -1)
           out.write(b);

        in.close();
        out.close();
    }
    
    static void charCopy(String from, String to) throws IOException
    {
    // Using Non-buffered Low Level I/O char stream operations
    
        int c;
        // Using Unicode Approach char stream  (16 bit)
        FileReader in = new FileReader(from);
        FileWriter out = new FileWriter(to);

        while ((c = in.read()) != -1)
           out.write(c);

        in.close();
        out.close();
    }
    
    public static void main(String[] args) throws IOException {
        charCopy("src/IOLecture/Copy.java", "junk1.txt");
        byteCopy("junk1.txt", "junk2.txt");
        System.out.println("Complete");
    }
}
