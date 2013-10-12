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

    public static float slope=0;
    public static int speed=15;


    public static Coordinate getPosition(int hour){

        Coordinate position=new Coordinate();

        // EW movement is 18 degrees every hour.
        int x = (hour*Moon.speed);
        x=wrap360(x);

        int y=x*(int)Moon.slope;

        position.x=x;
        position.y=y;

        return position;
    }

    /**
     * Max value is 360, and if that is exceeded, wrap around to 0.
     * Think of movement around the circumference of a circle.
     * @param position int The current position, which might have become negative
     * @return int the new position from 0 to 360
     */
    public static int wrap360(int position){
        if(position<0)
        {
            position=360+position;
        }
        else if (position>359)
        {
            position=position-360;
        }
        return position;
    }

}
