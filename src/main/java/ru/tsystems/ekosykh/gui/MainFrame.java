package ru.tsystems.ekosykh.gui;

import ru.tsystems.ekosykh.listener.CalculateButtonListener;
import ru.tsystems.ekosykh.listener.ClearButtonListener;
import ru.tsystems.ekosykh.listener.DeleteButtonListener;
import ru.tsystems.ekosykh.listener.DigitalButtonListener;
import ru.tsystems.ekosykh.listener.Operation;
import ru.tsystems.ekosykh.listener.OperationalButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    public static final String DEFAULT_NUM = "0";
    static final String CAPTURE = "Just Calculator";

    private Operation operation;
    private int first;

    private JTextField display;

    public MainFrame() {
        super(CAPTURE);

        display = new JTextField();
        display.setName("display");
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setText(DEFAULT_NUM);

        JButton[] digits = new JButton[10];
        for (int i = 0; i < digits.length; i++) {
            String digit = Integer.toString(i);
            digits[i] = new JButton(digit);
            digits[i].setName(digit);
            DigitalButtonListener listener = new DigitalButtonListener(display, digit);
            digits[i].addActionListener(listener);
        }

        Map<String, JButton> operationalButtons = new HashMap<>();
        for (String operation: Arrays.asList("+", "-", "*", "/", "\\")) {
            JButton button = new JButton(operation);
            button.setName(operation);
            button.addActionListener(new OperationalButtonListener(this, operation));
            operationalButtons.put(operation, button);
        }

        JButton buttonCalculate = new JButton("=");
        buttonCalculate.setName("=");
        buttonCalculate.addActionListener(new CalculateButtonListener(this));

        JButton buttonDelete = new JButton("Delete");
        DeleteButtonListener deleteButtonListener = new DeleteButtonListener(display);
        buttonDelete.addActionListener(deleteButtonListener);
        buttonDelete.setName(buttonDelete.getText());
        JButton bClear = new JButton("Clear");
        ClearButtonListener clearButtonListener = new ClearButtonListener(display, DEFAULT_NUM);
        bClear.addActionListener(clearButtonListener);

        display.setBounds(30,40,280,30);
        digits[7].setBounds(40,100,50,40);
        digits[8].setBounds(110,100,50,40);
        digits[9].setBounds(180,100,50,40);
        operationalButtons.get("+").setBounds(250,100,50,40);

        digits[4].setBounds(40,170,50,40);
        digits[5].setBounds(110,170,50,40);
        digits[6].setBounds(180,170,50,40);
        operationalButtons.get("-").setBounds(250,170,50,40);

        digits[1].setBounds(40,240,50,40);
        digits[2].setBounds(110,240,50,40);
        digits[3].setBounds(180,240,50,40);
        operationalButtons.get("*").setBounds(250,240,50,40);

        digits[0].setBounds(40,310,50,40);
        buttonCalculate.setBounds(110,310,50,40);
        operationalButtons.get("\\").setBounds(180,310,50,40);
        operationalButtons.get("/").setBounds(250,310,50,40);

        buttonDelete.setBounds(60,380,100,40);
        bClear.setBounds(180,380,100,40);

        add(display);
        add(digits[7]);
        add(digits[8]);
        add(digits[9]);
        add(operationalButtons.get("/"));
        add(digits[4]);
        add(digits[5]);
        add(digits[6]);
        add(operationalButtons.get("*"));
        add(digits[1]);
        add(digits[2]);
        add(digits[3]);
        add(operationalButtons.get("-"));
        add(digits[0]);
        add(buttonCalculate);
        add(operationalButtons.get("\\"));
        add(operationalButtons.get("+"));
        add(buttonDelete);
        add(bClear);

        setLayout(null);
        setSize(350,500);
        setResizable(false);
    }

    public JTextField getDisplay() {
        return display;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }
}
