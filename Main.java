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

        DayLoop allTime = new DayLoop();
        Sky heavens=new Sky();

        allTime.runDay(heavens);

    }
}
