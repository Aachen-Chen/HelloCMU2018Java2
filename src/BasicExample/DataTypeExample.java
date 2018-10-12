package BasicExample;

public class DataTypeExample {
    public static void main(String [] args){
//        Transition.runExample();
//        Example.run();
        StringExample.equality();
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

class StringExample{
    static void equality(){
        String s1 = "Hello";
        String s2 = "Hello";

        if (s1 == s2) System.out.println("Equal");
        else System.out.println("Not equal");

        s1 = "Good bye!"; //this will now point to a new location

        System.out.println((s1==s2) ? "Equal": "Not equal");
    }
}

class StringComparison{
    public static void main(String [] args){
        String a = "a";
        String A = "A";
        String bb = "bb";
        String B = "B";

        System.out.println(a.compareTo(A));     // == a - A
        System.out.println(A.compareTo(B));     // == A - B
        System.out.println(a.compareTo(bb));    // == a - b
        System.out.println(bb.compareTo(B));    // == b - B = a - A
        System.out.println("cc".compareTo("bb"));// == c-b

    }
}

class CharExample{
    public static void main(String[] args){
        // +-*/ 3527 + 40
        char multiplyChr = '*';
        int multiplyInt = 42;
        System.out.println(multiplyChr==multiplyInt);
    }
}
