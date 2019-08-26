package ru.tsystems.ekosykh.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DigitalButtonListener implements ActionListener {

    private final JTextField display;
    private final String number;

    public DigitalButtonListener(JTextField display, String number) {
        this.display = display;
        this.number = number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = display.getText();
        if (text.equals("0")) {
            text = number;
        } else {
            text += number;
        }
        display.setText(text);
    }
}
