package CPS261SetBasics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Dog implements Comparable<Dog>
{
    String name;
    int age;
    Dog(String n, int a)
    {
        name=n;
        age = a;
    }
    public String toString()
    {
        return name +":" + age;
    }
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj != null)
        {
            Dog otherDog = (Dog)obj;
            if (name.equals(otherDog.name) && age == otherDog.age)
                return true;
        }
        return false;        
    }
    
     public int hashCode()
     {
         return age * name.hashCode();
     } 
     
     
     @Override
     public int compareTo(Dog d) {
         int retval = name.compareTo(d.name);
         if (retval != 0)
             return retval;
         return (age - d.age);
     }
	
      
     
}