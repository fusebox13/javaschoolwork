import java.util.Scanner;

public class MakeChange
{
	public static void main(String[] args)
	{
		//Creates a scanner object named Keyboard to read input from the user
		Scanner Keyboard = new Scanner(System.in);
		
		//Prompts the cashier to enter the price of an item, and the amount of money received.
		System.out.println("Enter the item price?");
		System.out.printf("Dollars: ");
		int priceDollars = Keyboard.nextInt();
		System.out.printf("Cents: ");
		int priceCents = Keyboard.nextInt();
		System.out.println("Cash Received?");
		System.out.printf("Dollars: ");
		int receivedDollars = Keyboard.nextInt();
		System.out.printf("Cents: ");
		int receivedCents = Keyboard.nextInt();
		
		//Prompts an error if not enough money is received.  Converts dollars to cents for the sake of the boolean statement.
		if (((receivedDollars*100) + receivedCents) < ((priceDollars*100) + priceCents)) 
		{
			System.out.println("ERROR: Order cannot be tendered due to insufficient funds.");
		}
		//If enough money is received, it runs the rest of the program.
		else
		{
		int changeDollars = receivedDollars - priceDollars;
		/*Evaluates the amount of cents after the transaction taking negative values into consideration
		and adjusts both dollars and cents accordingly*/ 
		int changeCents = 0;
		if (priceCents > receivedCents)
		{
			changeCents = (receivedCents - priceCents) + 100;
			changeDollars--;
		}
		else
			changeCents = receivedCents - priceCents;
		/*Prints out the amount of change and type of change which need to be given back to the customer
		  Used modulus arithmetic determine the amount of quarters, nickels, dimes, and pennies*/
		System.out.println("The customer's change is " + changeDollars + " dollars and " + changeCents + " cents." );
		System.out.println("Give the customer:");
		System.out.println(changeDollars + " dollars.");
		System.out.println((changeCents / 25) + " quarters.");
		changeCents = changeCents % 25;
		System.out.println((changeCents / 10) + " dimes");
		changeCents = changeCents % 10;
		System.out.println((changeCents / 5) + " nickels.");
		changeCents = changeCents % 5;
		System.out.println((changeCents % 5) + " pennies.");
		}
		Keyboard.close();
	}

}