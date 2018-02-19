import java.util.Scanner;


public class factorial 
{

	public static void main(String[] args) 
	{
		//Declarations
		Scanner Keyboard = new Scanner(System.in);
		String wantToContinue = new String("y");
		
		
		do{
			
			//Prompts the user to input a number so the program can calculate it's factorial
			System.out.print("Enter in N: ");
			int num = Keyboard.nextInt();
			
			
			//Computes the factorial and prints the result
			for(int previousNum = (num-1); previousNum > 1; previousNum--)
				num *= previousNum;
			System.out.println("Factorial = " + num);
			
			
			//Asks the user if the want to continue.  User must enter 'y' or 'n' or the program will keep asking
			do{
				
				System.out.print("Do you want to continue? (y or n): ");
				wantToContinue=Keyboard.next();
				
			}while(wantToContinue.equals("y") == false && wantToContinue.equals("n") == false);
			
			
		}while(wantToContinue.equals("y"));
		
		
		System.out.println("Exiting ...");
		Keyboard.close();
	}

}
