package ru.tsystems.ekosykh.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {

    private final JTextField display;
    private final String defaultValue;

    public ClearButtonListener(JTextField display, final String defaultValue) {
        this.display = display;
        this.defaultValue = defaultValue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        display.setText(defaultValue);
    }
}
