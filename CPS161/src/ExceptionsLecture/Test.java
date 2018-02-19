package ExceptionsLecture;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	
	Scanner keyboard = new Scanner(System.in);
	int divideByZero(int num, int div)
	{
		try
		{
		return num/div;
		}
		catch (ArithmeticException e)
		{
			System.out.println("Error: Divide by zero " + e);
			return -1;
		}
	
	}

	int divideByZero2(int num, int div)
	{
		return num/div;
	}
	
	int readInteger()
	{
		boolean goodInput = false;
		int retValue = 1;
		while (!goodInput)
		{
			try
			{
				retValue = keyboard.nextInt();
				goodInput = true;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Your integer was bad, try again");
				keyboard.next();
			}
		}
		return retValue;
	}
	public static void main(String[] args) 
	{
		Test t = new Test();
		try
		{
			System.out.println("Enter in divisor ");
			int divisor = t.readInteger();
			int x = t.divideByZero(10,1);
			x = t.divideByZero(20, divisor);
			x = t.divideByZero2(10,1);
			x = t.divideByZero2(20, divisor);
			
		}
		catch (ArithmeticException e)
		{
			System.out.println("Caught divide by zero in main " + e);
			
		}
		System.out.println("All exceptions caught.  Program finished");
		
	}

}
