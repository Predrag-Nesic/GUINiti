package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {
    JLabel x0Label, dXLabel;

    // These text fields are to be manipulated with, the constant listening of the Nit object is checking the values, and is
    // changing them accordingly to the run() method
    JTextField x0Text, dXText;
    Nit nit;
    public SouthPanel(Nit nit) {
        this.nit = nit;
        x0Label = new JLabel("x0");
        dXLabel = new JLabel("dX");
        x0Text = new JTextField("1", 10);
        dXText = new JTextField("1", 10);

        Listener listener = new Listener();
        x0Text.addActionListener(listener);
        dXText.addActionListener(listener);

        add(x0Label);
        add(x0Text);
        add(dXLabel);
        add(dXText);
    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source == x0Text) {
                System.out.println(x0Text.getText());
                nit.setX(Integer.parseInt(x0Text.getText()));
            } else if(source == dXText) {
                System.out.println(dXText.getText());
                nit.setDx(Integer.parseInt(dXText.getText()));
            }

        }
    }
}
