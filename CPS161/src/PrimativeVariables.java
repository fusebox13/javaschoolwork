import java.util.Scanner; 

public class PrimativeVariables {


    public static void main(String[] args) {
        double num1;   // variable to hold our first input
        double num2;   // variable to hold our second input
        double answer; // variable to hold our answer
        
        // Open up the keyboard for user input
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter first number:");
        num1 = keyboard.nextDouble();

        System.out.println("Enter second number:");
        num2 = keyboard.nextDouble();
        
        answer = num1 + num2;  // simple variable arithmetic
        
        System.out.println("The answer = "+ answer);     
    }

}