import java.util.Scanner;


public class Homework_1 {

	public static void main(String[] args)
	{
		Scanner Keyboard = new Scanner(System.in);
		String v1 = Keyboard.nextLine();
		String v2 = Keyboard.nextLine();
		
		if(v1.equals(v2))
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
		
		for (double sample = 2.6; sample > 0; sample = sample -0.5)
		    System.out.print(sample + " ");
		Keyboard.close();


	}
	public static boolean compare(int n1, int n2)
	{
		return n1 >= n2;
	}

}
