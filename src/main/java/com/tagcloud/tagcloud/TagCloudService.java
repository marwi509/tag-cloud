package com.tagcloud.tagcloud;

import com.tagcloud.messages.rss.RssConnector;
import com.tagcloud.messages.twitter.TwitterConnector;

import java.net.URI;
import java.util.List;

public class TagCloudService {

    private final RssConnector rssConnector;
    private final TwitterConnector twitterConnector;
    private final WeightedWordFactory weightedWordFactory;

    public TagCloudService(RssConnector rssConnector, TwitterConnector twitterConnector, WeightedWordFactory weightedWordFactory) {
        this.rssConnector = rssConnector;
        this.twitterConnector = twitterConnector;
        this.weightedWordFactory = weightedWordFactory;
    }

    public List<WeightedWord> createTagCloudFromTwitter(HashTag hashTag) {
        return weightedWordFactory.createTagCloud(twitterConnector.getMessages(hashTag));
    }

    public List<WeightedWord> createTagCloudFromRss(URI uri) {
        return weightedWordFactory.createTagCloud(rssConnector.getMessages(uri));
    }

}
