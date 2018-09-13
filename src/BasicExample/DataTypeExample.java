package BasicExample;

public class DataTypeExample {
    public static void main(String [] args){
//        Transition.runExample();
        Example.run();
    }
}

class Transition{
    static void runExample(){
        // WrapperA → WrapperB: WrapperA.valueOf
        String a ="123";
        Integer i = 1;
        i = Integer.valueOf(a);
        System.out.println(++i);

        System.out.println(a.toCharArray());
        for(char x:a.toCharArray()){
            System.out.println(x);
        }

        System.out.println(Byte.MAX_VALUE);

        //  primitive type holds different location.
        int x = 1;
        int y = x;
        y = y+1;
        System.out.println(x);

        int[] arr1 = new int[] {0,1};
        int[] arr2 = arr1;
        arr2[0] = 1; arr2[1]=2;
        System.out.println(arr1[0]+" "+arr1[1]);

        char chr = 46;
        System.out.println(chr);
    }
}

class Example{

    Example(int i){num = i;}
    int num;

    static void run(){
        // Can create obj
        Example e = new Example(1);
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