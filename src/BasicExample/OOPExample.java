package BasicExample;

public class OOPExample {
    public static void main(String[] args){
        System.out.println("abc5");
    }
}

class PrivateClass{
    public static void method1(){

    }
}

class RunnableClass implements Runnable{
    public void run(){}
}

interface Examplifiable{
    // 1. "public static final" is redundant.
    // 2. don't forget type
    // 3. static final var is CAPITALIZED
    // 4. final var should be initialized
    public static final int EXAMPLE_NUM = 0;

    // 1. could be public / default
    // 2. private method must be implemented HERE
    //    static method also MUST be implemented
    // 3. cannot be protected
    // 4. "public" is redundant
    public void run();
    void run_inpackage();
    private void running(){}

    public static void staticRun(){};
}

class Examplification implements Examplifiable{
    // Must implements all non-private method
    @Override
    public void run() {}

    @Override
    public void run_inpackage() {}
}

class Figures extends Examplification{

    public void run(){
        System.out.println("Run to show Figure.");
    }

    public void run(Object o){
        if(o instanceof Examplification){
            ((Examplification)o).run();
        }
    }
}