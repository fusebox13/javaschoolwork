package CPS261SortedMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Stats {
    int count =1;
    int loopIndex;
    Stats(int loopIndex)
    {
        this.loopIndex = loopIndex;
    }
    public String toString() {
        return  " count="+count + " loop index="+ loopIndex;
    }
}
//----------------------

class Statistics {
    public static void main(String[] args) {
        //Map<Integer, Stats> map = new LinkedHashMap<Integer, Stats>();
        Map<Integer, Stats> map = new HashMap<Integer, Stats>();
        //Map<Integer, Stats> map = new TreeMap<Integer, Stats>();
        Stats stats;
        for(int loopIndex =0;loopIndex <50000; loopIndex++) 
        {
            // Produce a number between 0 and 50:
            Integer r = new Integer((int)(Math.random() * 50));
            stats = map.get(r);
            if(stats != null)
            {
                stats.count++;
            }
            else
            {    
                stats = new Stats(loopIndex);
                map.put(r, stats);
            }
        }

        Set<Integer> keys = map.keySet();
        Iterator<Integer> iter = keys.iterator();

        while(iter.hasNext())
        {
            Integer key = iter.next();
            System.out.println("key="+ key + " value="+ map.get(key));
        }


    }// end of main
} 
