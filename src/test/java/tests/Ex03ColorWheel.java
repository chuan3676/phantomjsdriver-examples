package tests;

import examples.Canvas;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Ex03ColorWheel extends BaseTest {

    @Test
    public void shouldDrawAndPrintAColorWheel() {
        WebDriver d = getDriver();
        Canvas c = new Canvas(d);

        c.setCanvasSize(500, 500);
        c.setBackgroundColor("#c40");
        c.drawColorWheel();

        try {
            c.saveCanvasContent("colorwheel.png");
        } catch (IOException ioe) {
            assertTrue(false);
        }
    }
}
