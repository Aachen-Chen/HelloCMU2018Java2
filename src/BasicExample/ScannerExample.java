package BasicExample;

import java.util.Scanner;

class ScannerExample{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int    m = s.nextInt();
//        String n = s.nextLine();
//        String o = s.next();
        String n = s.next();
        String o = s.nextLine();
        String p = s.nextLine();
        System.out.println("nextInt |"+m+"|");
        System.out.println("next    |"+n+"|");
        System.out.println("nextLine|"+o+"|");
        System.out.println("nextLine|"+p+"|");
    }
}
