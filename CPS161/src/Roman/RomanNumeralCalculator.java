package Roman;

import java.util.Scanner;

public class RomanNumeralCalculator 
{
	private Scanner keyboard = new Scanner(System.in);

	
	
	/**
	 * Asks the user if they want to add, subtract, multiply, or divide.
	 * Prompts the user to enter two Roman Numbers, does the arithmetic
	 * and creates a new Roman Numeral with the value then displays the
	 * answer in both additive and subtractive form.
	 */
	public void doCalculation()
	{
		while(true)
		{
			char operator = getOperator();
			RomanNumeral Answer;
			
			RomanNumeral operand1 = new RomanNumeral();
			RomanNumeral operand2 = new RomanNumeral();
		
			if (Character.toLowerCase(operator) == 'q')
			{
				System.out.println("Exiting...");
				return;
			}
		
			operand1.getRomanNumeral();
			System.out.print(operator + "\n");
			operand2.getRomanNumeral();
		
			switch(operator)
			{
				case '+':
				{
					Answer = new RomanNumeral(operand1.toInt() + operand2.toInt());
					break;
				}
				case '-':
				{
					Answer = new RomanNumeral(operand1.toInt() - operand2.toInt());
					break;
				}
				case '*':
				{
					Answer = new RomanNumeral(operand1.toInt() * operand2.toInt());
					break;
				}
				case '/':
				{
					Answer = new RomanNumeral(operand1.toInt() / operand2.toInt());
					break;
				}
				default:
				{
					System.out.println("Fatal Error! (THIS SHOULD NEVER HAPPEN)");
					Answer = new RomanNumeral(-1);
				}
			}
			
			if(Answer.InBounds())
			{
				Answer.setFormatSubtractive();
				System.out.println(Answer + " : " + Answer.toInt());
				Answer.setFormatAdditive();
				System.out.println(Answer + " : " + Answer.toInt() + "\n");
			}
		
		}
		
	}
	
	
	
	/**
	 * Prompts the user to enter a character representing which type of arithmetic
	 * operation that they want to perform.
	 * 
	 * @return	returns only a valid operation character to be read by the {@link #doCalculation()}
	 * 			method.  Keeps prompting the user until they make a valid choice.
	 */
	private char getOperator()
	{
		String temp = "";
		while (true)
		{
			System.out.print("Enter + - * / or (q to quit)>");
			temp = keyboard.nextLine();
		
			switch(temp.charAt(0))
			{
				case '+': case '-': case '*': case '/': case 'q':
					return temp.charAt(0);
				default:
					System.out.println("Invalid Choice");
			}
	
		}
		
	}
	
	
	
	/**
	 * Creates a Roman Numeral Calculator and does calculations
	 * until the user quits the program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		RomanNumeralCalculator Calculator = new RomanNumeralCalculator();	
		Calculator.doCalculation();
		
	}

}
