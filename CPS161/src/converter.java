import java.util.InputMismatchException;
import java.util.Scanner;


public class converter
{
	
	public static void main(String[] args)
	{
		runCentigradeLoop(); //method which contains the loop
	}
	
	
	//Method that takes Fahrenheit as an argument and returns Celsius (NOT USED)
	public static double convertToCentigrade(double Fahrenheit)
	{
		double Celsius = (Fahrenheit - 32.0) * (5.0/9.0);
		return Celsius;
	}
	
	//Method that takes Centigrade as an argument and returns Fahrenheit
	public static double convertToFahrenheit(double Centigrade)
	{
		double Fahrenheit = (Centigrade * (9.0/5.0)) + 32.0;
		return Fahrenheit;
	}
	
	/*Method that gathers temperature in Centigrade, converts it to Fahrenheit, and computes the average temp between all of the input.
	 *If the input is not a number, it will break out of the loop */
	public static void runCentigradeLoop()
	{
		double input = 0.0; //Used to gather the temperatures from the user
		double average = 0.0; // Used to store the average temperature
		double counter = -1.0; //Counter is set to -1 in order to adjust for the extra iteration of the while loop
		boolean error = false; //Error message which flips to true if thee is an InputMismatchException
		Scanner tempInput = new Scanner(System.in);
		
		//The loop runs and will break if the input is -100, or if there is a InputMismatchException
		while (input != -100)
		{
			average+=input; // adds the input to the average variable for later calculations
			counter++; // Keeps track of the amount of temperatures input
			System.out.print("Please enter a temperature in Centigrade(Type -100 to compute average and exit): ");
			
			//Checks for an InputMismatchException if there is one, otherwise it gathers the temperature from the user
			try{
				input = tempInput.nextDouble();
			}
			catch(InputMismatchException IME) {
				System.out.println("Unexpected Input - Exiting the program.");
				error = true;
				break;
			}
			//Prevents the program from converting a -100 temperature and printing the conversion
			if (input != -100)
				System.out.println(input + " C " + convertToFahrenheit(input) + " F");	
		}
		
		/*If there were no errors, it will compute and print the average Centigrade temp which is 
		 * then converted to Fahrenheit using the convertToFahrenheit.*/
		if(error == false)
		{
			if (counter != 0)
			{
				average = average/counter;
				System.out.println("You've entered " + (int)counter + " entries into the temperature log");
				System.out.println("Average Temperature: " + average + " C " + convertToFahrenheit(average) + " F");
			}
			
		}
		//Closes the Scanner object
		tempInput.close();
	}
	
}
