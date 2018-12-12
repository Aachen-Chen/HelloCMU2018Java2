package CLeetCode.GoldmanSachesOA;

import java.util.ArrayList;
import java.util.List;

public class CommentRemover {
    public static String commentRemover(List<String> inputs) {
        if (inputs == null) return null;

        StringBuilder result = new StringBuilder();
        boolean blocked = false;
        StringBuilder blockcomment = new StringBuilder();

        ///////
        for (String line: inputs) {
            for (int i = 0; i < line.length(); i++) {
                if (!blocked) {
                    if (line.charAt(i) == 47 && i!=line.length()-1 && line.charAt(i+1)==47) {
                        result.append(" ");
                        break;
                    }
                    else if (line.charAt(i)==47 && i!=line.length()-1 && line.charAt(i+1)==42) {
                        blockcomment.append(line.charAt(i));
                        blocked = true;
                    }
                    else result.append(line.charAt(i));
                }
                else {
                    if (line.charAt(i)==42 && i!=line.length()-1 && line.charAt(i+1)==47) {
                        result.append("\n");
                        blockcomment.setLength(0);
                        blocked = false;
                        i++;
                    }
                    else {
                        blockcomment.append(line.charAt(i));
                        if (i == line.length() - 1) {
                            blockcomment.append("\n");
                        }
                    }
                }
            }

        }
        if(blockcomment.length()>0) result.append(blockcomment.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "a/*bc";
        String s2 = "//de";
        String s3 = "de*/";
        List<String> inputs = new ArrayList<>();
        inputs.add(s1);
        inputs.add(s2);
        System.out.println(commentRemover(inputs));
    }
}
