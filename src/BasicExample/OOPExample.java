package BasicExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public static void main(String[]args){
        Heinz mism2018 = new Heinz();
        Collections.sort(mism2018.students);
        Collections.sort(mism2018.students, new GpaComparator());
        mism2018.sortbyAgeHeight();
        Collections.sort(mism2018.students, new Comparator<HeinzStudent>() {
            @Override
            public int compare(HeinzStudent o1, HeinzStudent o2) {
                return o1.age - o2.age;
            }
        });
        Collections.sort(mism2018.students, (o1, o2)->o1.height-o2.height);
    }
}

class Heinz{
    List<HeinzStudent> students;
    Heinz(){
        students = new ArrayList<HeinzStudent>();
        students.add(new HeinzStudent(1, 4));
        students.add(new HeinzStudent(2, 3, 22, 180));
        students.add(new HeinzStudent(3, 2, 23, 160));
    }
    void sortbyAgeHeight(){
        class AgeHeightComparator implements Comparator<HeinzStudent>{
            @Override
            public int compare(HeinzStudent o1, HeinzStudent o2) {
                return o1.age-o2.age==0? o1.height-o2.height: o1.age-o2.age;
            }
        }
        Collections.sort(students, new AgeHeightComparator());
    }
}

class HeinzStudent implements Comparable<HeinzStudent>{
    private int id;
    private int gpa;
    int age;
    int height;
    HeinzStudent(){this.id=0; this.gpa=0; this.age=20; this.height=170;}
    HeinzStudent(int id, int gpa){this.id=id; this.gpa=gpa;}
    HeinzStudent(int id, int gpa, int age, int height){this.id=id; this.gpa=gpa; this.age=age; this.height=height;}

    @Override
    public int compareTo(HeinzStudent o) {
        return this.id - o.id;
    }
    public int getGpa() {return gpa;}
//    public String toString(){
////        return String.valueOf()
//    }
}

class GpaComparator implements Comparator<HeinzStudent>{
    @Override
    public int compare(HeinzStudent o1, HeinzStudent o2) {
        return o1.getGpa() - o2.getGpa();
    }
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
