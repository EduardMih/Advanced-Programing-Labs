//Hamza Eduard-Mihail, 2A4
package Graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel drawingPanel;
    public MainFrame()
    {
        super("My Drawing Application");
        init();
    }

    public void reset()
    {
        remove(drawingPanel);
        drawingPanel = new DrawingPanel(this);
        add(drawingPanel, BorderLayout.CENTER);
        pack();
    }

    private void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);
        pack();

    }

}
