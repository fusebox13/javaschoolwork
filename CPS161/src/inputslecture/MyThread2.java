package inputslecture;

import java.util.Date;

public class MyThread2 implements Runnable{

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000); // Sleep for 1 second
                Date d = new Date();
                System.out.println("Date =" + d);
            }
            catch (InterruptedException e)
            {            
            }
        }
    }
    public static void main(String[] args) {
        MyThread2 mc = new MyThread2();
        Thread t = new Thread(mc); // This constructor needs any class which implements Runnable
        t.start();
        
        System.out.println("Exitting main thread");

    }

}