package Graphics;

import CustmomShapes.NodeShape;

import java.awt.*;
import java.awt.geom.Line2D;

public class FreeDrawingAssist {
    MainFrame frame;

    public FreeDrawingAssist(MainFrame frame) {
        this.frame = frame;
    }

    public boolean recognizeLine()
    {
        double xA, xB, yA, yB, a, b, c, d;

        xA = frame.drawingPanel.temp.get(0).x;
        yA  = frame.drawingPanel.temp.get(0).y;
        xB = frame.drawingPanel.temp.get(frame.drawingPanel.temp.size() - 1).x;
        yB = frame.drawingPanel.temp.get(frame.drawingPanel.temp.size() - 1).y;

        a = 1.0 / (xA - xB);
        b = 1.0 / (yB - yA);
        c = xA / (xB - xA) - yA / (yB - yA);


        for(NodeShape node : frame.drawingPanel.temp)
        {
            d = Math.abs(a * node.x + b * node.y + c) / Math.sqrt( a * a + b * b);

            if(d > 5)
            {
                //shapeList.addAll(temp);
                //temp.clear();
                //reDraw(-1, -1);

                return false;

            }
        }

        frame.drawingPanel.shapeList.add(new Line2D.Double(xA, yA, xB, yB));
        frame.drawingPanel.temp.clear();
        frame.drawingPanel.reDraw(-1, -1);

        return true;

    }

    public boolean recognizeCircle()
    {
        double xMin, xMax, yMin, yMax, centerX, centerY, radius;

        xMax = frame.drawingPanel.temp.stream()
                .max((shape1, shape2) -> Double.compare(shape1.x, shape2.x))
                .map(shape -> shape.x).get();

        xMin = frame.drawingPanel.temp.stream()
                .min((shape1, shape2) -> Double.compare(shape1.x, shape2.x))
                .map(shape -> shape.x).get();

        yMax = frame.drawingPanel.temp.stream()
                .max((shape1, shape2) -> Double.compare(shape1.y, shape2.y))
                .map(shape -> shape.y).get();

        yMin = frame.drawingPanel.temp.stream()
                .min((shape1, shape2) -> Double.compare(shape1.y, shape2.y))
                .map(shape -> shape.y).get();


        centerX = xMin + (xMax - xMin) / 2;
        centerY = yMin + (yMax - yMin) / 2;
        radius = Math.max((xMax - xMin) / 2, (yMax - yMin) / 2);

        for(NodeShape shape : frame.drawingPanel.temp)
        {
            if(Math.sqrt(Math.pow(centerX - shape.x, 2) + Math.pow(centerY - shape.y, 2)) < radius - 10)
            {
                //shapeList.addAll(temp);
                //temp.clear();
                //reDraw(-1, -1);

                return false;

            }
        }

        frame.drawingPanel.shapeList.add(new NodeShape(centerX, centerY, Math.abs(centerX - xMax), Color.BLACK));
        frame.drawingPanel.temp.clear();
        frame.drawingPanel.reDraw(-1, -1);

        return true;

    }

    public void recognizeShapes()
    {
        if(!recognizeLine() && !recognizeCircle())
        {
            frame.drawingPanel.shapeList.addAll(frame.drawingPanel.temp);
            frame.drawingPanel.temp.clear();
            frame.drawingPanel.reDraw(-1, -1);
        }


    }
}
