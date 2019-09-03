package ru.tsystems.ekosykh.listener;

import ru.tsystems.ekosykh.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {

    private final MainFrame frame;
    private final String defaultValue;

    public ClearButtonListener(MainFrame frame, final String defaultValue) {
        this.frame = frame;
        this.defaultValue = defaultValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getDisplay().setText(defaultValue);
        frame.setRefreshDisplay(true);
    }
}
