package GoldmanSachesOA;


// 20181011

public class ReverseExpression {
    public static String reverseExpression(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb = sb.reverse();

        // input
        String reverse = sb.toString();
        // output
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = i + 1;
        while (i < reverse.length()) {

            // start from i, try to find a number.
            while (j < reverse.length()) {
                if (!isOperator(reverse, j)
                        // symbol at the end
                        || (j == reverse.length() - 1 && isOperator(reverse, j))
                        // two consecutive symbol
                        || (isOperator(reverse, j) && j<reverse.length()-1 && isOperator(reverse, j+1))
                )j++;
                else break;
            }

            StringBuilder num = new StringBuilder();
            // substring(i, j) is [i, j)
            num.append(reverse.substring(i, j));
            num.reverse();
            result.append(num);

            // append also the operator
            if (j < reverse.length()) result.append(reverse.charAt(j));
            i = ++j;
            j++;
        }
        return result.toString();
    }

    private static boolean isOperator(String s, int index) {
        return s.charAt(index) == 43 || s.charAt(index) == 45 || s.charAt(index) == 47 || s.charAt(index) == 42;
    }

    public static void main(String[] args) {
        String equation1 = "12*2.4+-9.6--23.89";
        String equation2 = "-12*2.4+-9.6--23.89";
        System.out.println(reverseExpression(equation1));
        System.out.println(reverseExpression(equation2));
    }
}
