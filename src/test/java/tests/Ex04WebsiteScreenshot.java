package tests;

import examples.ThumbnailGenerator;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Ex04WebsiteScreenshot extends BaseTest {

    @Test
    public void shouldTakeAScreenthot() {
        WebDriver d = getDriver();
        d.get("http://blog.ivandemarino.me");

        ThumbnailGenerator tg = new ThumbnailGenerator(d);
        tg.setSize(800, 200);
        tg.setBackgroundColor("#fff");

        try {
            tg.saveThumbnail("ivandemarino.me.png");
        } catch (IOException ioe) {
            assertTrue(false);
        }
    }
}
