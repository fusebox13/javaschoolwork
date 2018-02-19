import java.util.Scanner;


public class lowerUpperBound 
{

    
    public static void main(String[] args) 
    {
    	
        //Declarations
        Scanner Keyboard = new Scanner(System.in);
        int upperbound;
        int lowerbound;
        int stepsize;
        String wantToContinue = new String("y");
        
        
        //Prompts the user to enter a upper and lower bound and a step size.
        while(wantToContinue.equals("y"))
        {
        	
        	do
            {
        		
                System.out.print("Enter Upper Bound: ");
                upperbound = Keyboard.nextInt();
        
                System.out.print("Enter Lower Bound: ");
                lowerbound = Keyboard.nextInt();
        
                System.out.print("Enter Step Size: ");
                stepsize = Keyboard.nextInt();
            
                if(lowerbound > upperbound)
                System.out.println("The Upper Bound must be greater than the Lower Bound ");
            
            }while(lowerbound > upperbound);
        
            
            /*Prints out the numbers starting at the lower bound ending at the upper bound and 
             * incrementing by the step size and does a line break every 10 numbers */
            int counter = 0;
            for (int i = lowerbound; i <= upperbound; i+=stepsize)
            {
                System.out.print( i + ", ");
                counter++;
                
                if (counter % 10 == 0)
                    System.out.println("");
                    
            }
            
            
            //Asks the user of they want to continue.  The user must enter 'y or 'n' or the program will keep asking
            do
            {
            	
                System.out.println("Do you want to continue? (y or n): ");
                wantToContinue=Keyboard.next();
                
            }while(wantToContinue.equals("y") == false && wantToContinue.equals("n") == false);
        }
        
        
        //Prompts the user that the program is exiting and closes the Keyboard object to free up memory
        System.out.println("Exiting...");
        Keyboard.close();
    }

}
