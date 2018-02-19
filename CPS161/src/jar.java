import java.util.Scanner;

public class jar
{
	public static void main(String[] args)
	{
		//Creates a scanner object named Keyboard to read input from the user
		Scanner Keyboard = new Scanner(System.in);
		
		//Prompts user to enter the amount of pennies in the jar, and reads the input.
		System.out.println("How many pennies are in the jar?");
		int cents = Keyboard.nextInt();
		
		/*Because I wanted to use a single variable for this program, the rest of the input
		automatically adjusts the cents variable based on the value of each coin*/
		System.out.println("How many nickels are in the jar?");
		cents += 5 * Keyboard.nextInt();
		
		System.out.println("How many dimes are in the jar?");
		cents += 10 * Keyboard.nextInt();
		
		System.out.println("How many quarters are in the jar?");
		cents += 25 * Keyboard.nextInt();
		
		/* Used integer division to determine the amount of dollars, and modulus division
		 to determine the amount of cents.  The boolean statements exist for formatting only*/
		
		if ((cents/100) == 1)
			System.out.println("The jar contains " + (cents / 100) + " dollar and " + (cents % 100) + " cents.");
		else if ((cents/100) > 1)
			System.out.println("The jar contains " + (cents / 100) + " dollars and " + (cents % 100) + " cents.");
		else
			System.out.println("The jar contains " + cents + " cents.");
		
		Keyboard.close();
		
	}

}
