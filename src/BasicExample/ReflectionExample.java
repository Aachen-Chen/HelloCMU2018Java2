package BasicExample;

public class ReflectionExample {
}


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