package com.tagcloud;

import com.tagcloud.messages.rss.RssConnector;
import com.tagcloud.messages.rss.RssConnectorImpl;
import com.tagcloud.messages.twitter.TwitterConnector;
import com.tagcloud.messages.twitter.TwitterConnectorImpl;
import com.tagcloud.tagcloud.TagCloudService;
import com.tagcloud.tagcloud.WeightedWordFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tagcloud")
public class TagCloudConfig {

    @Bean
    public TwitterConnector twitterConnector() {
        return new TwitterConnectorImpl();
    }

    @Bean
    public RssConnector rssConnector() {
        return new RssConnectorImpl();
    }

    @Bean
    public WeightedWordFactory weightedWordFactory() {
        return new WeightedWordFactory();
    }

    @Bean
    public TagCloudService tagCloudService(
            TwitterConnector twitterConnector,
            RssConnector rssConnector,
            WeightedWordFactory weightedWordFactory) {
        return new TagCloudService(
                rssConnector,
                twitterConnector,
                weightedWordFactory);
    }

}
