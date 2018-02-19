package arrays;

import java.util.Scanner;

public class Simple 
{
	
	
	public static void main(String[] args)
	{
		String[] page = new String[55];
		
		page[0] = "abc";
		page[1] = "xyz";
		String s = page[0];
		
		page = new String[56]; // this will allocate a new hunk of memory(old entries will not be the array)
		
		int len = s.length();
	
		System.out.println("Exiting..." + len);
		
	}
}

