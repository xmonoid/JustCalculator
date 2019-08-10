package ru.tsystems.ekosykh;

import java.awt.Dimension;
import java.awt.Toolkit;

import ru.tsystems.ekosykh.gui.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

        // The frame settings
        final int WIDTH = 400;
        final int HEIGHT = 400;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setBounds((screenSize.width - WIDTH)/2, (screenSize.height - HEIGHT)/2, WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
