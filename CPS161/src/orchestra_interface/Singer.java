package orchestra_interface;

class Person
{
	String name;
	int age;
	
	Person(String n, int a)
	{
		age = a;
		name = n;
	}
}

public class Singer extends Person implements MakeMusic 
{
	Singer(String n, int a)
	{
		super(n, a);
	}

	@Override
	public String getType() {
		return "Singer";
	}

	@Override
	public String play() {
		return "la la la la";
	}
	

}
