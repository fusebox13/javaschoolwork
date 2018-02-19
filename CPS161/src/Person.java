public class Person {
  
	    private String name;
	    private int age;
	    
	    public Person(String n, int a)
	    {
	        name=n;
	        age=a;
	    }
	    public Person(Person p)
	    {
	        name = p.name;
	        age = p.age;
	    }
	    public void setPerson(String n, int a)
	    {
	        name=n;
	        age=a;
	    }
	    public String toString()
	    {
	        return name +" : " + age;
	    }
	    
	public static void main(String[] args) {
		Person p = new Person("Joe", 50);
        Person p2;
        p2 = new Person(p);
        if (p == p2) System.out.println("true for ==");
        else System.out.println("false for ==");

        if (p.equals(p2)) System.out.println("true for equals");
        else System.out.println("false for equals");

	}

}
