package com.tagcloud;

import com.tagcloud.messages.TwitterConnectorImpl;
import com.tagcloud.tagcloud.TagCloudService;
import com.tagcloud.messages.TwitterConnector;
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
    public TagCloudService tagCloudService(TwitterConnector twitterConnector) {
        return new TagCloudService(twitterConnector);
    }

}
