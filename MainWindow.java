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
        // It is defined in the documentation that local classes (Classes
        // defined inside a method, such as this is,
        // can only use outer class's variables if they are final. In SE 8,
        // they will be able to use variables that are effectively final by
        // not redefining them.
        final Star star_test=new Star();

        // test is an instance of an inner class, type JPanel,
        // with two methods that override the default JPanel.
        // Why not create a new child class that inherits from JPanel?
        // It could be that, because we declare the Star object out here,
        // where we can manipulate it, yet call it's draw method in there
        // where we have no access, that this might be the most accessible
        // place for it. Is there a data arrangement that avoids the use of
        // the inner class?
        // According to the documentation, this is considered an anonymous
        // class. Their purpose is to be used "If you only need to use a local
        // class once."
        //
        // There appears to be no other benefit, other than the immediate
        // access to the objects declared outside of it. I think it might be
        // my organizational preference to create an extended version of the
        // class to handle the graphics, unless in doing so the complexity of
        // the logic outweighs the complexity of the structure.
        //
        // Update: According to "the Rules," One should not subclass
        // AWT/Swing/X components except to hack and workaround. So it would
        // seem to me, at the very least, to implement JPanel as an anonymous
        // class in order to adhere to best practices. I've found that
        // avoiding such practices has me refactoring code in the future as I
        // say to myself, "OOOh, that's why." I am going to assume that there
        // is a good reason for this.
        //
        // Further reading on "Subclassing Swing Components" google search
        // confirms that this is the approach I want to implement. Sigh.

        JPanel test= new JPanel(){

            // When this block is commented out, the default paintComponent
            // fails to draw the ellipse.
            // Why?
            // Because Graphics2D methods are used to do the drawing,
            // Why not use the Graphics methods?
            // Because they do not exist. Graphics is a general class,
            // Graphics2D extends it, giving greater control.

            // Makes the compiler check that you are overriding correctly,
            // and makes the override in code more obvious to the reader.
            @Override

            // It is my guess that paintComponent is called by the VM when it
            // is time to draw the component, since I never explicitly call
            // it.
            // Is this true?
            // Yes. The GUI handles all painting. Call repaint() if you want
            // to explicitly handle the drawing.
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
                // The parameters are setting,value. They make use of the
                // system's graphics engine. Setting them or not is often an
                // decision of speed vs quality.
                g2d.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                // call the draw method we defined in our custom Star Class's
                // object. We pass it the Graphics object,
                // which was given to us by the VM call.
                // Where do we getWidth and getHeight from?
                // Since these are members, and there is no object used,
                // I am guessing that they are getting W and H of the JPanel.
                // Whatever we set the panel to, this object will fit it.

                //star_test.draw(g2d,getWidth(),getHeight());

                // Setting the w,h values to explicit numbers seems to create
                // a fixed size ellipse. Unlike getWidth, etc,
                // The circle does not stretch with the window size.
                star_test.draw(g2d,100,100);
            }

            // When this block is commented out, the default getPreferredSize
            // still allows the ellipse to be drawn.
            // Why override it?
            @Override
            public Dimension getPreferredSize(){
                // Altering these values doesn't appear to alter the size of
                // the ellipse. What is this Dimension for?
                return new Dimension(3000,3000);
            }
        };

        // Here the JPanel is actually added to the frame.
        // Why does it block out the black background of the frame?
        // My theory is that this is where the paintComponent gets invoked
        // by the VM.
        frame.add(test);

        frame.setVisible(true);
    }

}

