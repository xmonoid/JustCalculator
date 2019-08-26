package ru.tsystems.ekosykh.gui;

import ru.tsystems.ekosykh.listener.ClearButtonListener;
import ru.tsystems.ekosykh.listener.DeleteButtonListener;
import ru.tsystems.ekosykh.listener.DigitalButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private  static final String DEFAULT_NUM = "0";

    JTextField display;
    JButton[] digitals;
    JButton bDivide, bMultiply, bSubtract, bAdd, bModulo, bCalculate, bDelete, bClear;

    public MainFrame() {
        super("Just Calculator");

        display = new JTextField();
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setText(DEFAULT_NUM);

        digitals = new JButton[10];
        for (int i = 0; i < digitals.length; i++) {
            digitals[i] = new JButton(Integer.toString(i));
            DigitalButtonListener listener = new DigitalButtonListener(display, Integer.toString(i));
            digitals[i].addActionListener(listener);
        }

        bAdd = new JButton("+");
        bSubtract = new JButton("-");
        bMultiply = new JButton("*");
        bDivide = new JButton("/");
        bModulo = new JButton("\\");
        bCalculate = new JButton("=");
        bDelete = new JButton("Delete");
        DeleteButtonListener deleteButtonListener = new DeleteButtonListener(display);
        bDelete.addActionListener(deleteButtonListener);
        bClear = new JButton("Clear");
        ClearButtonListener clearButtonListener = new ClearButtonListener(display, DEFAULT_NUM);
        bClear.addActionListener(clearButtonListener);

        display.setBounds(30,40,280,30);
        digitals[7].setBounds(40,100,50,40);
        digitals[8].setBounds(110,100,50,40);
        digitals[9].setBounds(180,100,50,40);
        bAdd.setBounds(250,100,50,40);

        digitals[4].setBounds(40,170,50,40);
        digitals[5].setBounds(110,170,50,40);
        digitals[6].setBounds(180,170,50,40);
        bSubtract.setBounds(250,170,50,40);

        digitals[1].setBounds(40,240,50,40);
        digitals[2].setBounds(110,240,50,40);
        digitals[3].setBounds(180,240,50,40);
        bMultiply.setBounds(250,240,50,40);

        digitals[0].setBounds(40,310,50,40);
        bCalculate.setBounds(110,310,50,40);
        bModulo.setBounds(180,310,50,40);
        bDivide.setBounds(250,310,50,40);

        bDelete.setBounds(60,380,100,40);
        bClear.setBounds(180,380,100,40);

        add(display);
        add(digitals[7]);
        add(digitals[8]);
        add(digitals[9]);
        add(bDivide);
        add(digitals[4]);
        add(digitals[5]);
        add(digitals[6]);
        add(bMultiply);
        add(digitals[1]);
        add(digitals[2]);
        add(digitals[3]);
        add(bSubtract);
        add(digitals[0]);
        add(bCalculate);
        add(bModulo);
        add(bAdd);
        add(bDelete);
        add(bClear);

        setLayout(null);
        setSize(350,500);
        setResizable(false);
    }
}
