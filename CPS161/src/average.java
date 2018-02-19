import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class average 
{
	public static void main(String[] args)
	{
		//Creates a keyboard object to gather input.
		Scanner Keyboard = new Scanner(System.in);
		
		//Prompts the user to enter three numbers
		System.out.println("Enter the first number: ");
		int num1 = Keyboard.nextInt();
		System.out.println("Enter the second number: ");
		int num2 = Keyboard.nextInt();
		System.out.println("Enter the third number: ");
		int num3 = Keyboard.nextInt();
		
		//Calculates the average by typecasting the ints as doubles.
		double average = ((double)num1 + (double)num2 + (double)num3) / 3;
		
		//Prints out the average of the three numbers
		System.out.printf("The average of " + num1 + ", " + num2 + " & " + num3 + " is %.2f", average);
		System.out.printf("hello");
		Keyboard.close();
	}

}
