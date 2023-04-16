package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thread");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUINitiPanel panel = new GUINitiPanel();

        frame.getContentPane().add(panel);
        frame.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);
    }
}