import java.util.Random;

/**
 * PACKAGE_NAME
 * User: eveil
 * Date: 10/12/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Coordinate(){
        this.x=0;
        this.y=0;
    }

    public Coordinate(Random generator){
        this.x=generator.nextInt(360);
        this.y=generator.nextInt(360);
    }
}
