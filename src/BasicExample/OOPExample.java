package BasicExample;


import BasicExample.A_ExampleList.InnerClassExample;
import BasicExample.A_ExampleList.LambdaExample;
import BasicExample.A_ExampleList.SortExample;

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
//    static void test();
    final static void test(){};
}

interface CanIHaveMethod{
    void test();
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

interface BeExtended {}
interface ExtendingInterface extends BeExtended{}

class StaticExample{
    private int a;
    private static int b;
    StaticExample(){a = b; b=0;}
    public void print(){System.out.println(a);}
    public static void main(String [] args){
        StaticExample s = new StaticExample();
        s.print();
    }
}


class PrivateClass{
    public static void method1(){

    }
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


class CompareExample{
    public static void main(String[] args){
        Integer s=1;
        s.compareTo(2);
    }
}

class HeinzStudent implements Comparable<HeinzStudent>{
    private int id;
    int gpa, age, height;
    HeinzStudent(int id, int gpa){this.id=id; this.gpa=gpa;}
    HeinzStudent(int id, int gpa, int age, int height){this.id=id; this.gpa=gpa; this.age=age; this.height=height;}

    @Override
    public int compareTo(HeinzStudent o) {
        return this.id - o.id;
    }
    // Natural order (small->large, a-z) is this.id - o.id
}

class GpaComparator implements Comparator<HeinzStudent>{
    @Override
    public int compare(HeinzStudent o1, HeinzStudent o2) {
        return o1.gpa - o2.gpa;
    }
}


class Heinz implements InnerClassExample {
    List<HeinzStudent> students;
    Heinz(){
        students = new ArrayList<>();
        students.add(new HeinzStudent(1, 4));
        students.add(new HeinzStudent(2, 3, 22, 180));
        students.add(new HeinzStudent(3, 2, 23, 160));
    }
    void sortbyAgeHeight(){
        // inner class example too.
        class AgeHeightComparator implements Comparator<HeinzStudent>{
            @Override
            public int compare(HeinzStudent o1, HeinzStudent o2) {
                return o1.age-o2.age==0? o1.height-o2.height: o1.age-o2.age;
            }
        }
        Collections.sort(students, new AgeHeightComparator());
    }
}

class InnerClassExample1811 implements SortExample, LambdaExample {
    public static void main(String[]args){
        Heinz mism2018 = new Heinz();
        // Sort by defined order
        Collections.sort(mism2018.students);
        // Sort by interface Comparator's implementation
        Collections.sort(mism2018.students, new GpaComparator());
        // Sort by inner class
        mism2018.sortbyAgeHeight();
        // Sort by anonymous class declaration
        Collections.sort(mism2018.students, new Comparator<HeinzStudent>() {
            @Override
            public int compare(HeinzStudent o1, HeinzStudent o2) {
                return o1.age - o2.age;
            }
        });
        // Sort by lambda expression
        Collections.sort(mism2018.students, (o1, o2)->o1.height-o2.height);
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




class Inteval {
    int i;
    Inteval(){
        this.i = 1;
    }

}

class PolyExample{
    public static void main(String[] args){
        callPerson(new Male());
        callPerson(new Female());
    }
    private static void callPerson(Person p){
        p.show();
    }
}

abstract class Person{
    int strength;
    Person(){ strength = 1; }
    abstract public void show();
}
class Male extends Person{
    public void show(){
        System.out.println(this.strength * 3);
    }
    public void test(){}
}
class Female extends Person{
    public void show(){
        System.out.println(this.strength * 2);
    }
}


class PolymorphismExample{
    // 181212
    public static void main(String args[]){
        Person p = new Male();
//        p.test();
        ((Male) p).test();
    }
}



