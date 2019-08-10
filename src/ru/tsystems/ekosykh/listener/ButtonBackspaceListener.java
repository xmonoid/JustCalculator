package ru.tsystems.ekosykh.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonBackspaceListener implements ActionListener {

    private final JTextField display;

    public ButtonBackspaceListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = display.getText();
        if (text.length() == 1) {
            text = "0";
        } else {
            text = text.substring(0, text.length() - 1);
        }
        display.setText(text);
    }
}
