package ZDraft;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ZDraft0929 {

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
