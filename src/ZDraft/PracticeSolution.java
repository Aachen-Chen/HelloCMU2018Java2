package ZDraft;

import java.util.*;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import BasicExample.A_ExampleList.*;

public class PracticeSolution {
    // TODO: Use one line to create: a String[] “abcde”, an Integer[] {1,2,3,4,5}
    String[] s = "d b e c a".split("\\s"); Integer[] i = new Integer[]{4,2,5,3,1};
}

class QueueSolution implements QueueExample {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");

        Iterator<String> nameIterator = names.iterator();
        // Iterate over all elements in the list
        while (nameIterator.hasNext()) {
            // Get the next element from the list
            String name = nameIterator.next();
            System.out.println(name);
            nameIterator.remove();
        }
        System.out.println(names);

        Queue<Integer> q = new LinkedList<>();
    }
}

class MapSolution implements MapExample {
    public static void main(String[] args) {
        //TODO: Create a Comparator<String>, first sort by lexicography, ignore case, reverse; then String length.
        Comparator<String> com = Comparator.comparing(String::toLowerCase);
        com = com.reversed().thenComparing(String::length);

        //TODO: Create a TreeMap<String> with above comparator
        SortedMap<String, Integer> treeMap = new TreeMap<>(com);

        //TODO: add key dbeca, value 42531
        String[] s = "d b e c a".split("\\s"); Integer[] i = new Integer[]{4,2,5,3,1};
        for(int num=0; num<5;){ treeMap.put(s[num], i[num]); num++; }

        //TODO: iterate over its key and value, if contains key c or value 2, delete it.
        for(Map.Entry<String, Integer> e: treeMap.entrySet()){
            if(e.getKey().equals("c") || e.getValue()==2){ treeMap.remove(e.getKey()); }
        }

        //TODO: take [0, 2) of the treemap to create a hashmap
        Map<String, Integer> hashMap;
        hashMap = new HashMap<>((treeMap).subMap(treeMap.firstKey(), "d" ) );

        //TODO: remove last element
        hashMap.remove(treeMap.lastKey());

        //TODO: check if hashmap is empty
        //TODO: return hasmap’s size
        if(!hashMap.isEmpty()) {System.out.println(hashMap.size());}
    }
}
