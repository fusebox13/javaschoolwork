package threadlectures;

class Bucket {
    private int contents;
    private boolean fullFlag = false;

    public synchronized int get(int consumerNumber) {
        while (!fullFlag) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        System.out.println("Consumer " + consumerNumber +
                " Emptying Bucket " + contents);
        fullFlag = false;
        notify(); // Wake up any Producer waiting for an empty bucket
        return contents;
    }

    public synchronized void put(int value) {
        while (fullFlag) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        System.out.println("Filling Bucket " + value);
        contents = value;
        fullFlag = true;
        notify(); // Wake up any Consumer waiting for a full bucket
    }
}
// ******************************************************
class Producer extends Thread {
    private Bucket bucket;
    private int number;

    public Producer(Bucket c, int number) {
        bucket = c;
        this.number = number;
    }

    public void run() {
        int fillValue;
        for (int i = 0; i < 10; i++) {
            try {
                sleep((int)(Math.random() * 2000));
            } 
            catch (InterruptedException e) { }

            fillValue = i + number*100;
            bucket.put(fillValue);
        }
        System.out.println("****Terminating Producer " + number);
    }
}

//********************************************************
class Consumer extends Thread {
    private Bucket bucket;
    private int number;

    public Consumer(Bucket c, int number) {
        bucket = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i=0; i < 10; i++) {
            value = bucket.get(number); 
        }
        System.out.println("****Terminating Consumer " + number);
    }
}

//**********************************************************

public class WaitNotify {
    public static void main(String[] args) {
        Bucket bucket = new Bucket();
        Producer p1 = new Producer(bucket,1);
        Consumer c1 = new Consumer(bucket,1);
        c1.start();
        p1.start();
        
        Bucket bucket2 = new Bucket();
        Producer p2 = new Producer(bucket2,2);
        Consumer c2 = new Consumer(bucket2,2);
        c2.start();
        p2.start();
        System.out.println("WaitNotify will exit now");
    }
}