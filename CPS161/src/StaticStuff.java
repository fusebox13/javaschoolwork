
public class StaticStuff 
{
	
	StaticStuff()
	{
		
	}
	
	public static int add(int a, int b)
	{
		return a+b;
	}
	
	public int add2(int a, int b)
	{
		return a+b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StaticStuff SS = new StaticStuff();
		System.out.println(SS.add2(2, 3));
		System.out.println(StaticStuff.add(1,2));

	}

}
