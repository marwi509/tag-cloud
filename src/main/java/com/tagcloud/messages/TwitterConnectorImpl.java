package com.tagcloud.messages;

import twitter4j.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TwitterConnectorImpl implements TwitterConnector {

    @Override
    public List<Message> getMessages(String hashTag) {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query(hashTag);
        query.setCount(100);

        QueryResult result = search(twitter, query);

        return result.getTweets()
                .stream()
                .map(tweet -> new Message(getTweetText(tweet)))
                .collect(toList());
    }

    private String getTweetText(Status tweet) {
        if(tweet.isRetweet()) {
            return tweet.getRetweetedStatus().getText();
        } else {
            return tweet.getText();
        }
    }

    private QueryResult search(Twitter twitter, Query query) {
        QueryResult result;
        try {
             result = twitter.search(query);
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
