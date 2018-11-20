package ZDraft;

import javafx.beans.binding.DoubleBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Practice1108 {
    public static void main(String[] args){
        String s1 = "1";
        int i1 = Integer.parseInt(s1);
        System.out.println(i1);
        char c1 =(char)i1;
        System.out.println(c1 == 49);
        System.out.println(c1);   // true
        notes();
        //
//        String.valueOf();
//        String();
        
    }

    private static void notes(){

        int i1 = 1;
        // this way produce not '1', but ascii 1.
        char c1 =(char)i1;
        System.out.println(c1 == 49);
        System.out.println(c1);
        // this way is real ascii 49, printed as '1'
        System.out.println((char)(c1+48));

        // in a word: value doesn't change during (int) (char)
        // but the presentation change,
        // e.g., char 49 present as '1'
        //       int 49 present as 49
    }
}

class Practice1119{

    public static void main(String[] args){
        String s1 = "1";
        int i1 = Integer.parseInt(s1);
        char c1 = (char)(i1+48);
        System.out.println(c1);
        Character c2 = new Character(c1);
        String s2 = String.valueOf(i1);
        Double d1 = Double.valueOf("2.2");
        System.out.println(d1);
        String s3 = String.valueOf(d1);
        String s4 = String.valueOf(i1);
        String s5 = new String(new char[]{(char)(i1+48)});
        char c3 = ++c2;
        String[] sl1 = s3.split("\\s");
        String[] sl2 = s3.split("\n");
        String[] sl3 = s3.split("\\.");
        for(String s: sl3){
            System.out.println(s);
        }
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s1);
        sb1.append("\n");
        sb1.append(s2);
        String s6 =sb1.toString();
        sl3 = s6.split("\n");
        for(String s: sl3){
            System.out.println(s);
        }
        System.out.println(i1==((char)i1));
        System.out.println(i1==c1);
        System.out.println("a".compareTo("A"));
        System.out.println("aa".compareTo("AA"));
        System.out.println("aa".compareTo("AZ"));
        char c4 = 'a';
        c4 = String.valueOf(c4).toUpperCase().toCharArray()[0];
        c4 = Character.toUpperCase(c4);
        List<Integer> l1 = new ArrayList<>();
        class Foo implements Comparable<Foo>{
            int id;
            Foo(int i){ id = i; }
            @Override
            public int compareTo(Foo o) {
                return -(o.id - id);
            }
        }
        List<Foo> l2 = new ArrayList<>();
        l2.add(new Foo(2)); l2.add(new Foo(1));
        Collections.sort(l2);
        Iterator<Foo> iter = l2.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().id);
        }
    }
}