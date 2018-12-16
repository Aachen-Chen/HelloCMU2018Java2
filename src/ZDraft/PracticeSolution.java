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
        for(int num=0; num<5;){
            treeMap.put(s[num], i[num]); num++;
        }

        //TODO: iterate over its key and value, if contains key c or value 2, delete it.
        for(Map.Entry<String, Integer> e: treeMap.entrySet()){
            if(e.getKey().equals("c") || e.getValue()==2){
                treeMap.remove(e.getKey());
            }
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

class DataTypePractice{
    public static void main(String [] args){
        // 2018.12.16.
        // TODO: CONVERSION
        // TODO: String to int
        String s1 = "1";
        int i1 = Integer.parseInt(s1);      // parse presentation

        // TODO: Int to char.
        char c1 =(char)i1;                  // pass value, not presentation
        System.out.println((char)(c1+48));  // this way is real ascii 49, printed as '1'
        // Note: Character does not have .parseChar() method, cannot String->char.

        // TODO: Char to Character
        Character c2 = 'c';

        // TODO: How can we achieve auto-boxing and auto-unboxing:
        // TODO: Can Wrapper ++? Can char / Character ++? Prove with only one example.
        Character c3 = ++c2;    // 1. char can ++; 2. Wrapper can auto box primitive
        int i2 = ++c3;          // 3. Wrapper can ++;  4. Wrapper can auto-unbox to other primitive (not alwayse)
//        Integer ii = ++(new Integer(1));          // cannot ++ new declaration
        Integer ii = i2;
        char c4 = Character.highSurrogate(ii);      // 5. seems to involve surrogate problems.

        // TODO: Can wrapper[]?

        // TODO: any type to any type's Wrapper (String to Integer)
        String s2 = String.valueOf(i1);
        Double d1 = Double.valueOf("2.2");

        // TODO: any wrapper type to String
        // 1213 String's valueOf use both its constructor and... //1216 the objects' toString()
        String s20 = String.valueOf(new Character('c'));
        // TODO: any primitive type to String
        String s5 = String.valueOf(0.2334f);
        System.out.printf("Float to String: %s\n", s5);

        // TODO: what is the difference between String() and String.valueOf(): see it!
        String s = String.valueOf(1);
        // 3 kind:
        // char[], byte - call String();
        // other primitive type - call Wrapper.toString(),
        // wrappers - call Wrapper.toString

        // TODO: Turn char[] into String
        String s6 = new String(new char[]{'a','b','c'});

        // TODO: Use one line to create: a String[] "abcde", an Integer[] {1,2,3,4,5}
        // TODO: Is "abc" =="cbd"?

        // TODO: String (regular expression)
        // TODO: Concatenate two string
        String s7 = s6+s5;

        // TODO: Append string and stringbuilder
        // TODO: Split a String using: white space, new line, tab, etc. "."
        String ss = "abc def\nghi.jkl\tmno";
        String[] sl1 = ss.split("[\\s\n\t.]");
        String[] sl2 = ss.split("\\.");
        for(String sss: sl1) System.out.println(sss);
        for(String sss: sl2) System.out.println(sss);

        // TODO: char, ascii
        // TODO: How do you assign value to char
        // TODO: If assign some value to char, will it print the value?
        // TODO: What is char == int
        // By its true value.
        System.out.println('1'==1);     // false
        System.out.println('1'==49);    // true

        // TODO: What is "a".compareTo("A")
        // Remember natural order return negative.
        // TODO: What is "cc".compareTo("ba")
        // compare only the first character

        // TODO: Turn char 'a' to upper case
        System.out.println(Character.toUpperCase('a'));
    }
}