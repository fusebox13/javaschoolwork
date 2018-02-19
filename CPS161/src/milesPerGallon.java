import java.util.Scanner; 

public class milesPerGallon {

	public static void main(String[] args) {
		
		double miles; //input variable for miles traveled
		double gallons; //input variable for gallons used
		
		//Creates a keyboard object named KeyboardInput for user input
		Scanner KeyboardInput = new Scanner(System.in);
		
		//prompts user to input the number of miles that they have traveled
		System.out.println("How many miles did you travel? ");
		miles = KeyboardInput.nextDouble();
		
		//prompts user to input the amount of gallons they used for their trip
		System.out.println("How many gallons of gas did you use? ");
		gallons = KeyboardInput.nextDouble();
		
		//calculates and prints out miles per gallon formatted to two decimals places
		System.out.format("You are currently getting %.02f miles per gallon.", (miles / gallons));
		
		//closes the KeyboardInput scanner to free up memory
		KeyboardInput.close();
		
	}
}
