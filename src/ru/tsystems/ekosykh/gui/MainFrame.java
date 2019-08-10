package ru.tsystems.ekosykh.gui;

import java.awt.*;

import javax.swing.*;

import ru.tsystems.ekosykh.listener.Button0Listener;
import ru.tsystems.ekosykh.listener.ButtonNon0Listener;
import ru.tsystems.ekosykh.listener.ButtonBackspaceListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Just Calculator");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 4, 20, 20));

        JTextField display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Consolas", Font.BOLD, 26));
        display.setText("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        container.add(display);

        JButton button0 = new JButton("0");
        button0.addActionListener(new Button0Listener(display));
        container.add(button0);

        JButton[] numberButtons = new JButton[9];
        for (int i = 0; i < numberButtons.length; i++) {
            String actualNumber = Integer.toString(i + 1);
            numberButtons[i] = new JButton(actualNumber);
            numberButtons[i].addActionListener(new ButtonNon0Listener(display, actualNumber));
            container.add(numberButtons[i]);
        }

        JButton buttonBackspace = new JButton("<");
        buttonBackspace.addActionListener(new ButtonBackspaceListener(display));
        container.add(buttonBackspace);
    }
}
