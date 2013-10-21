import java.awt.*;
import javax.swing.*;

/**
 *
 */
public class MainWindow {
    /**
     *
     */
    public void createAndShowGUI() {

        JFrame frame = new JFrame("A Story of Time and The Sky");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(new Dimension(800,600));

        // paint
        // TODO: Copied from SO. Step thru and understand every implementation below:

        // Instantiate a new star object with the default constructor.
        // The final keyword prevents it from being further overidden.
        // If removed, the star_test reference is called from an inner class,
        // and the compiler complains that it must be final.
        // Why?
        final Star star_test=new Star();

        // test is an instance of an inner class, type Jpannel,
        // with two methods that override the default JPannel.
        // Why not create a new child class that inherits from JPanel?
        // It could be that, because we declare the Star object out here,
        // where we can manipulate it, yet call it's draw method in there
        // where we have no access, that this might be the most acessible
        // place for it. Is there a data arrangement that avoids the use of
        // the inner class?
        JPanel test= new JPanel(){

            // When this block is commented out, the default paintComponent
            // fails to draw the ellipse.
            // Why?
            // Because Graphics2D methods are used to do the drawing,
            // Why not use the Graphics methods?
            @Override

            // It is my guess that paintComponent is called by the VM when it
            // is time to draw the component, since I never explicitly call
            // it.
            // Is this true?
            //
            // Are these methods members of any of the class's siblings?
            protected void paintComponent(Graphics grph) {

                // super refers to the original JPanel. We call the
                // original painComponent method and then add to it.
                super.paintComponent(grph);

                // here we cast the Graphics object to a Graphics2D object
                Graphics2D g2d = (Graphics2D)grph;

                // Graphics2D allows the use of the setRenderingHint method.
                // Look this method up. My guess is that we can pass any
                // number of these static constants to set rendering
                // parameters.
                // What are they all and what do they do to the image?
                g2d.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                // call the draw method we defined in our custom Star Class's
                // object. We pass it the Graphics object,
                // which was given to us by the VM call.
                // Where do we getWidth and getHeight from?

                //star_test.draw(g2d,getWidth(),getHeight());

                // Setting the w,h values to explicit numbers seems to create
                // a fixed size ellipse. Unlike getWidth, etc,
                // The circle does not stretch with the window size.
                star_test.draw(g2d,600,600);
            }

            // When this block is commented out, the default getPreferredSize
            // still allows the ellipse to be drawn.
            // Why override it?
            @Override
            public Dimension getPreferredSize(){
                // Altering these values doesn't appear to alter the size of
                // the ellipse. What is this Dimension for?
                return new Dimension(3,3);
            }
        };

        // Here the Jpanel is actually added to the frame.
        // Why does it block out the black background of the frame?
        // My theory is that this is where the paintComponent gets invoked
        // by the VM.
        frame.add(test);

        frame.setVisible(true);
    }

}

