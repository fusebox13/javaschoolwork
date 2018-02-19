package CPS261SortedMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dogs {
public static void main(String[] args) {
      //Map<String, Dog>  dogs = new LinkedHashMap<String, Dog>();
     // Map<String, Dog>  dogs = new HashMap<String, Dog>();
      SortedMap<String, Dog>  dogs = new TreeMap<String, Dog>();
      Dog d;
      
      // Note that one object can have more than one key
      d = new Dog("Addy", 50.0);
      dogs.put("Addy", d);
      dogs.put("neighborDog", d);
      
      dogs.put("Tiger",  new Dog("Tiger", 10.0) ); 
      dogs.put("Tiger1",  new Dog("Tiger", 20.0) );  
      dogs.put("Tiger2",  new Dog("Tiger", 30.0) );   
      dogs.put("Fido",   new Dog("Fido", 20.0)  );  
      dogs.put("Fido1",   new Dog("Fido", 10.0)  );  
      dogs.put("Fido2",   new Dog("Fido", 30.0)  );
      dogs.put("Maya",   new Dog("Maya", 25.0)  );
      dogs.put("Zorn",   new Dog("Zorn", 25.0)  );
      dogs.put("Benji",  new Dog("Benji", 66.0) ); 
      dogs.put("Spot",  new Dog("Spot", 16.0) );
      dogs.put("Garfunkel",  new Dog("Garfunkel", 36.0) ); 
      dogs.put("Oscar",  new Dog("Oscar", 34.0) );  
      dogs.put("Beefy",  new Dog("Beefy", 134.0) ); 
      dogs.put("Abe",  new Dog("Abe", 21.0) ); 
      dogs.put("Trixy",  new Dog("Trixy", 21.0) ); 
      dogs.put("Fred",  new Dog("Fred", 45.0) ); 
      dogs.put("Zed",  new Dog("Zed", 32.0) ); 
      dogs.put("Foxy",  new Dog("Foxy", 32.0) ); 
      dogs.put("Bob",  new Dog("Bob", 31.0) ); 
      dogs.put("BigRed",  new Dog("BigRed", 98.0) ); 
      dogs.put("Rover",  new Dog("Rover", 44.0) );  
      dogs.put("Pooch",  new Dog("Pooch", 24.0) ); 
      dogs.put("Socrates",  new Dog("Socrates", 15.0) ); 
      dogs.put("Pudge",  new Dog("Pudge", 112.0) );  
      
      // Looking up objects by Value
      // After trying this once, uncomment the equals method in Dog
      // recompile and rerun and see the difference. 
      d = new Dog("Fido", 20.0);
      if (dogs.containsValue(d))
        {
        // This works because we implemented "equals" on the Dog class
          System.out.println(" containsValue(Dog(Fido,20.0): true : " + d);
          
        }
        
      // Looking up objects by Key
      if (dogs.containsKey("Fido"))
      {
        // Can't add another object with the same key
         System.out.println(" containsKey(Fido) true: " + dogs.get("Fido"));
      }
        
      // Normal way to use a HashMap for lookup -- 
      // the get method is the preferred way to access objects stored in 
      //     HashMap because of its efficiency.
      
      d = dogs.get("Tiger");
      System.out.println("Tiger object: " + d);
        

      System.out.println("***** Iterating by Keys ****");
      Set<String> s = dogs.keySet();
      Iterator<String> iter = s.iterator();
      
      while(iter.hasNext())
      {
          String key = iter.next();
          d = dogs.get(key);
          System.out.println("key="+ key + " dog=" + d.toString());
      }

      System.out.println("***** Iterating by Values ****");
      Collection<Dog> collection = dogs.values();
      Iterator<Dog> iterValue = collection.iterator();
      
      while(iterValue.hasNext())
      {
          d = iterValue.next();
          d.print();
      }

      System.out.println("***** Iterating by Mappings ****");
      Set<Map.Entry<String,Dog> >  mappings = dogs.entrySet();
      Iterator<Map.Entry<String,Dog> > iterMapping = mappings.iterator();
      
      while(iterMapping.hasNext())
      {
          Map.Entry<String, Dog> entry = iterMapping.next();
          System.out.println("key="+ entry.getKey() + " value="+entry.getValue());
      }
      
      System.out.println(" firstKey="+ dogs.firstKey());
      System.out.println(" lastKey="+ dogs.lastKey());
      
      System.out.println("****** sortedMap subsets *******");
      //SortedMap<String, Dog> sortedMap = dogs.headMap("BigRed");
      SortedMap<String, Dog> sortedMap = dogs.tailMap("Socrates");
      //SortedMap<String, Dog> sortedMap = dogs.subMap("BigRed", "Socrates");

      Set<String>sortedSet = sortedMap.keySet();
      Iterator<String> siter = sortedSet.iterator();
      while (siter.hasNext())
      {
          System.out.println(siter.next());
      }
      
  }
}