package People;

public class Student extends Person
{
	private String major;
	private double gpa;
	
	
	Student()
	{
		this(null, 0, null, 0);
	}
	
	
	Student(String n, int a, String m, double g)
	{
		super(n, a);
		major = m;
		gpa = g;
	}
	
	
	public String toString()
	{
		return super.toString() + ", " + major + ", " + gpa;
	}
	

	public boolean equals(Student s) 
	{
		return getName().equals(s.getName()) && getAge() == s.getAge()
				&& major.equals(s.major) && gpa == s.gpa;
	
	}

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
