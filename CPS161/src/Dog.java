
public class Dog 
{
	int age;
	String breed;
	String name;
	
	Dog()
	{
		
		
		
	}
	
	Dog(int a, String b, String n)
	{
		age = a;
		breed = b;
		name = n;
	}
	
	public void makeSound()
	{
		System.out.println("Bark");
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getBreed()
	{
		return breed;
	}
	
	public String getName()
	{
		return name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Dog Klaus = new Dog(7, "Jack Russell Terrier", "Klaus");
		Dog Belle = new Dog(11, "Jack Russell Terrier", "Belle");
		
		System.out.println(Belle.getName() + " / " + Belle.getBreed() + " / " + Belle.getAge());
		System.out.println(Klaus.getName() + " / " + Klaus.getBreed() + " / " + Klaus.getAge());
		
		

	}

}
