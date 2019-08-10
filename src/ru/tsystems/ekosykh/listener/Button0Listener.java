package ru.tsystems.ekosykh.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Button0Listener implements ActionListener {

    private final JTextField display;

    public Button0Listener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = display.getText();
        if (!text.equals("0")) {
            text += "0";
        }
        display.setText(text);
    }
}
