package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class Ex01UA extends BaseTest {
    private static final Pattern uaPattern = Pattern.compile(".*(Firefox|Chrome).*");

    @Test
    public void userAgentAndIpShouldBeValid() {
        WebDriver d = getDriver();

        // Load page
        d.get("http://youruseragent.info/what-is-my-user-agent");
        // Read values from page
        String myUA = d.findElement(By.cssSelector("#ua-string span")).getText();
        String myIP = d.findElement(By.cssSelector("#ip-address span")).getText();

        // Print
        System.out.println("My User-Agent: " + myUA);
        System.out.println("My IP: " + myIP);

        // Validate
        assertTrue(isUserAgentValid(myUA));
    }

    public boolean isUserAgentValid(String ua) {
        return uaPattern.matcher(ua).matches();
    }
}
