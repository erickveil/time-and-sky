import java.util.Random;

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

    public String name="";

    // rise over run: y/x
    public double slope=0;
    // Degrees x per hour: x/h
    public int speed=0;

    public Coordinate loc=new Coordinate();
    public Coordinate starting_loc=new Coordinate();

    public HeavenlyBody(String body_name, Coordinate start, int body_speed, double body_slope){
        name=body_name;
        speed=body_speed;
        slope=body_slope;
        starting_loc=start;
    }

    /**
     * Generates a body with random starting stats
     * @param body_name string name of the body
     * @param generator Random The seeded RNG
     */
    public HeavenlyBody(String body_name, Random generator){
        name=body_name;
        speed=generator.nextInt(10)+1;
        slope=generator.nextDouble();
        starting_loc=new Coordinate(generator);
    }

    /**
     * Given the time of day, calculates the position of a straight line
     * traveling HeavenlyBody
     * @param hour The current hour of the day
     * @return Position coordinates
     */
    public Coordinate getPosition(int hour){

        Coordinate position=new Coordinate();

        // EW movement is 18 degrees every hour.
        int x = (hour*speed);
        x=wrap360(x)+starting_loc.x;

        int y=(int)(x*slope)+starting_loc.y;
        y=wrap360(y);

        position.x=x;
        position.y=y;

        return position;
    }

    public void setPosition(int hour){
        loc=this.getPosition(hour);
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
