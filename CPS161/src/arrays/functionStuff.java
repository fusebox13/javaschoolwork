package arrays;

class Data
{
	int z = 10;
	
	public String toString()
	{
		return "" + z;
	}
}

public class functionStuff {

	void func2(Data d)
	{
		d.z = 100;
	}
	
	void func(int x)
	{
		x = 100;
	}
	
	void func3(String s)
	{
		s = "xyz";
	}
	
	public static void main(String[] args) 
	{
		functionStuff fs = new functionStuff();
		int y = 1;
		fs.func(y); // won't change y because the int class is immutable
		System.out.println("y= " + y);
		
		Data d = new Data();
		fs.func2(d); // will change the d because it is mutable d2 points to the same hunk of memory as d
		System.out.println("Data.z = " + d);
		
		String s = "abc";
		fs.func3(s); // won't change s because the String class is immutable
		System.out.println("S = " + s);
		
		

	}

}
