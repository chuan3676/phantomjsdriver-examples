package tests;

import examples.TwitterUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Ex02Twitter extends BaseTest {

    private static final String TWITTER_ACCOUNT = "tekmaven ";

    @Before
    public void info() {
        System.out.println("* TWITTER ACCOUNT: " + TWITTER_ACCOUNT);
    }

    @Test
    public void shouldHaveAtLeast10Tweets() {
        List<String> tweets = TwitterUtils.getLatestTweets(getDriver(), TWITTER_ACCOUNT);

        // Check it has at least 10 tweets
        assertTrue(tweets.size() >= 10);

        // Print those tweets
        for (int i = 0, ilen = tweets.size(); i < ilen; ++i) {
            System.out.println(TWITTER_ACCOUNT + ": " + tweets.get(i));
        }
    }

    @Test
    public void shouldBeActive() {
        Map<String, Integer> stats = TwitterUtils.getStats(getDriver(), TWITTER_ACCOUNT);
        int totalNumTweets = stats.get(TwitterUtils.STAT_TWEETS);

        assertTrue(totalNumTweets > 100);

        System.out.println("* TOTAL NUMBER OF TWEETS: " + totalNumTweets);
    }

    @Test
    public void shouldBePopular() {
        Map<String, Integer> stats = TwitterUtils.getStats(getDriver(), TWITTER_ACCOUNT);
        int followersNum = stats.get(TwitterUtils.STAT_FOLLOWERS);

        assertTrue(followersNum > 100);

        System.out.println("* NUMBER OF FOLLOWERS: " + followersNum);
    }

    @Test
    public void shouldBeSocial() {
        Map<String, Integer> stats = TwitterUtils.getStats(getDriver(), TWITTER_ACCOUNT);
        int followingNum = stats.get(TwitterUtils.STAT_FOLLOWING);

        assertTrue(followingNum > 200);

        System.out.println("* FOLLOWING: " + followingNum);
    }
}
