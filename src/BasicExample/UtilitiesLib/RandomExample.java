package BasicExample.UtilitiesLib;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args){
        // boolean, byte, float, double, int, long or Gaussian value
        Random r = new Random();
        // To get a random integer between 0 to 9:  [ , )
        r.nextInt(10);

    }
}
