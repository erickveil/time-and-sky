import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created with IntelliJ IDEA.
 * User: alienpriest
 * Date: 10/21/13
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Star {


    //
    /**
     * This needs to be called from inside the JPanel's paintComponent method
    // in order to have access to the Graphics object it gets passed. Since
    // that wasn't explicitly called, we can't even return the Graphics2D
    // object to use here.
    // However, we need to declare the Star object in a place we can get
    // access to it, so that we can manipulate it with code.
     *
     * @param g2d Graphics2D passed to the paintComponent method of a JPanel
     * @param w The actual width the star will be drawn at
     * @param h he Actual height
     */
    public void draw(Graphics2D g2d, int w, int h){

        g2d.setColor(Color.WHITE);
        g2d.fillOval(5,5,w/2,h/2);
    }
}
