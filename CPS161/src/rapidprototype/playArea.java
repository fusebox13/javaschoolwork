package rapidprototype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class playArea
{
	

	public static void main(String[] args)
	{
		ArrayList<String> a = new ArrayList<String>();
		
		Scanner keyboard = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++)
		{
			String s = keyboard.nextLine();
			a.add(s);
		}
		
		for (String s: a)
		{
			System.out.println(s);
		}
	
	}

	

}