package CPS261Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


class SortByWeight implements Comparator<Object>
{
    public int compare(Object o1, Object o2)
    {
        Pet p1 = (Pet)o1;
        Pet p2 = (Pet)o2;
        if (p1.getWeight() < p2.getWeight())
            return -1;
        if (p1.getWeight() > p2.getWeight())
            return 1;
        return p1.getName().compareTo(p2.getName());
    }
    public boolean equals(Object obj) // Not sure why this is necessary????
    {
        return false; ///????
    }
}

public class Pets {
public static void main(String[] args) {
      ArrayList<Pet> pets = new ArrayList<Pet>();
      Dog d;

      pets.add(  new Dog("Tiger", 20.0) );   
      pets.add(  new Dog("Fido", 50.0)  );
      pets.add(  new Dog("Maya", 10.0)  );
      pets.add(  new Dog("Benji", 80.0) ); 
      
      // After trying this once, uncomment the equals method in Dog
      // recompile and rerun and see the difference. 
      d = new Dog("Fido", 50.0);
      if (pets.contains(d))
        {
          System.out.println(" We already have a " + d);
        }
      else
        {
            System.out.println("We don't have " + d + "  Adding ...");
            pets.add(d);
        }
      // What happens with the following statement
      Cat c = new Cat("Maya", 10.0);
      if (pets.contains(c))
      {
        System.out.println(" We already have a " + c);
      }
      else
      {
          System.out.println("We don't have " + c + "  Adding ...");
          pets.add(c);
      }

      System.out.println("********** All of my pets gained weight ************");
      Iterator<Pet> iter = pets.iterator();
      while(iter.hasNext())
      {
          Pet p = iter.next();
          p.increment_weight(1.0);
          // Calls appropriate toString method
          System.out.println(p);
      }
      

      System.out.println("Here is my collection :");
      // The following requires you to override toString in the Dog and Cat
      // classes to get something meaningful
      System.out.println(pets);
    
      // Uncomment the following and fix it and print out the sorted list
      Collections.sort(pets);  
	
	   System.out.println("Sorted version of pets:");
      System.out.println(pets.toString());  

      Collections.sort(pets, new SortByWeight());
      System.out.println("Sorted by weight:");
      System.out.println(pets.toString());
      
  }

}
