package CPS261SetBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


// Change the HashSet to LinkedHashSet
// Change the HashSet to TreeSet

public class MathSet<T> extends TreeSet<T> {

    Set<T> union(Set <T> other)
    {
        Set<T> union = new MathSet<T>();
        
        Iterator<T> iter = iterator();
        while (iter.hasNext())
        {
            union.add(iter.next());
        }
        
        iter = other.iterator();
        while (iter.hasNext())
        {
            // We don't have to check if it's there
            // because a Set will only add a unique 
            // item once.
            union.add(iter.next());
        }
        
        
        return union;
    }
    
    Set<T> intersection (Set<T> other)
    {
        Set<T> intersection = new MathSet<T>();
        
        Iterator<T> iter = iterator();
        while (iter.hasNext())
        {
            T obj = iter.next();
            if (other.contains(obj))
                intersection.add(obj);
        }
        return intersection;
    }
    
    public static void dump(Set<String> s)
    {
        Iterator<String> iter = s.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
    }
    
    
    public static void main(String[] args) {
        MathSet<String> mySet1 = new MathSet<String>();
        MathSet<String> mySet2 = new MathSet<String>();
        
        mySet1.add("Michigan");
        mySet1.add("Ohio");
        mySet1.add("Indiana");
        mySet1.add("Kentucky");
        
        mySet2.add("Michigan");
        mySet2.add("Ohio");
        mySet2.add("Indiana");
        mySet2.add("Texas");
        mySet2.add("Alaska");
        
        Set<String> union = mySet1.union(mySet2);
        Set<String> intersection = mySet1.intersection(mySet2);
               
        System.out.println(" *********  Intersection ***********");
        dump(intersection);
        System.out.println(" *********  Union ***********");
        dump (union);
    }
}