package DMultiThread;

public class AccountWaitNotify {
    private int balance=100;
    int withdrawing=0;
    AccountWaitNotify(){ System.out.println("Bank: account created: "+balance); }
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
    public synchronized int safeWithdraw(int batch){
        System.out.printf("%s try to withdraws %d$.\n",
                Thread.currentThread().getName(), batch );
        if(balance<batch){
            try{
                System.out.printf("%s try to withdraws, insufficient balance.\n",
                        Thread.currentThread().getName());
                withdrawing=batch;
                wait();
            } catch(InterruptedException ie){ }
        }
        balance -= batch;
        System.out.printf("%s now withdraws %d$.\n" +
                        "Current balance: %d$\n",
                Thread.currentThread().getName(), batch, balance );
//        notify();
        return batch;
    }
    public synchronized void safeDeposite(int batch){
        balance += batch;
        System.out.printf("%s deposits %d$, balance: %d$\n",
                Thread.currentThread().getName(), batch, balance);
        if(balance>=withdrawing){notify();}
    }
}


class Depositor extends Thread{
    int delay; AccountWaitNotify account; int upper; int total;
    static boolean stop;
    Depositor(int d, String n, AccountWaitNotify a, int upper){
        super(n); this.delay=d; this.account=a; this.upper=upper;
    }
    @Override
    public void run() {
        stop=false;
        while(total<upper){
            try{
                sleep(delay);
                account.safeDeposite(25);
                total += 25;
            } catch(InterruptedException ie){}
        }
        stop=true;
    }
    public static void main(String[] args){
        AccountWaitNotify account = new AccountWaitNotify();
        Depositor d = new Depositor(25, "Depo", account, 400);
        Withdrawer w = new Withdrawer(20, "With", account, 400);
        d.start();
        w.start();

        try {
            d.join();
            w.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Withdrawer extends Thread{
    int delay; AccountWaitNotify account; int upper; int total;
    Withdrawer(int d, String n, AccountWaitNotify a, int u){
        super(n); this.delay=d; this.account=a; this.upper=u;
    }
    @Override
    public void run() {
        while(total<upper || Depositor.stop){
            total += account.safeWithdraw(100);
        }
    }
}
