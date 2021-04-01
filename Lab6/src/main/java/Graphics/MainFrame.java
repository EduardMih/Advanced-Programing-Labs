//Hamza Eduard-Mihail, 2A4
package Graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;
    ShapeSelectPanel shapeSelectPanel;
    Controller controller;
    FreeDrawingAssist assist;
    public MainFrame()
    {
        super("My Drawing Application");
        init();
        controller = new Controller(this);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        assist = new FreeDrawingAssist(this);
        shapeSelectPanel = new ShapeSelectPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);
        controller = new Controller(this);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(shapeSelectPanel, BorderLayout.EAST);
        add(drawingPanel, BorderLayout.CENTER);
        pack();

    }

}
