import java.util.Scanner; 

public class feetToMiles {

	public static void main(String[] args) {
		
		double feet; //input variable for feet
		double miles; //input variable for miles
		
		//Creates a keyboard object named FeetInput for user input
		Scanner FeetInput = new Scanner(System.in);
		
		//prompts user to input the number of feet that they have traveled
		System.out.println("How many feet have you traveled: ");
		feet = FeetInput.nextDouble();
		
		//Calculates how many miles were traveled
		miles = feet / 5280;
		
		/*Formatted output that prints out the amount of miles traveled.  Used a format method to round
		to three decimal places if the miles were below 1 or to 2 decimal places if they were greater than one*/
		if (miles < 1){
			System.out.format("You have traveled %.03f of a mile", miles);
			
		}
		
		if (miles == 1){
			System.out.println("You have traveled one mile.");
		}
		
		if (miles > 1){
			System.out.format("You have traveled %.02f miles", miles);
		}
	
		
		
	}
}
