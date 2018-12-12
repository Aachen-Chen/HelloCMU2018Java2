package CLeetCode.GoldmanSachesOA;

import java.util.ArrayList;
import java.util.List;

public class FootballWorldCup {
    public static String footballWorldCup(List<Integer> scores) {
        int maxScore = Integer.MIN_VALUE;
        int match = 0;
        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                maxScore = Math.max(maxScore, scores.get(i) + scores.get(j));
                match++;
            }
        }

        int count = 0;
        for (int i = 0; i < scores.size(); i++) {
            for (int j = i + 1; j < scores.size(); j++) {
                int score = scores.get(i) + scores.get(j);
                if (score == maxScore) {
                    count++;
                }
            }
        }

        float result = (float) count / match;
        String res = String.format("%.2f", result);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(3);
        input.add(3);
        input.add(3);
        System.out.println(footballWorldCup(input));
    }
}
