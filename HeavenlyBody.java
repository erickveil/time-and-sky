/**
 * HeavenlyBody
 * User: eveil
 * Date: 10/12/13
 * Time: 1:22 PM
 *
 * The template/parent of all heavenly bodies and how they move across the sky.
 * Children should define slope and speed.
 */
public class HeavenlyBody {

    // rise over run: y/x
    public static float slope=0;
    // Degrees x per hour: x/h
    public static int speed=0;


    /**
     * Given the time of day, calculates the position of a straight line
     * traveling HeavenlyBody
     * @param hour The current hour of the day
     * @return Position coordinates
     * TODO: Learn about Java inheritance. How to use the child's static properties instead of the Parent.
     */
    public static Coordinate getPosition(int hour){

        Coordinate position=new Coordinate();

        // EW movement is 18 degrees every hour.
        int x = (hour*speed);
        x=wrap360(x);

        int y=x*(int)slope;

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