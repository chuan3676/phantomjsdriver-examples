package pjsd.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ex01 extends BaseTest {

    /** Dummy test that prints out User-Agent and IP */
    @Test
    public void echoUserAgentAndIp() {
        WebDriver d = getDriver();

        d.get("http://www.whatsmyuseragent.com/");
        System.out.println(
                "My User-Agent: "
                + d.findElement(By.id("body_lbUserAgent")).getText());
        System.out.println(
                "My IP: "
                + d.findElement(By.id("body_lbIP")).getText());
    }
}
