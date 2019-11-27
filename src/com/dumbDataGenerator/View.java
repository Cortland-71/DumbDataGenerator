package com.dumbDataGenerator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View {

    private GridBagConstraints c = new GridBagConstraints();
    //private String inputPath = "C:\\Users\\carrilloc.YGA\\Desktop\\DummyFolder\";
    private String outputPath = "C:\\Users\\carrilloc.YGA\\Desktop\\DummyFolder\\output.csv";

    public View() {
        JFrame frame = new JFrame("Dummy Data Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800,300));
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel());
        frame.setVisible(true);
    }

    private JPanel mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(46,46,46));
        mainPanel.add(northPanel(), BorderLayout.NORTH);
        mainPanel.add(centerPanel(), BorderLayout.CENTER);
        mainPanel.add(southPanel(), BorderLayout.SOUTH);
        return mainPanel;
    }

    //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
    private JPanel northPanel() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(null);
        northPanel.add(northInNorthPanel(), BorderLayout.NORTH);
        northPanel.add(southInNorthPanel(), BorderLayout.SOUTH);
        return northPanel;
    }

    private JPanel northInNorthPanel() {
        JPanel northInNorthPanel = new JPanel();
        northInNorthPanel.setLayout(new GridBagLayout());
        northInNorthPanel.setBackground(null);
        northInNorthPanel.add(infoLabel(), c);
        return northInNorthPanel;
    }

    private JPanel southInNorthPanel() {
        JPanel southInNorthPanel = new JPanel();
        southInNorthPanel.setLayout(new GridBagLayout());
        southInNorthPanel.setBackground(null);
        southInNorthPanel.add(includeStringsLabel(), c);
        southInNorthPanel.add(includeStringsCheckBox(), c);
        southInNorthPanel.add(includeNumbersLabel(), c);
        southInNorthPanel.add(includeNumbersCheckBox(), c);
        return southInNorthPanel;
    }

    private JLabel infoLabel() {
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20,0,5,0);
        JLabel infoLabel = new JLabel();
        infoLabel.setText(
                "This application accepts a csv file that you wish to copy into a similar file populated with dummy data.");
        setFont(infoLabel, Color.BLACK, Color.WHITE, 12);
        return infoLabel;
    }

    private JLabel includeStringsLabel() {
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20,0,5,10);
        JLabel includeStringLabel = new JLabel("Include dummy strings");
        setFont(includeStringLabel, Color.BLACK, Color.WHITE, 12);
        return includeStringLabel;
    }

    private JCheckBox includeStringsCheckBox() {
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20,0,5,20);
        JCheckBox includeStringCheckBox = new JCheckBox();
        includeStringCheckBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(includeStringCheckBox, Color.BLACK, Color.WHITE, 12);
        return includeStringCheckBox;
    }

    private JLabel includeNumbersLabel() {
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(20,20,5,10);
        JLabel includeNumbersLabel = new JLabel("Include dummy numbers");
        setFont(includeNumbersLabel, Color.BLACK, Color.WHITE, 12);
        return includeNumbersLabel;
    }

    private JCheckBox includeNumbersCheckBox() {
        c.gridx = 3;
        c.gridy = 0;
        c.insets = new Insets(20,0,5,0);
        JCheckBox includeNumbersCheckBox = new JCheckBox();
        includeNumbersCheckBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(includeNumbersCheckBox, Color.BLACK, Color.WHITE, 12);
        return includeNumbersCheckBox;
    }

    //Center panel \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
    private JPanel centerPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(null);
        centerPanel.add(orginalLabel(), c);
        centerPanel.add(originalField(), c);
        centerPanel.add(dummyLabel(), c);
        centerPanel.add(dummyField(), c);
        return centerPanel;
    }

    private JLabel orginalLabel() {
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(0,0,25,0);
        JLabel originalLabel = new JLabel("Original CSV path: ");
        setFont(originalLabel, Color.BLACK, Color.GRAY, 12);
        return originalLabel;
    }

    private JTextField originalField;
    private JTextField originalField() {
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,0,25,0);
        originalField = new JTextField();
        originalField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        originalField.setPreferredSize(new Dimension(300,20));
        originalField.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        originalField.setCaretColor(Color.ORANGE);
        //originalField.setText(Driver.testPath);
        originalField.setText(Driver.slotsPath);
        setFont(originalField, Color.BLACK, Color.ORANGE, 15);
        return originalField;
    }
    public String getOriginalFieldText() {
    	return originalField.getText();
    }
    

    private JLabel dummyLabel() {
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        JLabel dummyLabel = new JLabel("Output dummy CSV path: ");
        setFont(dummyLabel, Color.BLACK, Color.GRAY, 12);
        return dummyLabel;
    }

    private JTextField dummyField;
    private JTextField dummyField() {
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0,0,0,0);
        dummyField = new JTextField();
        dummyField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        dummyField.setPreferredSize(new Dimension(300,20));
        dummyField.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        dummyField.setCaretColor(Color.ORANGE);
        dummyField.setText(outputPath);
        setFont(dummyField, Color.BLACK, Color.ORANGE, 15);
        return dummyField;
    }
    public String getDummyFieldText() {
    	return dummyField.getText();
    }

    //South panel \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
    private JPanel southPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridBagLayout());
        southPanel.setBackground(null);
        southPanel.add(generateButton(), c);
        return southPanel;
    }

    private JButton generateButton;
    private JButton generateButton() {
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,0,30,0);
        generateButton = new JButton("Generate");
        generateButton.setPreferredSize(new Dimension(150,30));
        setFont(generateButton, new Color(0,153,153), Color.WHITE, 17);
        generateButton.setFocusPainted(false);
        return generateButton;
    }
    public void generateButtonListener(ActionListener l) {
    	generateButton.addActionListener(l);
    }
    

    private void setFont(JComponent comp, Color bg, Color fg, int size) {
        comp.setFont(new Font("Consolas", 0, size));
        comp.setForeground(fg);
        comp.setBackground(bg);
    }
}

