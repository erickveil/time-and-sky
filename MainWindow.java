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
        final Star star_test=new Star();
        JPanel test= new JPanel(){
            @Override
            protected void paintComponent(Graphics grph) {
                super.paintComponent(grph);
                Graphics2D g2d = (Graphics2D)grph;
                g2d.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                star_test.draw(g2d,getWidth(),getHeight());
            }

            @Override
            public Dimension getPreferredSize(){
                return new Dimension(300,300);
            }
        };

        frame.add(test);

        frame.setVisible(true);
    }

}

