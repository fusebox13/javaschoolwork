import java.util.Scanner;


public class Fibonacci 
{

	public static void main(String[] args)
	{
		//Declarations
		Scanner Keyboard = new Scanner(System.in);
		String wantToContinue = new String("y");
		
		do{
			
			//Prompts users to input a number to calculate the Fibonacci sequence
			System.out.print("Enter N: ");
			int num = Keyboard.nextInt();
			
			
			//Declares a starting position for the sequence
			int current = 0;
			int previous  = 1;
		
			
			//Prints out the Fibonacci sequence and the Fibonacci value for num
			for (int counter = 1; counter <= num; counter++)
			{
				current+=previous;
				previous = current - previous;
				System.out.print(current + " ");
			
			}
			System.out.println("\nFibonacci(" + num + ")= " + current);
			
			
			//Asks the user of they want to continue.  The user must enter 'y or 'n' or the program will keep asking
			do
			{
				
				System.out.print("Do you want to continue? (y or n): ");
				wantToContinue=Keyboard.next();
				
			}while(wantToContinue.equals("y") == false && wantToContinue.equals("n") == false);
			

		} while (wantToContinue.equals("y"));
		
		
		//Prompts the user that the program is exiting and closes the Keyboard object to free up memory
		System.out.println("Exiting ...");
		Keyboard.close();

	}

}
