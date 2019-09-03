package ru.tsystems.ekosykh.gui;

import org.junit.Test;

public class CalculationTest extends AbstractFrameTest {

    @Test
    public void testSum() {
        display.setText("0");
        digits[5].focus();
        digits[5].click();
        plus.focus();
        plus.click();
        digits[6].focus();
        digits[6].click();
        calculate.focus();
        calculate.click();
        display.requireText("11");
    }

    @Test
    public void testSubtract() {
        display.setText("0");
        digits[5].focus();
        digits[5].click();
        minus.focus();
        minus.click();
        digits[6].focus();
        digits[6].click();
        calculate.focus();
        calculate.click();
        display.requireText("-1");
    }

    @Test
    public void testMultiply() {
        display.setText("0");
        digits[5].focus();
        digits[5].click();
        multiply.focus();
        multiply.click();
        digits[6].focus();
        digits[6].click();
        calculate.focus();
        calculate.click();
        display.requireText("30");
    }

    @Test
    public void testDivide() {
        display.setText("0");
        digits[3].focus();
        digits[3].click();
        digits[0].focus();
        digits[0].click();
        divide.focus();
        divide.click();
        digits[6].focus();
        digits[6].click();
        calculate.focus();
        calculate.click();
        display.requireText("5");
    }

    @Test
    public void testModulo() {
        display.setText("0");
        digits[3].focus();
        digits[3].click();
        digits[3].click();
        modulo.focus();
        modulo.click();
        digits[6].focus();
        digits[6].click();
        calculate.focus();
        calculate.click();
        display.requireText("3");
    }
}
