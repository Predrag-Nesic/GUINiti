package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthPanel extends JPanel {
    JButton go, stop, empty;
    Nit nit;
    public NorthPanel(Nit nit) {
        this.nit = nit;
        go = new JButton("Go");
        stop =  new JButton("Stop");
        empty = new JButton("Empty");
        Listener listener = new Listener();
        go.addActionListener(listener);
        stop.addActionListener(listener);
        empty.addActionListener(listener);

        add(go);
        add(stop);
        add(empty);
    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            // With these buttons the constant listening of the Nit object we can run with the:
            // go() method which sets the boolean working = true;
            // stopped() method which sets the boolean working = false;
            // end() method which sets the boolean end = true;
            // and empty method() which sets all the values to the beginning stages or values;
            if(source == go) {
                System.out.println("Going");
                nit.go();
            } else if(source == stop) {
                System.out.println("Stopped");
                nit.stopped();
            } else if(source == empty) {
                System.out.println("Emptied");
                nit.end();
                nit.empty();
            }
        }
    }
}
