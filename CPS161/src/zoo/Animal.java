package zoo;

public abstract class Animal 
{
	private String name;
	private double weight;
	private int age;
	
	
	Animal()
	{
		this("", 0.0, 1);
	}
	
	
	Animal(String n, double w, int a)
	{
		name = n;
		weight = w;
		age = a;
	}
	
	
	public abstract void makeNoise();
	
	
	double getWeight()
	{
		return weight;
	}
	
	
	public String toString()
	{
		return "Name: " + name + " / Weight: " + weight + " / Age: " + age;
	}

}




class Cow extends Animal
{
	private int num_spots;
	
	
	Cow()
	{
		super("", 0.0, 1);
		num_spots = 0;
	}
	
	
	Cow(String n, double w, int a, int n_s)
	{
		super(n, w, a);
		num_spots = n_s;
	}
	
	
	public void makeNoise()
	{
		System.out.println("Moo");
	}
	
	
	public String toString()
	{
		return super.toString() + " / Number of Spots: " + num_spots;
	}
	
}



class Horse extends Animal
{
	private double top_speed;
	
	
	Horse()
	{
		super("", 0.0, 1);
		top_speed = 0.0;
	}
	
	
	Horse(String n, double w, int a, double t_s)
	{
		super(n, w, a);
		top_speed = t_s;
	}
	
	
	public void makeNoise()
	{
		System.out.println("Whinny");
	}
	
	
	public String toString()
	{
		return super.toString() + " / Top Speed: " + top_speed;
	}
	
}



class Snake extends Animal
{
	private int num_fangs;
	
	Snake()
	{
		super("", 0.0, 1);
		num_fangs = 0;
	}
	
	Snake(String n, double w, int a, int n_f)
	{
		super(n,w,a);
		num_fangs = n_f;
	}
	
	public void makeNoise()
	{
		System.out.println("Hissssss");
	}
	
	public String toString()
	{
		return super.toString() + " / Number of Fangs: " + num_fangs;
	}
}
