//Hamza eduard-Mihail, 2A4
package Graphics;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sideLabel;
    JSpinner sideField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init()
    {
        sideLabel = new JLabel("Number of sides:");
        sideField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sideField.setValue(6);
        colorCombo = new JComboBox(new String[]{"Random", "Black"});

        add(sideLabel);
        add(sideField);
        add(colorCombo);
    }


}
