package CPS261Datastructures;

class Dog implements Comparable {
	
	String name;
	int age;
	
	Dog(String name, int age)
	{
	
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return name + ":" + age;
	}
	
	void bark()
    {
        System.out.println(name + " says bark");
    }
	
	@Override
	public int compareTo(Object other) {
		Dog d = (Dog)other;
		int retVal = name.compareTo(d.name);
		return retVal;
	}
	
	public boolean equals(Object ob)
    {
        if (ob == null)
            return false;
        Dog d = (Dog)ob;
        if (name.equals(d.name) && age == d.age)
            return true;
        else
            return false;
    }
}
