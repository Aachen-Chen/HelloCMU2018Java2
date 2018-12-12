package DMultiThread;

import java.util.LinkedList;
import java.util.Queue;
import BasicExample.A_ExampleList.ThreadExample;


public class ThreadExamples implements ThreadExample {
}

class myThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" running.");
    }
}

class PPT11_1 {
    public static void main(String[] argss){
        // Declaration
        Thread t0 = new Thread();
        Thread t1 = new Thread(new myThread());
        Thread t2 = new Thread(()->{});
        Thread t3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+": hi!");
        });
        Thread t4 = new Thread(new Runnable(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+": hi!");
            }
        });

        // setting name
        t3.setName("t3");

        // Start - regular method
        t3.start();
        t4.start();
        t3.run();
        t4.run();
    }
}


class Bank {
    public static void main(String[] args) {

    }

    public static String spacer(String name) {	//method to format the console output
        String spacer;
        if (Thread.currentThread().getName().equals("Ryan"))
            spacer = String.format("%" + 50 + "s", " "); //shift Ryan to right column in output
        else spacer = "";
        return spacer;
    }
}

class BankingThread {
}

class BankAccount {

}




class Store{
    public static void main(String[] args){
        Door door = new Door();
        Door.maxPersons = 10;
        door.delay = 10;
        Door.sitTime = 10;
        long startTime = System.currentTimeMillis();
        Thread guard = new Thread(door);
        Thread seat = new Thread(new Seat());

        guard.start(); seat.start();
        try{
            guard.join();
            seat.join();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Math.round((endTime - startTime) * 1000));
    }
}

class Door implements Runnable{
    static Queue<Person1129> line = new LinkedList<>();
    static int maxPersons, sitTime;
    int count, delay;
    @Override
    public void run(){
        while(count<maxPersons){
            try{
                synchronized (Door.line){
                    line.offer(new Person1129());
                    count++;
                }
                Thread.sleep(delay);
            } catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}

class Seat implements Runnable{
    int seatCount = 0;
    @Override
    public void run(){
        Person1129 p;
        while(seatCount < Door.maxPersons){
            synchronized (Door.line){
                p = Door.line.poll();
            }
            if(p!=null){
                try{
                    Thread.sleep(5);
                }catch (Exception e){

                }
            }
        }
    }
}

class Person1129{
    static int count;
    int id;
    Person1129(){
        id = count++;
    }
}


