package ru.tsystems.ekosykh.gui;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;

import java.awt.*;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

import ru.tsystems.ekosykh.Main;

public class MainFrameTest extends AssertJSwingJUnitTestCase {

    private FrameFixture window;

    @Override
    protected void onSetUp() {
        application(Main.class).start();
        window = findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
            protected boolean isMatching(Frame frame) {
                return MainFrame.CAPTURE.equals(frame.getTitle()) && frame.isShowing();
            }
        }).using(robot());
        window.show();
    }

    @Override
    protected void onTearDown() {
        window.cleanUp();
    }

    @Test
    public void testDisplayAtStart() {
        window.textBox("display").requireText("0");
    }

    @Test
    public void testPressZero() {
        window.textBox("display").requireText("0");
        window.button("0").click();
        window.textBox("display").requireText("0");
    }

    @Test
    public void testPressOne() {
        window.textBox("display").requireText("0");
        window.button("1").click();
        window.textBox("display").requireText("1");
    }
}