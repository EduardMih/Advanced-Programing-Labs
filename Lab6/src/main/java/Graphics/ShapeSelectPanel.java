package Graphics;

import Grammar.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShapeSelectPanel extends JPanel {
    final MainFrame frame;
    JList shapeList;
    JLabel shapeListLabel;
    JTextArea textArea;
    JButton submitButton;

    public ShapeSelectPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        shapeList = new JList(new String[] {"<html><b>Regular Polygon</b></html>", "<html><b>Circle</b></html>", "<html><b>Free drawing mode</b><html>"});
        shapeList.setSelectedIndex(1);
        shapeList.setPreferredSize(new Dimension(150,150));
        shapeListLabel = new JLabel("<html><font color=\"red\">Select shape</font></html>");
        shapeList.setSelectedIndex(0);
        textArea = new JTextArea(10, 10);
        submitButton = new JButton("Submit");


        this.setPreferredSize(new Dimension(170, 170));
        this.setBackground(new Color(0x123456));

        add(shapeListLabel);
        add(shapeList);
        add(textArea);
        add(submitButton);

        shapeList.addListSelectionListener(this::selectShape);
        //submitButton.addActionListener(this::getCommand);
    }

    private void selectShape(ListSelectionEvent e)
    {
        frame.controller.reDrawConfigPanel();
    }

/*    private void getCommand(ActionEvent e)
    {
        MyListener grammarListener = new MyListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        myGrammarLexer lexer = new myGrammarLexer(CharStreams.fromString("draw 2.5 3.5"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        myGrammarParser parser = new myGrammarParser(tokens);




        System.out.println(textArea.getText());

    }*/

}
