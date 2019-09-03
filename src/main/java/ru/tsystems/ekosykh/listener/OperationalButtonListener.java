package ru.tsystems.ekosykh.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ru.tsystems.ekosykh.gui.MainFrame;

public class OperationalButtonListener implements ActionListener {

    private final Operation operation;
    private final MainFrame frame;

    public OperationalButtonListener(MainFrame frame, String operation) {
        this.frame = frame;
        this.operation = Operation.fromString(operation);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField display = frame.getDisplay();
        String first = display.getText();
        frame.setFirst(Integer.parseInt(first));
        frame.setOperation(operation);
        frame.setRefreshDisplay(true);
    }
}
