package CLeetCode.GoldmanSachesOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFormat {
    public static String csvFormatter(List<String> inputs) {
        if (inputs == null) {
            return null;
        }

        String[] firstRow = inputs.get(0).split(",");
        int column = firstRow.length;
        int[] maxColLen = new int[column];

        Arrays.fill(maxColLen, Integer.MIN_VALUE);

        for (String line: inputs) {
            String[] row = line.split(",");
            for (int i = 0; i < column; i++) {
                maxColLen[i] = Math.max(maxColLen[i], row[i].length());
            }
        }

        StringBuilder result = new StringBuilder();
        for (String line: inputs) {
            StringBuilder sb = new StringBuilder();
            String[] row = line.split(",");
            for (int i = 0; i < column; i++) {
                int spaceLen = maxColLen[i] - row[i].length();
                for (int j = 0; j < spaceLen; j++) {
                    sb.append(" ");
                }
                sb.append(row[i]);
                if (i != column - 1) {
                    sb.append(",");
                    sb.append(" ");
                } else {
                    sb.append("\n");
                }
            }
            result.append(sb);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        String s1 = "Name,Course,Percent Grade,Letter Grade";
        String s2 = "Mark Johnson,Biology,75,B";
        String s3 = "Susan Smith,Mathematics,84,B+";
        String s4 = "Bob Doe,English,80,B+";
        String s5 = "Emma Knight,Physics,91,A";
        String s6 = "Jenny Lee,English,95,A+";
        String s7 = "Mark Johnson,Mathematics,100,A+";
        inputs.add(s1);
        inputs.add(s2);
        inputs.add(s3);
        inputs.add(s4);
        inputs.add(s5);
        inputs.add(s6);
        inputs.add(s7);
        System.out.println(csvFormatter(inputs));
    }
}
