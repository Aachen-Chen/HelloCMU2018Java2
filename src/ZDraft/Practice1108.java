package ZDraft;
import javafx.beans.binding.DoubleBinding;

import java.util.*;

//TODO: Int to char.
//TODO: what is the difference between String() and String.valueOf(): see it!
//TODO: Can Wrapper ++? Can char / Character ++? Prove with only one example.
//TODO: Split a String using: white space, new line, tab, etc. "."
//TODO: What is ''char == int"
//TODO: What is "a".compareTo("A")
//TODO: What is "cc".compareTo("ba")
//TODO: Turn char a = 'a' to upper case
//TODO: Sort an array. What is the compareTo, and how to change it? 1119 remember natural order!

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

class Practice1121{
    public static void main(String[] args){
        //TODO: Int to char.
        int i = 1;
        char c = (char)i;
        System.out.println((char)(i+48));
        System.out.println((char)(i+(int)('0')));

        //TODO: what is the difference between String() and String.valueOf(): see it!
        String s = String.valueOf(1);
        // 3 kind:
        // char[], byte - call String();
        // other primitive type - call Wrapper.toString(),
        // wrappers - call Wrapper.toString

        //TODO: Can Wrapper ++? Can char / Character ++? Prove with only one example.
        Character C = 'c';
        int ii = ++C;

        //TODO: Split a String using: white space, new line, tab, etc. "."
        String ss = "abc def\nghi.jkl\tmno";
        String[] sl1 = ss.split("[\\s\n\t.]");
        String[] sl2 = ss.split("\\.");
        for(String sss: sl1) System.out.println(sss);
        for(String sss: sl2) System.out.println(sss);

        //TODO: What is "char == int"
        // By its true value.
        System.out.println('1'==1);     // false
        System.out.println('1'==49);    // true

        //TODO: What is "a".compareTo("A")
        System.out.println("a".compareTo("A"));    // true
        System.out.println((int)('a'-'A'));    // true

        //TODO: What is "cc".compareTo("ba")
        // compare only the first character

        //TODO: Turn char a = 'a' to upper case
        char cc = 'a';
        System.out.println(Character.toUpperCase(cc));

        //TODO: Sort an array. What is the compareTo, and how to change it?
        // 1119 remember natural order!
        // 1121 mind Arrays and Collections
        int[] il = new int[]{4,3,2,1};
        Arrays.sort(il);
        for(int iii: il)System.out.println(iii);
        List<Integer> ill = new ArrayList<>();
        for(int iii: il) ill.add(iii);
//        Arrays.sort(ill);
        Collections.sort(ill);
    }
}

class Practice1213{
    public static void main(String[] args){
        String s = "1";
        // TODO: String to int
        int i = Integer.parseInt(s);

        // TODO: Int to char.
        char c = (char)i;
        System.out.println((char)((int)'0'+c)); //1213 bet on '1'.

        // TODO: Char to Character
        Character cc = c;

        // TODO: How can we achieve auto-boxing and auto-unboxing:
        // like above should be fine.

        // TODO: Can Wrapper ++? Can char / Character ++? Prove with only one example.
        Character c2 = ++c;
        char c3 = ++c2;

        // TODO: any type to String         // 1213 String's valueOf use both its constructor and...
        String s2 = String.valueOf(cc);

        // TODO: any type to any type's Wrapper (String to Integer)
//        Integer i2 = Integer.valueOf(s2);     // 1213 this can't be done 'cause s2 is not a number in ascii.
            // 1213 thus, remember: int->char pass value, String->int pass meaning
        Integer i3 = Integer.valueOf(cc);
        Integer i2 = Integer.valueOf(c);
//        Integer i5 = Integer.valueOf(new Double(2.22));   // Unless involve precision.

        // TODO: any wrapper type to String
        String s3 = String.valueOf(i2);
        String s4 = String.valueOf(new Double(0.11));

        // TODO: any primitive type to String
        String s5 = String.valueOf(0.2334f);

        // TODO: what is the difference between String() and String.valueOf(): see it!
        // See 1121

        // TODO: Turn char[] into String
        String s6 = new String(new char[]{'a','b','c'});

        // TODO: Concatenate two string
        String s7 = s6+s5;

        // TODO: Sort string[], Z->A      //cao, bu hui le...
        String[] abc = new String[]{"c", "b", "a"};
        Arrays.sort(abc);
        for(String sss: abc){System.out.println(sss);}
        Arrays.sort(abc, ((o1, o2) -> {return o2.compareTo(o1);}));
        Arrays.sort(abc, (Comparator.reverseOrder()));
        for(String sss: abc){System.out.println(sss);}

        // TODO: Append string and stringbuilder
        String s11 = "abc";
//        s11.append()

        // TODO: Split a String using: white space, new line, tab, etc. "."
        // todo: 1119 has better example.
        StringBuilder sb = new StringBuilder();
        sb.append("0\n1 2\t3.4");
        String s8 = sb.toString();
        String[] s10= new String[5];
        String[] s9 = s8.split("\n");   s10[0] = s9[0];
        s9 = s9[1].split("\\s");        s10[1] = s9[0];
        s9 = s9[1].split("\t");         s10[2] = s9[0];
//        s9 = s9[1].split("\\.");        s10[3] = s9[0]; s10[4]=s9[1];

        // TODO: How do you assign value to char
        char ccccc = 'c';

        // TODO: If assign some value to char, will it print the value?
        // 1213: no, it will be the ascii mark of that value.

        // TODO: What is char == int
        // 1213 i think they compare the value. todo: right.
        int i4 = 48;
        char c4 = (char)i4;
        System.out.println(i4==c4);

        // TODO: What is "a".compareTo("A")
        // 1213: negative.
        System.out.println("a".compareTo("A"));

        // TODO: What is "cc".compareTo("ba")
        // 1213: only the first character

        // TODO: Turn char a = 'a' to upper case
        char a = 'a'; a = Character.toUpperCase(a);

        // TODO: Declare an array, initialize anonymously 1119 Really work?
        int[] il = new int[] {1,2,3}; // 1213 I think this is anonymous declaration

        // TODO: Sort an array. What is the compareTo, and how to change it? 1119 remember natural order!
        // refer to above.

        // 1213: total time: 1h.
    }
}

