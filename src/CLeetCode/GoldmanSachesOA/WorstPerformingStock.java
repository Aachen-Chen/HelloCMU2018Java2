package CLeetCode.GoldmanSachesOA;

import java.util.ArrayList;
import java.util.List;

public class WorstPerformingStock {
    public static int worstPerformingStock(List<List<Integer>> input) {
        int worstID = 0;
        int worstROR = Integer.MAX_VALUE;

        for (List<Integer> cur: input) {
            int ID = cur.get(0);
            int open = cur.get(1);
            int close = cur.get(2);
            int ROR = (close - open) / open;
            if (ROR < worstROR) {
                worstID = ID;
                worstROR = ROR;
            }
        }

        return worstID;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> stock1 = new ArrayList<>();
        stock1.add(1200);
        stock1.add(100);
        stock1.add(105);

        List<Integer> stock2 = new ArrayList<>();
        stock2.add(1400);
        stock2.add(50);
        stock2.add(55);

        input.add(stock1);
        input.add(stock2);

        System.out.println(worstPerformingStock(input));
    }
}
