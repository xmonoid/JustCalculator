package ru.tsystems.ekosykh.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ru.tsystems.ekosykh.gui.MainFrame;

public class CalculateButtonListener implements ActionListener {

    private final MainFrame frame;

    public CalculateButtonListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int first = frame.getFirst();

        JTextField display = frame.getDisplay();
        int second = Integer.parseInt(display.getText());
        Operation operation = frame.getOperation();

        final int result;
        switch (operation) {
        case ADD:
            result = first + second;
            break;
        case SUBTRACT:
            result = first - second;
            break;
        case MULTIPLY:
            result = first * second;
            break;
        case DIVIDE:
            result = first / second;
            break;
        case MODULO:
            result = first % second;
            break;
        default:
            throw new RuntimeException("Unknown operation");
        }
        frame.setRefreshDisplay(true);
        display.setText(Integer.toString(result));
    }
}
