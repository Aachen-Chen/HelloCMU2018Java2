package BasicExample;

public class OOPExample {
    public static void main(String[] args){
        System.out.println("abc5");
    }
}


class AbstractFinalExample {
    public static void main(String [] arg){
        AbClass.aa();
    }
}


abstract class AbClass{
    short a = 1;
    abstract void abc();
    static void aa(){ System.out.println("Suprise!?!?"); };
//    abstract static void bb();
    public static void main(String[] arg){}
}

//class IWanttoHaveAbstractMethod{
//    abstract void someMethod(){
//
//    }
//}


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

    // 1. Could be public / default
    // 2. private method must be implemented HERE
    //    static method also MUST be implemented
    // 3. cannot be protected
    // 4. "public" is redundant
    public void run();
    void run_inpackage();

    private void running(){}
    public static void staticRun(){};
}

class Examplification implements Examplifiable {
    // Must implements ALL non-private method
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


class InnerClassExample {

}

class StaticMethodExample {

    StaticMethodExample(int i){num = i;}
    int num;

    static void run(){
        // Can create obj
        StaticMethodExample e = new StaticMethodExample(1);
        // Can use obj method
        e.methods();
        // Can read obj's field
        System.out.println(e.num);
        // Can change obj's field
        e.num = 2;
        // But cannot use this.
//        this.methods();
    }

    void methods(){
        System.out.println("Member"+num +"'s method!");
    }
}
