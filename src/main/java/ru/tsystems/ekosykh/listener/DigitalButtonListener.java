package ru.tsystems.ekosykh.listener;

import ru.tsystems.ekosykh.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DigitalButtonListener implements ActionListener {

    private final MainFrame frame;
    private final JTextField display;
    private final String number;

    public DigitalButtonListener(MainFrame frame, String number) {
        this.frame = frame;
        this.display = frame.getDisplay();
        this.number = number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = display.getText();
        if (text.equals("0") || frame.isRefreshDisplay()) {
            text = number;
            frame.setRefreshDisplay(false);
        } else {
            text += number;
        }
        display.setText(text);
    }
}
