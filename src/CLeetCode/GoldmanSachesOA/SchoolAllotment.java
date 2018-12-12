package CLeetCode.GoldmanSachesOA;


import BasicExample.A_ExampleList.*;
import java.util.*;
import java.util.TreeMap;


public class SchoolAllotment implements LambdaExample, MapExample.Tree {
    public static List<Integer> allocateSchools(List<Integer> schoolSeatsArray,
                                                List<Integer> studentScoreArray,
                                                List<List<Integer>> studentSchoolPreferencesArray) {

        Map<Integer, Integer> score2Index = new TreeMap<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < studentScoreArray.size(); i++) {
            score2Index.put(studentScoreArray.get(i), i);
        }

        int studentNoSchool = 0;
        for (Integer index: score2Index.values()) {
            List<Integer> perference = studentSchoolPreferencesArray.get(index);
            int count = 0;
            for (int p: perference) {
                if (schoolSeatsArray.get(p) > 0) {
                    schoolSeatsArray.set(p, schoolSeatsArray.get(p) - 1);
                    break;
                } else {
                    count++;
                }
            }
            if(count >= perference.size()) {
                studentNoSchool++;
            }
        }

        int seatsNoFill = 0;
        for (Integer seats: schoolSeatsArray) {
            seatsNoFill += seats;
        }

        List<Integer> result = new ArrayList<>();
        result.add(seatsNoFill);
        result.add(studentNoSchool);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> schoolSeatsArray = Arrays.asList(1,3,1,2);
        List<Integer> studentScoreArray = Arrays.asList(990,780,830,860,920);
        List<List<Integer>> studentSchoolPrefArray = new ArrayList<>();
        studentSchoolPrefArray.add(Arrays.asList(3,2,1));
        studentSchoolPrefArray.add(Arrays.asList(2,0,0));
        studentSchoolPrefArray.add(Arrays.asList(2,0,1));
        studentSchoolPrefArray.add(Arrays.asList(0,1,3));
        studentSchoolPrefArray.add(Arrays.asList(0,2,3));
        System.out.println(allocateSchools(schoolSeatsArray,studentScoreArray,studentSchoolPrefArray));
    }
}
