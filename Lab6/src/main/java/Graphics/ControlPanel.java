//Hamza Eduard-Mihail, 2A4
package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    JFileChooser fileChooser = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init()
    {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }

    private void save(ActionEvent e)
    {
        fileChooser.showSaveDialog(null);
        try
        {
            ImageIO.write(frame.drawingPanel.image, "PNG", new File(fileChooser.getSelectedFile().getAbsolutePath() + ".png"));
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    private void load(ActionEvent e)
    {
        fileChooser.showOpenDialog(null);
        try
        {
            frame.drawingPanel.image = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
            frame.drawingPanel.repaint();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private void reset(ActionEvent e)
    {
        frame.controller.reset();
    }

    private void exit(ActionEvent e)
    {
        frame.dispose();
    }
}
