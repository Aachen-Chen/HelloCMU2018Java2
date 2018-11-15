package ZDraft;

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
