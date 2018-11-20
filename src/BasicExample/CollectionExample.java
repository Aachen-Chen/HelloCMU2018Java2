package BasicExample;

import java.util.*;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Stack;

public class CollectionExample {
    public interface WordLadderII126{};

}

class OperationExamples{
    public static void main(String[] args){
        int[] il = new int[]{1,2,3, 4, 5};
        String[] sl = new String[]{"a", "b", "c"};
        List<Integer> al = new ArrayList<>();
        for(int i: il){al.add(i);}
        for(int i=0; i<al.size(); i++){System.out.println(al.get(i));}
        al.set(10, 1);
        al.remove(1);

        // Implement by Iterator
        // Change plural digit to 10 and delete them.
        Iterator<Integer> iter = al.iterator();
        while(iter.hasNext()){
            if((iter.next() % 2)==0) { iter.remove();}
        }   // you cannot modify with iter. Use ListIterator
        ListIterator<Integer> liter = al.listIterator();
        while(iter.hasNext()){
            if((liter.next() % 2)==0) { liter.set(10); liter.add(11);}
        }   // you cannot delete with iter. Use ListIterator

    }
}





