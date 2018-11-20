package ZDraft;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ZDraft0902 {
    public static void main(String arg[]){
        System.out.println("Start working on Git!!");

    }
}

class ZDraft0913{
    public static void main(String[] args){
//        String a = "abc";
//        char[] b = a.toCharArray();
//        char c = 65;
//        b[0] = (new String(new char[] {b[0]})).toUpperCase().toCharArray()[0];
//        System.out.println(new String(b));

        String b = "1 2 3";
        String[] c = b.split("\\s");
        for(String s: c){
            System.out.println(s);
        }

    }
}



class StringSorting{
//    public static void main(String[] args){
//        String a = "abc";
//        String b = "aaa";
//        String c = "a";
//        String d = "z";
//        String e = "Z";
//        System.out.println(c.compareTo(b));
//        System.out.println(b.compareTo(a));
//        System.out.println(a.compareTo(d));
//        System.out.println(d.compareTo(e));
//        String[] abc = new String[] {a, b, c, d, e};
//        Arrays.sort(abc);
//        for(String x: abc){
//            System.out.println(x);
//        }
//
//        System.out.println(new Integer(1).compareTo(new Integer(2)));
//    }
}

class ZDraft1107{
    public static void main(String[] args){

    }
}


class ZDraft0929 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("1");
        sb.insert(0, "A");
        sb.insert(0, 1.2);
        System.out.println(sb.toString());
        String s = "1";
        System.out.println(s.charAt(0)-48);
        System.out.println();

        char c1 = '1';
        char c2 = '2';
        char c3 = (char)(c1+c2-48);
        System.out.println(c3);
        System.out.println((char)(c3+1));
        System.out.println(c3>'9');
        System.out.println((char)(c3-10));
    }
}

class Draft1028{
    public static void main(String[] args){
        Set<String> s = new HashSet<>();
        System.out.println("");
    }
}

class ChineseChar{
    private StringBuilder sb = new StringBuilder("");
    private String[] strArr;
    void Seperation(){
        Scanner input;
        input = new Scanner(System.in);
        while(input.hasNextLine()) {
            sb.append(input.nextLine());
            sb.append("\n");
        }
        if(sb.length()==0) return;
        strArr = sb.toString().split("\n");

        for(String line: strArr){

        }

    }

}


class Draft1004{
    public static void main(String[] args){
        Draft1004 d = new Draft1004();
        System.out.println(d.findGCD(12,16));
    }

    public int findGCD(int n, int d){
        if(n==0) return 1;
        if(d==0) return n;
        else findGCD(d, n%d);
        return 0;
    }
}



class Draft1007 {
    public static void main(String[]args){
//        "abc".toChar
        String abc = "abc";
        abc = abc + "d";
        System.out.printf(abc);
    }
}


