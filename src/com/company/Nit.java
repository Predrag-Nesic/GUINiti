package com.company;

import java.awt.*;

// This is a secondary thread, which has the basic values to be manipulated with.
// The idea is to have a GUI that combines the text areas to insert numbers, the radio buttons to declare sleep time, and
// the buttons to control the GUI to go, or to stop

public class Nit extends Thread {
    private double x, y, dx;
    private int time;
    private String s;

    // the text area is the one to be written on, this text area is an atribute in the constructor, and with the constructor
    // we will be able to forward the CentralPanel text area to it
    private TextArea area;
    private boolean working = false;
    private boolean end = false;

    public Nit(TextArea area) {
        s = "";
        x = 1;
        dx = 1;
        y = x * x;
        time = 1000;
        this.area = area;
        start();
    }

    @Override
    public void run() {
        System.out.println("Running");
        // This while loop is the thing that keeps this thread running. The thread is constantly checking if the end=true/false
        // If the end is false, the loop is calculating, writing, and sleeping
        while(!end) {
            if(!working) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        System.err.println(ex);
                    }
                }
            }
            y = x * x;
            s += (x + "    " + y + "\n");
            area.setText(s);
            System.out.println(s);
            x += dx;

            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }

    public void stopped() {
        working = false;
    }

    public synchronized void go() {
        if(!working) {
            working = true;
            notify();
        }
    }

    public void end() {
        end = true;
        interrupt();
    }

    public void empty() {
        end();
        x = 1;
        dx = 1;
        y = x * x;
        time = 1000;
        s += (x + "    " + y + "\n");
        area.setText(s);
        working = false;
        end = false;
    }

    public void setX(double x) {
        this.x = x;
        y = x * x;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
