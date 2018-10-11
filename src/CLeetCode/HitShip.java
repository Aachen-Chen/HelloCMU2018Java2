package CLeetCode;

public class HitShip {
    public static void main(String[] args){
//        System.out.println(solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
//        char[] chr1 = new char[] {'a', 'b'};
//        char[] chr2 = chr1[0:1]
        String a = " 2Z";
        String [] al1 = a.trim().split("[^0-9]");
        String [] al2 = a.split("[^A-Z]");
        System.out.println(Integer.parseInt(al1[0]));
        System.out.println(al2[al2.length-1].toCharArray()[0]);
//        for (String s: al1) System.out.println(s);
//        for (String s: al2) System.out.println(s);
    }

    public static String solution(int N, String S, String T) {

        // Part 1: mapping ship position
        String[] s = S.split(",");
        String[][] ships = new String[s.length][];
        for(int i=0; i<ships.length; i++)
            ships[i] = s[i].split("\\s");
        String[] hits = T.split("\\s");

        // Part 2: count hitted and sunk ship
        int sunk = 0;
        int hitted = 0;

        for(int i=0; i<ships.length; i++){
            System.out.println("i"+i);
            for(int j=0; j<ships[0].length; j++){
                System.out.println("j"+j+" "+ships[i][j]);
//            System.out.println();
            }
        }

        for(int i=0; i<ships.length; i++){
            int up     = ships[i][0].toCharArray()[0];
            char left  = ships[i][0].toCharArray()[1];
            int down   = ships[i][1].toCharArray()[0];
            char right = ships[i][1].toCharArray()[1];
            int hp = (right-left+1)*(down-up+1);

            for(String hit: hits){
                int hitnum   = hit.toCharArray()[0];
                char hitchar = hit.toCharArray()[1];
                if(hitnum<=down && hitnum>=up
                        && hitchar<=right && hitchar>=left
                ) hp--;
            }

            if(hp==0) sunk++;
            else if (hp<ships[i].length) hitted++;
        }

        return String.valueOf(sunk).concat(",").concat(String.valueOf(hitted));

        // write your code in Java SE 8
    }
}
