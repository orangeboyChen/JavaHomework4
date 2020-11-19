package com.nowcent.T14_11;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * @author orangeboy
 * @version 1.0
 * @date 2020/11/19 21:37
 */
public class Printer {
    private JPanel panel1;
    private JButton okButton;
    private JButton cancelButton;
    private JButton setupButton;
    private JButton helpButton;
    private JList list1;
    private JRadioButton selectionRadioButton;
    private JRadioButton allRadioButton;
    private JRadioButton appletRadioButton;
    private JList list2;
    private JCheckBox imageCheckBox;
    private JCheckBox textCheckBox;
    private JCheckBox codeCheckBox;
    private JList list3;
    private JComboBox comboBox1;
    private JCheckBox printToFileCheckBox;

    public Printer(){
        comboBox1.addItem("High");
        allRadioButton.doClick();
    }

    public void show() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        JFrame frame = new JFrame("Printer");

        frame.setContentPane(new Printer().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
