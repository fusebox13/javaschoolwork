import java.util.InputMismatchException;
import java.util.Scanner;


public class TestException 
{
	Scanner keyboard = new Scanner(System.in);
	
	int divideByZero(int num, int div)
	{	
		try
		{
			return num/div;
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception " + e);
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
		int retValue = -1;
		while (!goodInput)
		{
			try
			{
				retValue = keyboard.nextInt();
				goodInput = true;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Exception " + e);
				keyboard.next();
			}
		}
		return retValue;
		
	}
	
	
	public static void main(String[] args)
	{
		TestException t = new TestException();
		try
		{	
			System.out.println("Enter in Divisor ");
			
			int d = t.readInteger();
			
			int x = t.divideByZero(10, 1);
			x = t.divideByZero(20, d);
			x = t.divideByZero2(10, 1);
			x = t.divideByZero2(20, d);
			
	
		}
		catch(ArithmeticException e)
		{
			System.out.println("Exception(Main) " + e);
		}
		
		System.out.println("Normal exit from my routine");
		
	}

}
