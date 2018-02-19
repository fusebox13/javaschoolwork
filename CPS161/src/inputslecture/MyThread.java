package inputslecture;

import java.util.Date;


public class MyThread extends Thread{

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
        MyThread mt = new MyThread();
        mt.start();
        System.out.println("Exitting main thread");

    }

}