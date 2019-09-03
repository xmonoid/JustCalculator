package ru.tsystems.ekosykh.gui;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import ru.tsystems.ekosykh.Main;

import javax.swing.*;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;

public abstract class AbstractFrameTest extends AssertJSwingJUnitTestCase {

    FrameFixture window;
    JTextComponentFixture display;
    JButtonFixture delete;
    JButtonFixture[] digits;

    JButtonFixture plus;
    JButtonFixture minus;
    JButtonFixture multiply;
    JButtonFixture divide;
    JButtonFixture modulo;

    JButtonFixture calculate;

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
}
