package ru.tsystems.ekosykh.gui;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

import ru.tsystems.ekosykh.Main;

import javax.swing.*;

public class MainFrameTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;
    private JTextComponentFixture display;
    private JButtonFixture delete;
    private JButtonFixture[] digits;

    private JButtonFixture plus;
    private JButtonFixture minus;
    private JButtonFixture multiply;
    private JButtonFixture divide;
    private JButtonFixture modulo;

    private JButtonFixture calculate;

    @Override
    protected void onSetUp() {
        application(Main.class).start();
        window = findFrame(new GenericTypeMatcher<JFrame>(JFrame.class) {
            protected boolean isMatching(JFrame frame) {
                return MainFrame.CAPTURE.equals(frame.getTitle()) && frame.isShowing();
            }
        }).using(robot());
        display = window.textBox("display");
        delete = window.button("Delete");
        digits = new JButtonFixture[10];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = window.button(Integer.toString(i));
        }
        plus = window.button("+");
        minus = window.button("-");
        multiply = window.button("*");
        divide = window.button("/");
        modulo = window.button("\\");
        calculate = window.button("=");
        window.focus();
    }

    @Override
    protected void onTearDown() {
        if (window != null) {
            window.cleanUp();
        }
    }

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
        for (int i = 0; i <= 10; i++) {
            delete.click();
        }
        display.requireText("0");
    }

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