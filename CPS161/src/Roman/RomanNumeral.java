package Roman;

import java.util.Scanner;

public class RomanNumeral 
{
	private int RomanNumeralValue;
	private String RomanNumeralString;
	
	
	private boolean AdditiveFormat = true;
	private boolean SubtractiveFormat = false;
	
	
	private String ERROR_MESSAGE = "";
	
	
	private static final String[] Numeral = { "M",  "CM",  "D",  "CD", "C",  "XC", "L",  "XL",  "X",  "IX", "V",  "IV", "I" };
	private static final int[] NumeralValue = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	
	private Scanner keyboard = new Scanner(System.in);
	
	
	public RomanNumeral()
	{
		
	}
	
	
	/**
	 * Constructs a Roman Numeral from an Integer if the integer is within
	 * an acceptable range.
	 * 
	 * @param numericValue	instantiates the numeric value of the Roman Numeral
	 */
	public RomanNumeral(int numericValue)
	{
		if (numericValue < 1 || numericValue > 3999)
			System.out.println("Error: Out of Bounds (" + numericValue + ")");
		else
			RomanNumeralValue = numericValue;		
	}
	
	
	/**
	 * Constructs a Roman Numeral from a String if the string is a valid Roman Numeral
	 * 
	 * @param s	instantiates the string value of the Roman Numeral
	 */
	public RomanNumeral(String s)
	{
		if(isValid(s))
		{
			RomanNumeralString = s;
			return;
		}
		else
			System.out.println("Error: Not a Roman Numeral");
	}
	
	
	
	/**
	 * Prints the Roman Numeral to a String by recreating a string from the 
	 * numeric value.  Prints different outputs depending on the desired format.
	 * The two formats are additive and subtractive.
	 * 
	 * @see #InBounds()
	 * @see #convertToAdditiveFormat()
	 * @see #convertToSubtractiveFormat()
	 */
	public String toString()
	{
		
		if(!InBounds())
			return "";
		
		if(SubtractiveFormat)
			convertToSubtractiveFormat();
		else if (AdditiveFormat)
			convertToAdditiveFormat();
		else
			System.out.println("Fatal Error: Invalid Format");
		
		return RomanNumeralString;
	}
	
	
	
	
	/**
	 * Creates a temporary Roman Numeral string that represents the numeric
	 * value in the additiveFormat eg. MMXIII
	 * 
	 * @see #RomanNumeralString
	 * @see #RomanNumeralValue
	 */
	private void convertToAdditiveFormat()
	{
		String TempString = "";
		int TempInt = RomanNumeralValue;
		int index = 0;
		
		while(TempInt > 0)
		{
			
			while((TempInt / NumeralValue[index]) > 0)
			{
				TempString+=Numeral[index];
				TempInt-=NumeralValue[index];
			}
			index+=2;
		}
		
		RomanNumeralString = TempString;
	}
	
	
	
	/**
	 * Creates a temporary Roman Numeral string that represents the numeric
	 * value in the subtractive format eg. CMIXIV
	 * 
	 * @see #RomanNumeralString
	 * @see #RomanNumeralValue
	 */
	private void convertToSubtractiveFormat()
	{
		String TempString = "";
		int TempInt = RomanNumeralValue;
		int index = 0;
		
		while(TempInt > 0)
		{
			
			while((TempInt / NumeralValue[index]) > 0)
			{
				TempString+=Numeral[index];
				TempInt-=NumeralValue[index];
			}
			index++;
		}
		RomanNumeralString = TempString;
	}
	
	
	
	/**
	 * Casts the value of the Roman numeral as an Integer
	 * 
	 * @return	returns the value of the Roman Numeral as an integer
	 * @see 	#RomanNumeralValue
	 */
	public int toInt()
	{
		return RomanNumeralValue;
	}
	
	
	
	/**
	 * If the string is only integers, the integer value of the string
	 * is stored as the numeric value of the Roman Numeral.
	 * An error message is set if the String is empty.
	 * 
	 * @param TempRomanNumeral	The string to be evaluated to determine if it is all integers
	 * @return					Returns true if the string argument is all integers
	 */
	private boolean isInt(String TempRomanNumeral)
	{
		if(TempRomanNumeral.isEmpty())
			{
				ERROR_MESSAGE = "Nothing was entered";
				return false;
			}
		
		for (int index = 0; index < TempRomanNumeral.length(); index++)
		{
			if(!Character.isDigit(TempRomanNumeral.charAt(index)))
				return false;
		}
		RomanNumeralValue = Integer.valueOf(TempRomanNumeral);
		
		return true;
	}
	
	
	
	/**
	 * If the string is empty an error message is produced.  Otherwise the
	 * passed string will be converted to all upper case letters and is then
	 * evaluated two characters at a time, except for when the loop gets to the
	 * last character.  
	 * <p>
	 * Each loop determines if the next character is bigger than the current character.
	 * If it is, it treats the two characters as if they are meant to be subtractive.
	 * For instance, IV will be read as 4 and VI will be read as 6 and VIV will be
	 * read as 5 + 4 or 9.  This allows the class to correctly interpret both additive 
	 * and subtractive forms.
	 * 
	 * @param TempRomanNumeral	the string to be evaluated to determine if it's a valid Roman Numeral	
	 * @return					returns true if the String is a valid Roman Numeral and assigns the numeric
	 * 							Roman Numeral value of string to {@link #RomanNumeralValue}
	 * @see #RomanNumeralValue
	 */
	private boolean isRomanNumeral(String TempRomanNumeral)
	{
		if(TempRomanNumeral.isEmpty())
		{
			ERROR_MESSAGE = "Nothing was entered";
			return false;
		}
		
		int TempRomanNumeralValue = 0;
		
		TempRomanNumeral = TempRomanNumeral.toUpperCase();
		
		for(int index = 0; index < TempRomanNumeral.length(); index++)
		{
			if(getNumeralValue(TempRomanNumeral.charAt(index)) == -1)
			{
				ERROR_MESSAGE = "Invalid Character: " + TempRomanNumeral.charAt(index);
				return false;
			}
			
			
			int currentValue = getNumeralValue(TempRomanNumeral.charAt(index));
			
			if(index != TempRomanNumeral.length() - 1) // If not at the end of the string, look at the next number
			{
				int nextValue = getNumeralValue(TempRomanNumeral.charAt(index + 1));

				if(currentValue < nextValue)
				{
					int subtractiveValue = nextValue - currentValue;
					
					switch (subtractiveValue)
					{
						case 900: case 400: case 90: case 40: case 9: case 4:
						{
							TempRomanNumeralValue+=subtractiveValue; //Adds the subtractive value for special subtractive cases such as IV, IX, etc...
							index++; //Because we are evaluating two characters in the string we adjust the index
							break;
						}
						default:
							TempRomanNumeralValue+=currentValue; //If the current value is less than the next, but is not a special case, I just add the current value
					}
					
				}
				else
					TempRomanNumeralValue+=currentValue; //Adds the current value if the next value is larger
			
			}
			else
				TempRomanNumeralValue+=currentValue; //Adds the last value in the string
			
		}
		
		RomanNumeralValue = TempRomanNumeralValue;
		return true;
			
	}
	
	
	
	/**
	 * Checks to see if {@link #RomanNumeralValue} is within acceptable bounds since
	 * any number less than 1 and greater than 4000 cannot be represented in subtractive form.
	 * 
	 * @return	returns true if {@link #RomanNumeralValue} is within acceptable bounds
	 */
	public boolean InBounds()
	{
		if (RomanNumeralValue < 1 || RomanNumeralValue > 3999)
		{
			ERROR_MESSAGE = "Out of Bounds";
			return false;
		}
		
		else
			return true;
	}
	
	
	
	/**
	 * Evaluates a string to determine if it is a valid representation of a Roman Numeral.  
	 * It must either be an integer, or a valid Roman Numeral string and it has to be 
	 * within bounds to be properly printed in Subtractive Form.
	 *  
	 * @param TempRomanNumeral	any string can be passed to determine if it is a valid
	 * 							Roman Numeral.
	 * @return					returns true if the string is an integer or a valid Roman
	 * 							Numeral String and if the value of the Roman Numeral
	 * 							is in bounds.
	 */
	public boolean isValid(String TempRomanNumeral)
	{
		return (isInt(TempRomanNumeral) || isRomanNumeral(TempRomanNumeral)) && InBounds();
	}
	
	
	
	/**
	 * Prompts the user to enter a Roman Numeral and keeps prompting them
	 * until they enter a valid Roman Numeral.  Stores the user input into
	 * {@link #RomanNumeralString} if it is valid.
	 * 
	 * @see #RomanNumeralString
	 */
	public void getRomanNumeral()
	{

		while (true)
		{
			System.out.print("> ");
			RomanNumeralString= keyboard.nextLine();
			
			if(isValid(RomanNumeralString))
				return;
			else
				System.out.println(ERROR_MESSAGE + "\nPlease enter a Roman Numeral (MDCLXVI)");
		}
		
	}
	
	
	
	/**
	 * Reads in a character, determines if it's a Roman Numeral character
	 * then returns it's integer value.  If it's not a Roman Numeral character
	 * -1 is returned.
	 * 
	 * @param c	a character that is evaluated to determine if it's a Roman Numeral character
	 * @return	if it is a valid character it's numeric value is returned.
	 * @see #isRomanNumeral(String)
	 */
	public int getNumeralValue(char c)
	{
		switch(c)
		{
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		case 'I':
			return 1;
		default:
			return -1;

		}
	}
	
	

	/**
	 * Switches the format to the additive format so the {@link #toString()}
	 * method will print the Roman Numeral in the additive format
	 * eg. MMXXIIII
	 * 
	 * @see #toString()
	 * @see #AdditiveFormat
	 * @see #SubtractiveFormat
	 */
	public void setFormatAdditive()
	{
		AdditiveFormat = true;
		SubtractiveFormat = false;
	}
	
	
	
	/**
	 * Switches the format to the subtractive format so the {@link #toString()}
	 * method will print the Roman Numeral in the subtractive format
	 * eg. CMIXIV
	 * 
	 * @see #toString()
	 * @see #AdditiveFormat
	 * @see #SubtractiveFormat
	 */
	public void setFormatSubtractive()
	{
		SubtractiveFormat = true;
		AdditiveFormat = false;
	}
	
	
	
	/**
	 * Empty Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		

	}

}
