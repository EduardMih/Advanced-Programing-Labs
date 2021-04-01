//Hamza Eduard-Mihail, 2A4
package Graphics;
import CustmomShapes.NodeShape;
import CustmomShapes.RegularPolygon;
import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800;
    final static int H = 600;
    BufferedImage image;
    Graphics2D graphics;
    List<Shape> shapeList = new ArrayList<>();
    List<NodeShape> temp = new ArrayList<>();
    static boolean deleteOn = false;

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
        this.addMouseListener(new MyMouseListener(frame));
        this.addMouseMotionListener(new MyMouseListener(frame));
    }

    public void drawShape(int x, int y)
    {
        int radius = (int) (Math.random() * 10);
        Shape shape = frame.controller.getShape(x, y, radius);
        Color color = frame.controller.getCurrentColor();

        graphics.setColor(color);
        graphics.draw(shape);
        shapeList.add(shape);

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

    public void reDraw(int x, int y)
    {
        shapeList.removeIf(shape -> shape.contains(x, y));
        createOffscreenImage();
        for(Shape shape : shapeList)
        {
            if(shape instanceof RegularPolygon)
                graphics.setColor(((RegularPolygon) (shape)).color);

            else

                if(shape instanceof NodeShape)
                graphics.setColor(((NodeShape)(shape)).color);

                else

                    graphics.setColor(Color.BLACK);

            graphics.draw(shape);
        }
        deleteOn = false;
    }
}
