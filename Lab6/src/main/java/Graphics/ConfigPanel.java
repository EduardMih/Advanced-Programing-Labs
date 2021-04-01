//Hamza eduard-Mihail, 2A4
package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sideLabel;
    JSpinner sideField;
    JComboBox colorCombo;
    JButton deleteBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init()
    {
        sideLabel = new JLabel();
        sideField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sideField.setValue(6);
        colorCombo = new JComboBox(new String[]{"Random", "Black"});

        deleteBtn = new JButton("Delete");

        if(frame.shapeSelectPanel.shapeList.getSelectedIndex() == 0)
            sideLabel.setText("Number of sides");

        else

            sideLabel.setText("Radius");


        add(sideLabel);
        add(sideField);
        add(colorCombo);
        add(deleteBtn);

        deleteBtn.addActionListener(this::delete);


    }

    private void delete(ActionEvent e)
    {
        DrawingPanel.deleteOn = true;

    }

}
