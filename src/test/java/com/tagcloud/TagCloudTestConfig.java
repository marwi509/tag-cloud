package com.tagcloud;

import com.tagcloud.messages.rss.RssProvider;
import com.tagcloud.messages.twitter.TwitterProvider;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TagCloudTestConfig {

    @Bean
    public TwitterProvider twitterProvider() {
        return new FakeTwitterProvider();
    }

    @Bean
    public RssProvider rssProvider() {
        return new FakeRssProvider();
    }

}
