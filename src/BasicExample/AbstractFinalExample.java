package BasicExample;

public class AbstractFinalExample {
    public static void main(String [] arg){
        AbClass.aa();
    }
}


abstract class AbClass{
    short a = 1;
    abstract void abc();
    static void aa(){
        System.out.println("Suprise!?!?");
    };
//    abstract static void bb();
    public static void main(String[] arg){

    }
}

//class IWanttoHaveAbstractMethod{
//    abstract void someMethod(){
//
//    }
//}