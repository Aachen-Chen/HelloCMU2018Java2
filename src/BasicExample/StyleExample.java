package BasicExample;
import java.util.Random;

public class StyleExample {
    public static void main(String[] args){
        SwitchExample.noBreak("1");
        SwitchExample.noBreak("5");
        SwitchExample.noBreak("7");

        SwitchExample.firstDefault("1");
        SwitchExample.firstDefault("5");
        SwitchExample.firstDefault("7");
    }
}

class FormatPrintExample{
    public static void main(String[] args) {
        Random r = new Random();
        for(int i=1; i<5; i++){
            System.out.printf("%d: %d%n", i, r.nextInt(10));
        }
    }
}

class SwitchExample{
    static void noBreak(String x){
        System.out.println("----- noBreak("+ x +") -----");
        switch(x){
            case "1":
                System.out.println("1");
            case "2":
                System.out.println("2");
            case "3":
                System.out.println("3");
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
            default:
                System.out.println("End");
        }
    }

    static void firstDefault(String x){
        System.out.println("----- firstDefault("+ x +") -----");
        switch(x){
            default:
                System.out.println("End");
            case "1":
                System.out.println("1");
            case "2":
                System.out.println("2");
            case "3":
                System.out.println("3");
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
        }
    }
}

