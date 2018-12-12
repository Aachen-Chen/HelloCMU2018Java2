package DMultiThread;

public class AccountSemaphore {
}

//Semaphore.java
class Semaphore{}

class AccountThread2 extends Thread {
    Account account;
    int delay;
    Semaphore semaphore;
    public AccountThread2(Account Account,int delay,Semaphore semaphore) {
        this.account =Account;
        this.delay = delay;
        this.semaphore = semaphore;
    }
    public void run(){
        synchronized (semaphore) {
            if (account.balance >= 100) {
                try {
                    sleep(delay);
                    account.balance = account.balance - 100;
                    System.out.println("withdraw  100 successful!");
                }
                catch (InterruptedException e) {
                }
            }
            else
                System.out.println("withdraw failed!");
        }
    }
    public static void main(String[] args) {
        Account Account = new Account(100);
        Semaphore semaphore = new Semaphore();
        AccountThread2 AccountThread1 = new AccountThread2(Account,1000,semaphore);
        AccountThread2 AccountThread2 = new AccountThread2(Account,0,semaphore);
        AccountThread1.start();
        AccountThread2.start();
    }
}

class AccountPractice {
    private int balance=100;
    int withdrawing=0;
    AccountPractice(){ System.out.println("Bank: account created: "+balance); }
    public int check(){
//        System.out.println("Bank: your balance: "+balance);
        System.out.printf(
                "Bank: %s balance: %d\n",
                Thread.currentThread().getName(),
                balance);
        return balance;
    }
    public void withdraw(){
        this.balance-=100;
        System.out.printf("Bank: %s withdraw success!\n",
                Thread.currentThread().getName());
    }

}

class Holder extends Thread{
    int delay; Semaphore s;
    AccountPractice account;
    Holder(int delay, String name, Semaphore s, AccountPractice a){
        super(name); this.delay=delay; this.account=a; this.s=s;
    }
    Holder(int delay, String name, AccountPractice a){
        super(name); this.delay=delay; this.account=a;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.check()>=100){
                try{
                    sleep(delay);
                    account.withdraw();
//                    account.safeWithdraw(100);
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            } else{
              System.out.println(Thread.currentThread().getName()+": I can't withdraw!");
            }
        }
    }

    public static void main(String[] args){
        Semaphore s = new Semaphore();
        AccountPractice a = new AccountPractice();
        Holder h1 = new Holder(100, "First guy", s, a);
        Holder h2 = new Holder(0, "Second guy", s, a);
        h1.start();
        h2.start();
    }
}

