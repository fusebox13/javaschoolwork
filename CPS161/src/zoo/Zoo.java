package zoo;

public class Zoo
{
	private int actual_num_animals = 0;
	private int num_cages;
	private Animal[] animals;
	
	
	Zoo()
	{
		this(20);
	}
	
	
	Zoo(int n_c)
	{
		num_cages = n_c;
		animals = new Animal[num_cages];
	}
	
	
	public void add(Animal a)
	{
		if(actual_num_animals < num_cages)
		{
			animals[actual_num_animals] = a;
			actual_num_animals++;
		
		}
		else
			System.out.println("Zoo is full.");
	}
	
	
	public double total_weight()
	{
		int total_weight = 0;
		
		
		for (int i = 0; i < actual_num_animals; i++)
			total_weight+=animals[i].getWeight();
		
		
		return total_weight;
	}
	
	
	void make_all_noises()
	{
		for (int i = 0; i < actual_num_animals; i++)
			animals[i].makeNoise();
	}
	
	
	void print_all_animals()
	{
		for (int i = 0; i < actual_num_animals; i++)
			System.out.println(animals[i]);	
	}


	public static void main(String[] args)
	{
		Zoo z = new Zoo();
		Snake sly = new Snake("Sly", 5.0 , 2, 2);
		Snake sly2 = new Snake("Slyme", 10.0 , 1, 2);
	    Cow blossy = new Cow("Blossy", 900., 5,  10);
	    Horse prince = new Horse("Prince", 1000., 5, 23.2);
	
	    // Following not allowed because Animal is abstract
	    //Animal spot = new Animal("Spot", 10., 4);
	    
	    z.add(sly);
	    z.add(sly2);
	    z.add(blossy);
	    z.add(prince);
	    
	    z.make_all_noises();
	    System.out.println("Total weight =" + z.total_weight());
	    System.out.println("**************************");
	    System.out.println("Animal Printout:");
	    z.print_all_animals();  
    
	}

}
