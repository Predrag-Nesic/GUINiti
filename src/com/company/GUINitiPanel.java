package com.company;

import javax.swing.*;
import java.awt.*;

public class GUINitiPanel extends JPanel {
    Nit nit;

    public GUINitiPanel() {
        setLayout(new BorderLayout());
        CentralPanel center = new CentralPanel();
        nit = new Nit(center.getArea());
        NorthPanel north = new NorthPanel(nit);
        SouthPanel south = new SouthPanel(nit);
        EastPanel east = new EastPanel();
        WestPanel west = new WestPanel(nit);
        add("Center", center);
        add("North", north);
        add("South", south);
        add("East", east);
        add("West", west);

        setBackground(Color.white);
        setPreferredSize(new Dimension(500, 300));
    }
}
