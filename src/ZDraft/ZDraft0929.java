package ZDraft;

import java.util.Scanner;

public class ZDraft0929 {

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

class Example{

    Example(int i){num = i;}
    int num;

    static void run(){
        // Can create obj
        Example e = new Example(1);
        // Can use obj method
        e.methods();
        // Can read obj's field
        System.out.println(e.num);
        // Can change obj's field
        e.num = 2;
        // But cannot use this.
//        this.methods();
    }

    void methods(){
        System.out.println("Member"+num +"'s method!");
    }
}

class Draft1007 {

}
