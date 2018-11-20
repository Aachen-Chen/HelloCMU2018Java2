package BasicExample;

import java.util.Arrays;

public interface ReferenceExample {

}

class CallByExample implements ReferenceExample {
    // 180914
    // We all know method can change content reference-type.
    // But, can method change reference itself?
    public static void main(String[] args) {
        changeReferenceTypeFailed();

    }

    private static void changeReferenceTypeFailed() {
        int[] x = {10, 20};     //original
        changeReferenceType(x);
        System.out.println(x[0]);
    }

    private static void changeReferenceType(int[] x) {
        int[] y = {1, 2};
        x = y;         // a copy of x.
    }
    // Answer: no.
    // You can change what the reference refers to,
    // but you cannot change the reference.
}

class ArrayCopyExample implements ReferenceExample {
    private static void main(String[] args){
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


class NodeNextExample{
    // 181120
    static class Node{int val; Node next; Node(int i){val=i;}}
    public static void main(String[] args){
        Node n = new Node(1);
        Node root = n;
        n = n.next;
        // what is root now?
        try{System.out.println(root.val);}
        catch(NullPointerException e){System.out.println("Null pointer.");}
    }
}



