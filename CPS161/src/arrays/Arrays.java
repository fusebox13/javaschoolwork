package arrays;

public class Arrays {

	public static void main(String[] args)
	{
		int[] intArr = new int[10];
		double[] doubleArr = new double[10];
		
		boolean[] boolArr = new boolean[10]; //default value is false
		char[] charArr = new char[10]; // default values are pretty much null
		
		String[] strArr = new String[10];
		
		int[] intArr2 = {1, 2, 3, 4, 5, 6};
		char[] vowels = {'a','e','i','o','u'};
		
		double[] d = {1.1, 1.2, 1.3};
		
		//float[] f = {1.1, 1.2, 1.3}; compilation error
		float[] f = {1.1f, 1.2f, 1.3f}; //correct way to initialize an array of floats
		
		
		String[] strArr2 = {"she","sells","sea","shells"};
		
		Date[] dArr = new Date[3];
		dArr[0] = new Date(6, 23, 1982);
		dArr[1] = new Date(7, 24, 1982);
		dArr[2] = new Date(9, 22, 1982);
		
		Date[] dArr2 = {new Date(6, 23, 1982), new Date(7, 24, 1982), new Date(9, 22, 1982)};
		
		Date[] dArr3 = new Date[3];
		
		for (int i = 0; i < dArr3.length; i++)
		{
			dArr3[i] = new Date();
			
		}
		System.out.println(intArr2.length);
	}
}


