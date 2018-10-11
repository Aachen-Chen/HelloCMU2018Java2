package GoldmanSachesOA;

import java.util.HashMap;
import java.util.Map;

public class ThePerfectTeam {
    public static int perfectTeam(String skills) {
        if (skills == null || skills.length() < 5) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skills.length(); i++) {
            char c = skills.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        if (map.size() < 5) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (Character ch: map.keySet()) {
            min = Math.min(min, map.get(ch));
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(perfectTeam("pcmpp"));
    }
}
