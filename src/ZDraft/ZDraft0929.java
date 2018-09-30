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