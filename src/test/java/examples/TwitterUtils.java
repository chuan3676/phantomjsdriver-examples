package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterUtils {
    private static final String MOBILE_TWITTER_BASE_URL = "http://mobile.twitter.com/";

    public static final String STAT_TWEETS      = "tweets";
    public static final String STAT_FOLLOWING   = "following";
    public static final String STAT_FOLLOWERS   = "followers";

    public static List<String> getLatestTweets(WebDriver driver, String username) {
        // Load twitter mobile page for the given username
        driver.get(MOBILE_TWITTER_BASE_URL + username);

        List<String> tweets = new ArrayList<String>(10);

        // Fetch all the tweets on the page
        List<WebElement> tweetElements = driver.findElements(By.cssSelector("div.tweet-text div"));

        // Aggregate tweets
        for (int i = 0, ilen = tweetElements.size(); i < ilen; ++i) {
            tweets.add(tweetElements.get(i).getText());
        }

        return tweets;
    }

    public static Map<String, Integer> getStats(WebDriver driver, String username) {
        // Load twitter mobile page for the given username
        driver.get(MOBILE_TWITTER_BASE_URL + username);

        Map<String, Integer> stats  = new HashMap<String, Integer>(3);

        // Fetch stats
        List<WebElement> statsElements = driver.findElements(By.cssSelector("div.profile td.stat div.statnum"));

        // Aggregate stats
        // NOTE: The following data scraping is so BAD I'm ashamed of myself
        stats.put(STAT_TWEETS, Integer.parseInt(statsElements.get(0).getText().replaceAll("\\.|,", "")));
        stats.put(STAT_FOLLOWING, Integer.parseInt(statsElements.get(1).getText()));
        stats.put(STAT_FOLLOWERS, Integer.parseInt(statsElements.get(2).getText()));

        return stats;
    }
}
