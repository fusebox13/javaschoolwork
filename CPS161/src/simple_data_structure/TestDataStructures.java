package simple_data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Person
{
	int age;
	String name;
	double height;
	
	Person(String n, int a, double h)
	{
		name = n;
		age = a;
		height = h;
		
	}
	
	void ArrayListPersons()
	{
		ArrayList aa = new ArrayList();
		aa.add(new Person("George", 22, 56));
		aa.add(new Person("Fred", 40, 58));
		aa.add(new Person("Sam", 24, 70));
		
		for (int i=0; i < aa.size(); i++)
		{
			Person p = (Person)aa.get(i);
		}
		
		//<String> defines the types of objects that can be used in the ArrayList
		ArrayList<Person> aa2 = new ArrayList<Person>();
		aa2.add(new Person("George", 22, 56));
		aa2.add(new Person("Fred", 40, 58));
		aa2.add(new Person("Sam", 24, 70));
		
		for (int i=0; i < aa2.size(); i++)
		{
			Person s = aa2.get(i);
		}
	}
	
	void ArrayListPersonsWithInterfaces()
	{
		//List aa = new ArrayList();
		List aa = new LinkedList();
		aa.add(new Person("George", 22, 56));
		aa.add(new Person("Fred", 40, 58));
		aa.add(new Person("Sam", 24, 70));
		
		for (int i=0; i < aa.size(); i++)
		{
			Person p = (Person)aa.get(i);
		}
		
		//<String> defines the types of objects that can be used in the ArrayList
		//List<Person> aa2 = new ArrayList<Person>();
		List<Person> aa2 = new LinkedList();
		aa2.add(new Person("George", 22, 56));
		aa2.add(new Person("Fred", 40, 58));
		aa2.add(new Person("Sam", 24, 70));
		
		for (int i=0; i < aa2.size(); i++)
		{
			Person s = aa2.get(i);
		}
	}
}

public class TestDataStructures {

	void ArrayListStrings()
	{
		ArrayList aa = new ArrayList();
		aa.add("red");
		aa.add("blue");
		aa.add("green");
		
		for (int i=0; i < aa.size(); i++)
		{
			String s = (String)aa.get(i);
		}
		
		//<String> defines the types of objects that can be used in the ArrayList
		ArrayList<String> aa2 = new ArrayList<String>();
		aa2.add("red");
		aa2.add("blue");
		aa2.add("green");
		
		for (int i=0; i < aa2.size(); i++)
		{
			String s = aa2.get(i);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
