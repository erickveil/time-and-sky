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

    public void draw(Graphics2D g2d, int w, int h){
        g2d.setColor(Color.WHITE);
        g2d.fillOval(5,5,w/2,h/2);
    }
}
