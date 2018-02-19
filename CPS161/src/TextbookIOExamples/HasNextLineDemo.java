package TextbookIOExamples;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class HasNextLineDemo
{
    public static void main(String[] args)
    {
        Scanner inputStream = null;
        PrintWriter outputWriter = null;

        try
        {
           inputStream =
              new Scanner(new FileInputStream("original.txt"));
           outputWriter = new PrintWriter("numbered.txt");
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Problem opening files.");
           System.exit(0);
        }

        String line = null;
        int count = 0;

        while (inputStream.hasNextLine( ))
        {
            line = inputStream.nextLine( );
            count++;
            outputWriter.println(count + " " + line);
        }

        inputStream.close( );
        outputWriter.close( );
    }

}