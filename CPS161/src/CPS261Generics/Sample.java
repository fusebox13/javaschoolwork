package CPS261Generics;

public class Sample<T>
{
    private T data;

    public void setData(T newData)
    {
        data = newData;
    }

    public T getData( )
    {
        return data;
    }
    
    public static void main(String[] args)
    {
        Sample<String> sample1 = new Sample<String>();
        
        sample1.setData("HI");
        String s = sample1.getData();
        System.out.println(" sample1="+ s);
        
        Sample<Integer> sample2 = new Sample<Integer>();
        sample2.setData(78);
        int x = sample2.getData();
        System.out.println(" sample2=" + x);
        
        /*
         
         Logically we  have "Manufactured 2 classes":
         
         class Sample<String>
         {
             String data;
             
            public void setData(String newData)
            {
                data = newData;
            }

            public String getData( )
            {
                return data;
            }
         }
         
         
         AND
         
         
         
         class Sample<Integer>  
         {
             Integer data;
             
            public void setData(Integer newData)
            {
                data = newData;
            }

            public Integer getData( )
            {
                return data;
            }
         }
         
        
         */
    }
}