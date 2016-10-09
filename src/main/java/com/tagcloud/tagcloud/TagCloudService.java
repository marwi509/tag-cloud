package com.tagcloud.tagcloud;

import com.tagcloud.messages.rss.RssProvider;
import com.tagcloud.messages.twitter.TwitterProvider;

import java.net.URI;
import java.util.List;

public class TagCloudService {

    private final RssProvider rssProvider;
    private final TwitterProvider twitterProvider;
    private final WeightedWordFactory weightedWordFactory;

    public TagCloudService(RssProvider rssProvider, TwitterProvider twitterProvider, WeightedWordFactory weightedWordFactory) {
        this.rssProvider = rssProvider;
        this.twitterProvider = twitterProvider;
        this.weightedWordFactory = weightedWordFactory;
    }

    public List<WeightedWord> createTagCloudFromTwitter(HashTag hashTag) {
        return weightedWordFactory.createTagCloud(twitterProvider.getMessages(hashTag));
    }

    public List<WeightedWord> createTagCloudFromRss(URI uri) {
        return weightedWordFactory.createTagCloud(rssProvider.getMessages(uri));
    }

}
