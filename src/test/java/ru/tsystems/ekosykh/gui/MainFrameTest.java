package ru.tsystems.ekosykh.gui;

import org.assertj.swing.fixture.JButtonFixture;
import org.junit.Test;

public class MainFrameTest extends AbstractFrameTest {

    @Test
    public void testDisplayAtStart() {
        display.requireText("0");
    }

    @Test
    public void testPressZero() {
        display.setText("0");
        window.button("0").focus();
        window.button("0").click();
        display.requireText("0");
    }

    @Test
    public void testPressOne() {
        JButtonFixture button1 = window.button("1");

        display.requireText("0");
        button1.focus();
        button1.click();
        display.requireText("1");
    }

    @Test
    public void testPressAllNumbers() {
        display.setText("0");

        for (int i = 0; i <= 9; i++) {
            digits[i].focus();
            digits[i].click();
        }
        digits[0].focus();
        digits[0].click();

        window.textBox("display").requireText("1234567890");
    }

    @Test
    public void testDelete() {
        display.setText("0");
        delete.focus();
        delete.click();
        display.requireText("0");

        display.setText("1234567890");
        delete.focus();
        for (int i = 0; i < 10; i++) {
            delete.click();
        }
        display.requireText("1");
        delete.click();
        display.requireText("0");
    }
}