package DMultiThread;

public class TestThreadPriority extends Thread
{

    public TestThreadPriority(String name)
    {
        super(name);
    }

    public static void main(String[] args)
    {
        TestThreadPriority t1 = new TestThreadPriority("Thread1");
        t1.setPriority(Thread.MIN_PRIORITY);

        TestThreadPriority t2 = new TestThreadPriority("Thread2");
        t2.setPriority(Thread.NORM_PRIORITY);

        TestThreadPriority t3 = new TestThreadPriority("Thread3");
        t3.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        t3.start();

        t1.start();

        // firstly: changing order of start() does change order of execution
    }

    public void run()
    {
        for (int i = 0; i < 3; i++)
            System.out.println(this.getName() + " is running!");
    }
}
