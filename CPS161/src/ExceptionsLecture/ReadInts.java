package ExceptionsLecture;
import java.util.*;

class ReadInts
{
    Scanner scan = new Scanner(System.in);

    int[] readAtYourRisk(int num)
    {
        System.out.println("readAtYourRisk ");
        int[] retVals = new int[num];
        for (int i=0; i < num; i++)
        {
            // An InputMismatchException is thrown if you enter
            //    in a non-integer
            retVals[i] = scan.nextInt();
        }    
        return retVals;
    }
    
    int[] readCarefully(int num)
    {
        System.out.println("readCarefully ");
        int[] retVals = new int[num];
        for (int i=0; i < num; i++)
        {
            boolean unread = true;
            while(unread)
            {
                try
                {
                    // An InputMismatchException is thrown if you enter
                    //    in a non-integer
                    retVals[i] = scan.nextInt();
                    unread = false;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("That Last number was bad ... try again");
                    scan.next(); // Throw away bad int
                }
            }
        }    
        return retVals;
    }

    void dump(int[] vals)
    {
        System.out.println("dump *****************************");
        for (int i=0; i < vals.length; i++)
            System.out.println(vals[i]+ " ");
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        ReadInts rd = new ReadInts();
        int[] vals = rd.readAtYourRisk(5);
        rd.dump(vals);        
        
        vals = rd.readCarefully(5);
        rd.dump(vals);
        
        boolean done = false;
        System.out.println("readAtYourRisk with main try ... catch protection");
        while (!done)
        {
            try
            {
                vals = rd.readAtYourRisk(5);
                rd.dump(vals);
                done = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Your last attempt failed ... Start over");
                rd.scan.next(); // Throw away bad int
            }
            
        }
        
    }
}