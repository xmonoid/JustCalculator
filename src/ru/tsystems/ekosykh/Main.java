package ru.tsystems.ekosykh;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GuiCreator guiCreator = new GuiCreator();
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(guiCreator);
    }
}
