 import java.util.*;
 class Data
{
    int val;
    Data(int x)
    {
        val = x;
    }
    
    public void DataMethod()
    {
    	
    }
}
class test
{
 Set<Data> list = new HashSet<Data>();
void doit()
 {
     list.add( new Data(2));
     list.add( new Data(3));
     list.add( new Data(3));

    Iterator<Data> iter = list.iterator();
     while (iter.hasNext())     {
         Data d = iter.next();
         System.out.print(d.val);
     }
    
   }
   public static void main(String[] args)
   {
     test t = new test();
     t.doit();   
  }
 }