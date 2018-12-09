package BasicExample;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
//import com.google.gson.Gson;

public class ReflectionExample {
}


class Student {
    String name;
    public static void main(String[] args) {
        Student MISMStudent = new Student();
        MISMStudent.name = "Bob";

        System.out.println(MISMStudent.getClass().getName());
    }
}


class WhoAmI {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.lang.String");
            Object o = c.newInstance();
            o = "Hello World!";
            System.out.println(c.getName());
        } catch (Exception e) {}
    }
}


// PPT 1
class WhoAmI2 {
    public static void main(String[] args) {
        try {
            Class<?> c =  Class.forName("java.lang.String");
            Object o = c.getConstructor().newInstance();
            o = "Hello World!";
            System.out.println(c.getName());        // what is reflected
            System.out.println(o.getClass().getName());     //
            WhoAmI2 whomi = new WhoAmI2();
            whomi.askWhoAmI();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void askWhoAmI() {
        // Do we need "this." here??
        System.out.println(this.getClass().getName());
        // no. because getClass is an Object Class method.
        // Using an instance method inside a class doesn't need "this."
    }
}


// PPT 2
class SpongeBob {
    public void cookFood() {
        System.out.println("Cooking food");
    }
    public void cookTrouble() {
        System.out.println("Cooking trouble");
    }
}

class Movie {
    public static void main(String[] args) {
        SpongeBob SquarePants = new SpongeBob();
        Movie movie = new Movie();
        movie.cook(SquarePants.getClass());
    }
    // void cook(Class<?> c) {
    void cook(Class<? extends SpongeBob> c){
        try {
            Object o = c.getDeclaredConstructor().newInstance();  //changed since Java 9
            // Can we use:
//            SpongeBob e = c.getDeclaredConstructor().newInstance();
            // Cannot. This is Down Casting. An compile error.
            // SpongeBob e = (SpongeBob)c.getDeclaredConstructor().newInstance();
            // or: look at cook
            SpongeBob e = c.getDeclaredConstructor().newInstance();
            Method method = c.getMethod("cookFood");
            method.invoke(o);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


// PPT 3
class Cafetaria {
    public static void main(String[] args) {
//        Student1206[] friends = new Student1206[3];
        List<Student1206> friends = new ArrayList<>();
//        friends[0] = new Student1206();
//        friends[1] = new HeinzStudent1206();
//        friends[2] = new MISMStudent();
        friends.add(new Student1206());
        friends.add(new HeinzStudent1206());
        friends.add(new MISMStudent());

        ListIterator<Student1206> iter = friends.listIterator();
        System.out.println();
        while (iter.hasNext()) {
            // this is Dynamic binding
            iter.next().tellMeAboutJava();
        }
        while(iter.hasPrevious()){
            // this is Dynamic Invocation
            (new Server()).serve(iter.previous().getClass());
        }
    }
}

class Server {
    public void serve(Class<?> c) {
        System.out.println("Hello " + c.getSimpleName()
                + ". Do you like Java?");
        try {
            Method m = c.getMethod("tellMeAboutJava");
            Object o = c.getConstructor().newInstance();
            m.invoke(o);
        } catch (Exception e) {
//some code here
}}}

class Student1206 {
    public void tellMeAboutJava() {
        System.out.println(this.getClass().getSimpleName() + ": You mean the island?");
}}

class HeinzStudent1206 extends Student1206 {
    public void tellMeAboutJava() {
        System.out.println(this.getClass().getSimpleName() + ": Yeah! I really like that coffee!");
}}


class MISMStudent extends HeinzStudent1206{
    public void tellMeAboutJava() {
        System.out.println(this.getClass().getSimpleName() + ": No thanks!! I've had enough!");
}}


