package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WestPanel extends JPanel {
    JRadioButton radio;
    Nit nit;

    public WestPanel(Nit nit) {
        this.nit = nit;
        String[] s = {"100", "200", "500", "1000", "2000", "5000"};
        setLayout(new GridLayout(s.length, 1));
        setBackground(Color.green);
        ButtonGroup group = new ButtonGroup();
        Listener listener = new Listener();
        for(int i = 0; i < s.length; i++) {
            if(s[i].equals("1000")) {
                radio = new JRadioButton(s[i], true);
            } else {
                radio = new JRadioButton(s[i]);
            }
            radio.addActionListener(listener);
            group.add(radio);
            add(radio);
        }
    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = ((JRadioButton)(e.getSource())).getText();
            System.out.println(s);
            nit.setTime(Integer.parseInt(((JRadioButton)(e.getSource())).getText()));
        }
    }
}
