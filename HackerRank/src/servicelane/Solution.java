package servicelane;

import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = 0, T = 0;
		
		String s = input.nextLine();
		String[] str = s.split(" ");
		int a[] = new int[str.length];
		
		for(int i = 0; i < str.length; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		
		
		System.out.println(a[0] + "," + a[1]);
		
		int[] width = new int[N];
		
		for (int i = 0; i < N; i++) {
			width[i] = input.nextInt();
		}
		
		
		for (int i = 0; i < N; i++)
			System.out.print(width[i]);
		

	}

}
