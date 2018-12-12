package DMultiThread;

//account.java
class Account {
    double balance;
    public Account(double money) {
        balance = money;
        System.out.println("Totle Money: " + balance);
    }
    public void withdraw(int money){
        balance -= money;
        System.out.println("Bank: your balance is "+balance);
    }
}

public class AccountSimple extends Thread{
    Account account;
    int delay;

    public AccountSimple(Account account, int delay){
        this.account = account; this.delay = delay;
    }

    public void run() {
        if (account.balance >= 100) {
            try {
                sleep(delay);
                account.withdraw(100);
                System.out.println(Thread.currentThread().getName()+" withdraw  100 successful!");
            } catch (InterruptedException e) {
            }
        } else { System.out.println("Insufficient balance."); }
    }

    public static void main(String[] args) {
        Account account = new Account(100);
        AccountSimple t1 = new AccountSimple(account, 1000);
        AccountSimple t2 = new AccountSimple(account, 0);
        t1.setName("First guy"); t2.setName("Second guy");
        t1.start();
        t2.start();
    }
}
