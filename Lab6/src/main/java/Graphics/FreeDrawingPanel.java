package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class FreeDrawingPanel extends JPanel{
    final MainFrame frame;
    Graphics2D graphics;

    public FreeDrawingPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init()
    {
        graphics = (Graphics2D) (this.graphics.create());
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                System.out.println(e.getX());
                System.out.println(e.getY());
                graphics.setColor(Color.BLACK);
                graphics.drawOval(e.getX(), e.getY(), 20, 20);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });
    }

    private void reDraw()
    {

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

    }
}
