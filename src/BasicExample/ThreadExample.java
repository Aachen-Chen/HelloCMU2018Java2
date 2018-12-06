package BasicExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ThreadExample {
}

class myThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" running.");
    }
}

class LambdaThreadExample{
    public static void main(String[] argss){
        Thread t0 = new Thread();
        Thread t1 = new Thread(new myThread());
        Thread t2 = new Thread(()->{});
        Thread t3 = new Thread(new Runnable(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+": hi!");
            }
        });
    }
}


class Bank {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(30);			//shared resource
        Thread one = new Thread (new BankingThread(b));
        Thread two = new Thread (new BankingThread(b));
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public static String spacer(String name) {	//method to format the console output
        String spacer;
        if (Thread.currentThread().getName().equals("Ryan"))
            spacer = String.format("%" + 50 + "s", " "); //shift Ryan to right column in output
        else spacer = "";
        return spacer;
    }
}

class BankingThread implements Runnable {
    BankAccount b;
    BankingThread(BankAccount b) {
        this.b = b;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName(); //who is running
        String spacer = Bank.spacer(name); //for output formatting.
        for (int i = 0 ; i < 3; i++) {
            b.withdraw(10, i);
            if (b.balance < 0) System.out.println(spacer + name + "*** Account overdrawn");
        }
    }
}

class BankAccount {
    static double balance;
    BankAccount(double balance) { this.balance = balance; }  // constructor

    public void withdraw(double amount, int i) {
        String name = Thread.currentThread().getName(); //who is withdrawing
        String spacer = Bank.spacer(name); //for output formatting. Shifts Ryan to right column.
        if (balance >= amount) {
            try {
                System.out.println(spacer + name + i + " sees balance = $" + balance + " and sleeps");
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(spacer + name + i + " wakes up, withdraws $" + amount);
            } catch (InterruptedException e) { System.out.println(e.getMessage()); }
            balance -= amount;
        } else {
            System.out.println(spacer + name + " sees: Not enough money!");
        }
    }
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


