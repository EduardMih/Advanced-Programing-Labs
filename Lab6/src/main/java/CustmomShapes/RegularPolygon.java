//Hamza Eduard-Mihail, 2A4
package CustmomShapes;

import java.awt.*;

public class RegularPolygon extends Polygon {
    public RegularPolygon(int x0, int y0, int radius, int sides)
    {
        double alpha = 2 * Math.PI;
        double x, y;
        for(int i = 0; i < sides; i++)
        {
            x = x0 + radius + Math.cos(alpha * i);
            y = y0 + radius + Math.sin(alpha * i);
            this.addPoint((int) (x), (int) (y));
        }

    }
}
