package ru.tsystems.ekosykh;

import ru.tsystems.ekosykh.gui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GuiCreator implements Runnable {

    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    @Override
    public void run() {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frame.getSize().width) / 2,
                (screenSize.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
}
