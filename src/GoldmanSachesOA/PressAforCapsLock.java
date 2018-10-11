package GoldmanSachesOA;

public class PressAforCapsLock {
    public static String CapsLock(String input) {
        int caps = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == 'a' || c == 'A') {
                caps++;
                continue;
            } else if (caps % 2 == 0) {
                sb.append(c);
            } else {
                sb.append(reverse(c));
            }
        }
        return sb.toString();
    }

    private static char reverse(char c) {
        if(c >= 'b' && c <= 'z') {
            return Character.toUpperCase(c);
        } else if(c >= 'B' && c <= 'Z') {
            return Character.toLowerCase(c);
        } else {
            return c;
        }
    }

    public static void main(String[] argv) {
        String input1 = "My keyboard is broken";
        String input2 = "'Baa, Baa!' said the sheep";
        System.out.println(CapsLock(input1));
        System.out.println(CapsLock(input2));
    }
}
