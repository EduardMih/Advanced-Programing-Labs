//Hamza Eduard-Mihail, 2A4
package CustmomShapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NodeShape extends Ellipse2D.Double {
    public Color color;
    public NodeShape(double x0, double y0, double radius, Color color)
    {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
        this.color = color;
    }
}
