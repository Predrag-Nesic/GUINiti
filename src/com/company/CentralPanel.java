package com.company;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel {
    // this text area will be "fetched" and forwarded to the Nit object to write on it
    private TextArea area;

    public CentralPanel() {
        area = new TextArea(40, 100);
        setBackground(Color.white);
        add(area);
    }

    public TextArea getArea() {
        return this.area;
    }
}
