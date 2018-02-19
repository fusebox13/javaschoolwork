package People;

public class Person {

	private String name;
	private int age;
	
	
	Person()
	{
		this(null, 0);
	}
	
	
	Person(String n, int a)
	{
		name = n;
		age = a;
	}
	
	
	public String toString()
	{
		return name + ", " + age;
	}
	
	
	public void setName(String n)
	{
		name = n;
	}
	
	
	public void setAge(int a)
	{
		age = a;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getAge()
	{
		return age;
	}

	
	public boolean equals(Person p) 
	{
		return name.equals(p.name) && age == p.age;	
	}

}
