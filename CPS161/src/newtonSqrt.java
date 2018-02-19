import java.util.Scanner;


public class newtonSqrt 
{

	
	public static void main(String[] args)
	{
		
		//Declarations
		Scanner keyboard = new Scanner(System.in);
		double n;
		double newtonsApproximation;
		double difference;
		int guessCounter = 0;
		
		
		//Prompts user to enter a number, and sets the first guess equal to the number
		System.out.print("Enter in N to approximate it's square root using Newton's method: ");
		n = keyboard.nextDouble();
		double currentGuess = n;
		
		
		/* Approximates the square root and compares it to the previous approximation.  Stops when
		   the difference between the current approximation and previous approximation is less than 0.00001 */
		do
		{
			guessCounter++;
			newtonsApproximation = ((n/currentGuess) + currentGuess)/2;
			difference = currentGuess - newtonsApproximation;
			currentGuess = newtonsApproximation; 
			
		}while (difference >= 0.00001);
		
		
		//Prints out the approximation and compares it with the Math.sqrt() method
		System.out.println("\nThe approximation took " + guessCounter + " guesses.");
		System.out.println("Newton(" + n + ")= " + currentGuess);
		System.out.println("Math.sqrt(" + n + ")= " + Math.sqrt(n));
		
		
		keyboard.close();
	
	}

}
