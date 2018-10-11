package GoldmanSachesOA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheCoderFriends {
    public static String winner(String erica, String bob) {
        Map<Character, Integer> scores = new HashMap<>();
        scores.put('S', 0);
        scores.put('E', 1);
        scores.put('M', 3);
        scores.put('H', 5);

        int ericaScore = 0;
        int ericaHard = 0;
        int ericaMedium = 0;
        for (char c: erica.toCharArray()) {
            ericaScore += scores.get(c);
            if (c == 'H') {
                ericaHard += 1;
            } else if (c == 'M') {
                ericaMedium += 1;
            }
        }

        int bobScore = 0;
        int bobHard = 0;
        int bobMedium = 0;
        for (char c: bob.toCharArray()) {
            bobScore += scores.get(c);
            if (c == 'H') {
                bobHard += 1;
            } else if (c == 'M') {
                bobMedium += 1;
            }
        }

        if (ericaScore > bobScore) {
            return "Erica";
        } else if (ericaScore < bobScore) {
            return "Bob";
        } else if (ericaHard > bobHard) {
            return "Erica";
        } else if (ericaHard < bobHard) {
            return "Bob";
        } else if (ericaMedium > bobMedium) {
            return "Erica";
        } else if (ericaMedium < bobMedium) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        String erica = "EHH";
        String bob = "EME";
        System.out.println(winner(erica, bob));
    }

}
