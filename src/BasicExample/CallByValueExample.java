package BasicExample;

import java.util.Arrays;

public class CallByValueExample {

    // 180914
    // We all know method can change content reference-type.
    // But, can method change reference itself?
    public static void main(String[] args) {
//        callSomeMethod();
        arraysCopyOF();
    }

    private static void callSomeMethod(){
        int[] x = {10, 20};	 //original
        someMethod(x);
        System.out.println(x[0]);
    }
    private static void someMethod(int[] x) {
        int[] y = {1, 2};
        x = y;		 //copy
    }
    // Answer: no.
    // You can change what the reference refers to,
    // but you cannot change the reference.

    private static void arraysCopyOF(){
        // this copy is a new copy.
        int[] arr = new int[]{2,1,3};
        int[] newarr = arr;
        int[] copyedarr = Arrays.copyOf(arr, arr.length);
        arr[0] = 4;
        // equal copy changed
        System.out.println(newarr[0]);
        // copyed copy doesn't
        System.out.println(copyedarr[0]);
    }
}
