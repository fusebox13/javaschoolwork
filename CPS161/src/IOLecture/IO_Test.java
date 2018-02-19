package IOLecture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class IO_Test {

    void FileReadMethod(String filename)
    {
        File f = new File(filename);
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine())
            {
                String s = scan.nextLine();
                System.out.println(s);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(" Error: "+e + " "+ filename);
            e.printStackTrace();
        }
    }
    
   
    
    
    void FileCopy(String filename, String outFile)
    {
        File f = new File(filename);
        File fo = new File(outFile);
        
        try {
            Scanner scan = new Scanner(f);
            PrintStream ps = new PrintStream(fo);
            
            
            while (scan.hasNextLine())
            {
                String s = scan.nextLine();
                ps.println(s);
            }
            scan.close();
            ps.close();

        } catch (FileNotFoundException e) {
            System.out.println(" Error: "+e + " "+ filename);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
 
        IO_Test it = new IO_Test();
        it.FileCopy("src/IOLecture/IO_Test.java", "junk.txt");
        
        System.out.println("Copy finished: src/IOLecture/IO_Test.java --> junk.txt");
        
        it.FileReadMethod("junk.txt");

    }

}