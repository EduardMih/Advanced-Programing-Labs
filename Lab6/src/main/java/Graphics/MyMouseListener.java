package Graphics;
import CustmomShapes.NodeShape;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static Graphics.DrawingPanel.deleteOn;

public class MyMouseListener extends MouseAdapter implements MouseMotionListener {
    MainFrame frame;

    public MyMouseListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mousePressed(MouseEvent e)
    {


        if(deleteOn)
        {
            frame.drawingPanel.reDraw(e.getX(), e.getY());
            frame.drawingPanel.repaint();
        }

        else

        {
            if(frame.controller.getDrawingType() == 0)
            {
                frame.drawingPanel.drawShape(e.getX(), e.getY());
                frame.drawingPanel.repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

        if(frame.controller.getDrawingType() == 1)
        {
            frame.assist.recognizeShapes();
            frame.drawingPanel.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if(frame.controller.getDrawingType() == 1)
        {

            frame.drawingPanel.graphics.setColor(Color.BLACK);
            frame.drawingPanel.graphics.drawOval(e.getX(), e.getY(), 3, 3);
            frame.drawingPanel.temp.add(new NodeShape(e.getX(), e.getY(), 3, Color.BLACK));
            frame.drawingPanel.repaint();
        }
    }
}
