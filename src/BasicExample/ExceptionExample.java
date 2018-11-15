package BasicExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args){
        System.out.println("Enter:");
        int n = validIntInput();
        System.out.println("Great!");
    }

    private static void checkedException() throws Exception{
        // unhandled exception!
        throw new Exception();
    }

    private static void uncheckedException(){
        // ide doesn't care!!
        throw new RuntimeException();
    }

//    private static void

    private static int validIntInput(){
        Scanner input;
        int n;
        while(true){
            try{
                input = new Scanner(System.in);
                n = input.nextInt();
                break;
            }
            catch(InputMismatchException ime){
                System.out.println("Invalid input, reenter:");
            }
            catch(Exception e){
                System.out.println("How did you created other exception out of this??");
            }
        }
        input.close();
        return n;
    }

}

class MyException extends Exception{
    MyException(){
        System.out.println("This is my exception!");
    }
}
