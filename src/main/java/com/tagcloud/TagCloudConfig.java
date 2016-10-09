package com.tagcloud;

import com.tagcloud.messages.rss.RssProvider;
import com.tagcloud.messages.rss.RssProviderImpl;
import com.tagcloud.messages.twitter.TwitterProvider;
import com.tagcloud.messages.twitter.TwitterProviderImpl;
import com.tagcloud.tagcloud.TagCloudService;
import com.tagcloud.tagcloud.WeightedWordFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tagcloud")
public class TagCloudConfig {

    @Bean
    public TwitterProvider twitterConnector() {
        return new TwitterProviderImpl();
    }

    @Bean
    public RssProvider rssConnector() {
        return new RssProviderImpl();
    }

    @Bean
    public WeightedWordFactory weightedWordFactory() {
        return new WeightedWordFactory();
    }

    @Bean
    public TagCloudService tagCloudService(
            TwitterProvider twitterProvider,
            RssProvider rssProvider,
            WeightedWordFactory weightedWordFactory) {
        return new TagCloudService(
                rssProvider,
                twitterProvider,
                weightedWordFactory);
    }

}
