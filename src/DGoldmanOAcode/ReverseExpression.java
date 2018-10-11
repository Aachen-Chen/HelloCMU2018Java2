package GoldmanSachesOA;

public class ReverseExpression {
    public static String reverseExpression(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb = sb.reverse();

        String reverse = sb.toString();
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = i + 1;
        while (i < reverse.length()) {
            while (j < reverse.length()) {
                if (!isSymbol(reverse, j) ||
                        (j == reverse.length() - 1 && isSymbol(reverse, j)) ||
                        (isSymbol(reverse, j) && j + 1 < reverse.length() && isSymbol(reverse, j + 1))) {
                    j++;
                } else {
                    break;
                }
            }
            StringBuilder num = new StringBuilder();
            num.append(reverse.substring(i, j));
            num.reverse();
            result.append(num);
            if (j < reverse.length()) {
                result.append(reverse.charAt(j));
            }
            i = j + 1;
            j = i + 1;
        }

        return result.toString();

    }

    private static boolean isSymbol(String s, int index) {
        if (s.charAt(index) == '*' || s.charAt(index) == '+' || s.charAt(index) == '-'|| s.charAt(index) == '/') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String equation1 = "12*2.4+-9.6--23.89";
        String equation2 = "-12*2.4+-9.6--23.89";
        System.out.println(reverseExpression(equation1));
        System.out.println(reverseExpression(equation2));
    }
}
