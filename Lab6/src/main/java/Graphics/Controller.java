package Graphics;

import CustmomShapes.NodeShape;
import CustmomShapes.RegularPolygon;

import java.awt.*;
import java.util.Objects;

public class Controller {
    final MainFrame frame;
    Shape currentShape;
    Color currentColor;

    public Controller(MainFrame frame) {
        this.frame = frame;
    }

    public Shape getShape(int x, int y, int dim)
    {
        generateColor();
        if(frame.shapeSelectPanel.shapeList.getSelectedIndex() == 0)
            currentShape = new RegularPolygon(x, y, dim + 10, (int) (frame.configPanel.sideField.getValue()), currentColor);

        else

            currentShape = new NodeShape(x, y,(int) (frame.configPanel.sideField.getValue()) ,currentColor);

        return currentShape;

    }

    public void generateColor()
    {
        if(Objects.equals((String) (frame.configPanel.colorCombo.getSelectedItem()), "Black"))

            currentColor = Color.BLACK;

        else

            currentColor = new Color((float) (Math.random()), (float) (Math.random()), (float) (Math.random()));

    }

    public Color getCurrentColor()
    {

        return currentColor;

    }

    public int getDrawingType()
    {
        if(frame.shapeSelectPanel.shapeList.getSelectedIndex() == 2)

            return 1;

        return 0;
    }

    public void reDrawConfigPanel()
    {
        frame.remove(frame.configPanel);
        frame.configPanel = new ConfigPanel(frame);
        frame.add(frame.configPanel, BorderLayout.NORTH);
        frame.pack();
    }

    public void reset()
    {
        frame.remove(frame.drawingPanel);
        frame.drawingPanel = new DrawingPanel(frame);
        frame.add(frame.drawingPanel, BorderLayout.CENTER);
        frame.pack();
    }
}
