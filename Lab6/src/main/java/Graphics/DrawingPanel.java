//Hamza Eduard-Mihail. 2A4
package Graphics;

import CustmomShapes.NodeShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800;
    final static int H = 600;
    BufferedImage image;
    Graphics2D graphics ;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage()
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init()
    {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });

    }



    private void drawShape(int x, int y)
    {
        int radius = (int) (Math.random() * 10);
        int sides = (int) frame.configPanel.sideField.getValue();
        Color color;

        if(Objects.equals((String) (frame.configPanel.colorCombo.getSelectedItem()), "Black"))
            color = Color.BLACK;

        else

            color = new Color((float) (Math.random()), (float) (Math.random()), (float) (Math.random()));


        graphics.setColor(color);
        graphics.fill(new NodeShape(x, y, sides));



        System.out.println(x);
        System.out.println(y);

    }

    @Override
    public void update(Graphics g)
    {

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this);
    }
}
