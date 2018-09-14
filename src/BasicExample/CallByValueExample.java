package BasicExample;

public class CallByValueExample {

    // 180914
    // We all know method can change content reference-type.
    // But, can method change reference itself?
    public static void main(String[] args) {
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
}
