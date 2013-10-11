/**
 * Created with IntelliJ IDEA.
 * User: alienpriest
 * Date: 10/11/13
 * Time: 3:17 PM
 *
 * The sun starts its day at 0 degrees in the east at about 8:00 am. It sets
 * in the west at 180 degrees at about 8:00 pm.
 *
 * It is the simplest heavenly body, with no indication of its position on
 * the parallels.
 */
public class Sun {

    /**
     * The Sun's position is dictated by the time of day (rather than other
     * way around)
     * @param hour Pass the current time of day
     * @return returns the position in degrees. 0 deg is the east horizon.
     */
    public static int getPosition(int hour){
        int deg = (hour*15)-120;
        if(deg<0)
        {
            deg=360+deg;
        }
        return deg;
    }
}
