package CLeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

// At last one solution cannot pass. Don't know why.

public class WorkSchedule_VisaOA {

    public static void main(String[] args){
        String[] result = findSchedules(24, 4, "08??840");
        for(String s: result){
            System.out.println(s);
        }
    }

    public static String[] findSchedules(int work_hours, int day_hours, String pattern){
        // find position of question marks
        char[] patternChar = pattern.toCharArray();
        List<Integer> position = new ArrayList<>();
        for(int i=0; i<patternChar.length; i++){
            if(patternChar[i]=='?') {
                position.add(i);
            }
            else{
                work_hours -= (patternChar[i] - '0');
            }
        }

        // find possible range of hours in a day
        int[] pos = new int[position.size()];
//        char[] test = new char[pos.size()];
        for(int i=0; i<position.size(); i++){
            pos[i] = position.get(i);
//            test[i] = (char)(pos.get(i)+'0');
        }

//        return new String[]{new String(test)};

        List<List<Integer>> temp = iterate(pos, work_hours, day_hours, 0);
//        char[] test = new char[temp.get(0).size()];
//        for(int i=0; i<temp.get(0).size(); i++){ test[i] = (char)(temp.get(0).get(i)-'0'); }
//        return new String[]{new String(test)};
        String[] result = new String[temp.size()];
        // for each solution in temp
        System.out.println(temp.size() + " " + temp.get(0).size());
        for(int i=0; i<temp.size(); i++){
            // replace each ? with temp's number
            for(int j=0; j<temp.get(i).size(); j++){
                 patternChar[pos[j]] = (char)(temp.get(i).get(j)+'0');
//                 System.out.println(temp.get(i).get(j).intValue());
            }
            // then add this new pattern to result
            result[i] = new String(patternChar);
        }

//        Collections.sort(result);
        return result;
    }

    private static List<List<Integer>> iterate(int[] pos, int total, int daily, int index){
        List<List<Integer>> result = new ArrayList<>();

        // daily range
        int l=0, h=daily;
        if(total<daily){ h = total;}
        if(daily*(pos.length-index-1)<total){ l = total - daily*(pos.length-index-1); }

        // base case
        if(index == pos.length-1) {
            for(int i= l; i<=h; i++){
                System.out.println("i: " + i);
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                result.add(temp);
            }
            return result;
        }

        // for a day,
//        for(int i=index; i<pos.length; i++){
            // in its range
            // for current day, in its range
            for(int j=l; j<=h; j++){
                // find out possible solution of the rest of the day (index+1), given today's work (total-j)
                System.out.println("j: " + j);
                List<List<Integer>> temp = iterate(pos, total-j, daily, index+1);
                // append today's work to each sollution
                for(List<Integer> r: temp){
                    for(Integer c: r){
                        System.out.println("return: " + c);
                    }
                }
                for(List<Integer> r: temp){
//                    int k=0; k<result.size(); k++
                    r.add(j);
                    // append this solution to total result
                    result.add(r);
                }
            }
//        }

        // return the fucking result.
        return result;
    }

}
