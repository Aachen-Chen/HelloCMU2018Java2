package BasicExample;

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
    }
}

