package CLeetCode;

import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

//        ZOJ3397ChangeTheMajor test1 = new ZOJ3397ChangeTheMajor();
//        System.out.println(test1.changeMajor(text));
        Main test1 = new Main();
//        test1.changeMajor("");
        System.out.println(test1.changeMajor(""));
    }

    public int changeMajor(String text){
        Scanner in = new Scanner(System.in);
        Queue<Student> candidates = new PriorityQueue<>();
        Map<Integer, Queue<Student>> majors = new HashMap<>();
        int numStudent=0;
        if(in.hasNextLine()) {
            numStudent = Integer.parseInt(in.nextLine().trim());
        };
        for(int i=0; i<3; i++){
            majors.put(i, new PriorityQueue<Student>(numStudent/3+1, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Float.compare(o2.gpa, o1.gpa);
                }
            }));
        }

        while (numStudent-->0 && in.hasNextLine() ) {
            String s = in.nextLine();
            if(s.equals("")) break;
            String[] info = s.split("\\s");
            if(info.length<3) continue;

            Student student = new Student(info);
            candidates.offer(student);
            majors.get(student.cur).offer(student);
        }

        int num=0;
        while(!candidates.isEmpty()){
            num += move(candidates.poll(), majors);
        }


        return num;
    }

    private int move(Student student, Map<Integer, Queue<Student>> majors){
        // Change: Map majors, student.cur
//        System.out.println(student.gpa+" "+student.cur+" "+student.tar);

        if(student.cur == student.tar) return 0;

        if(student.cur != 1 && student.tar != 1){
            int originTarget = student.tar;
            student.tar = 1;
            int num = move(student, majors);
            student.tar = originTarget;
            return num + move(student, majors);
        }

        int temporaryMajor = 3 - student.cur - student.tar;
        int num=0;

        while (true) {
            Student bestInCur = majors.get(student.cur).peek();
            Student bestInTar = majors.get(student.tar).peek();
            if(bestInCur==null) return 0;

            if(bestInCur==student){
                if(bestInTar==null || student.gpa > bestInTar.gpa ){
                    // move student to target
                    majors.get(student.tar).offer(majors.get(student.cur).poll());
                    student.cur = student.tar;
                    num ++;
                    return num;
                } else { // target major's student's gpa is higher
                    // move target's best student to temporary major
                    int originTarget = bestInTar.tar;
                    bestInTar.tar = temporaryMajor;
                    num += move(bestInTar, majors);
                    bestInTar.tar = originTarget;
                    bestInTar = majors.get(student.tar).peek();
                }
            } else {
                if(bestInTar!=null && bestInCur.gpa > bestInTar.gpa){
                    // if student is not the best in either major,
                    // in the two best students of two major, move the one with LOWER gpa
                    int originTarget = bestInTar.tar;
                    bestInTar.tar = temporaryMajor;
                    num += move(bestInTar, majors);
                    bestInTar.tar = originTarget;
                    bestInTar = majors.get(student.tar).peek();
                } else {
                    int originTarget = bestInCur.tar;
                    bestInCur.tar = temporaryMajor;
                    num += move(bestInCur, majors);
                    bestInCur.tar = originTarget;
                    bestInCur = majors.get(student.tar).peek();
                }
            }
        }
    }

}

class Student implements Comparable<Student>{
    int cur;
    int tar;
    float gpa;

    private static int major(String s){
        if(s.equals("Computer")) return 0;
        if(s.equals("Chinese")) return 1;
        if(s.equals("Mathematics")) return 2;
        return -1;
    }
    Student(String[] info){
        this.cur = major(info[0]);
        this.tar = major(info[1]);
        this.gpa = Float.parseFloat(info[2]);
    }

    @Override
    public int compareTo(Student o) {
        return Float.compare(this.gpa, o.gpa);
    }
}


//        if(text==null) return 0;
//                String[] texts = text.split("\\n");
//                if(texts.length==0) return 0;
//                Queue<Student> candidates = new PriorityQueue<>();
//        int initialCapacity = Math.max(1, Integer.parseInt(texts[0]) / 3);