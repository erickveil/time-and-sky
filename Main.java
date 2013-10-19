import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: alienpriest
 * Date: 10/11/13
 * Time: 2:28 PM
 *
 * Main entry point.
 */
public class Main {
    public static void main(String [] args){

        long random_seed=System.currentTimeMillis();
        Random generator=new Random(random_seed);

        DayLoop allTime = new DayLoop();
        Sky heavens=new Sky(generator);

        allTime.runDay(heavens);

    }
}
