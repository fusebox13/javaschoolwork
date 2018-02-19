package TextbookIOExamples;


import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HasNextIntDemo
{
    public static void main(String[] args)
    {
        Scanner scanStream = null;

        try
        {
           scanStream =
              new Scanner(new FileInputStream("data.txt"));
        }
        catch(FileNotFoundException e)
        {
           System.out.println("File data.txt was not found");
           System.out.println("or could not be opened.");
           System.exit(0);
        }

        int next, sum = 0;
        while (scanStream.hasNextInt( ))
        {
            next = scanStream.nextInt( );
            sum = sum + next;
        }

        scanStream.close( );

        System.out.println("The sum of the numbers is " + sum);
    }
}
