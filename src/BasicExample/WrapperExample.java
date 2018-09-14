package BasicExample;

public class WrapperExample {
    public static void main(String[] args) {
        Integer wrapperX = new Integer(5);  	  //Create a wrapper integer and store 5 in it
        Integer wrapperY = 10;			  //Auto-boxing
        Integer wrapperZ = wrapperX + wrapperY;  //Auto-unboxing and then auto-boxing
        System.out.println(wrapperZ.toString()); //converting Integer to String for printing
        System.out.println(wrapperZ);		 //Sysout automatically invokes toString() method
    }
}
