package ArrayLab;

public class CodeSnippets {
	
	public static void main(String[] args) 
	{
		
		printIntegers(createIntegers(100));

	}
	
	public static int[] createIntegers(int size_of_array)
	{
		int[] array = new int[size_of_array];
		for (int index = 0; index < array.length; index++)
		{
			array[index] = index * 100;
		}
		return array;
	}
	
	public static void printIntegers(int[] array)
	{
		for (int index = 0; index < array.length; index++)
			System.out.println(array[index]);
	}

}
