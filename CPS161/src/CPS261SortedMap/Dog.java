package CPS261SortedMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Dog {
   String name;
   double weight;
Dog(String n, double w) {
      name = n;
      weight =w;
   }
public String toString() {
   return "Dog:"+name +" " + weight;
   }
void print ()
    {
        System.out.println("print: " + toString());
    }
    
public boolean equals(Object obj)
    { 
        if (obj != null)
        {
            Dog d = (Dog)obj;
            if (name.equals(d.name) && weight == d.weight)
                return true;
        }      
        return false;
    }
} // end of class Dog 