package com.tagcloud.tagcloud;

import com.tagcloud.messages.Message;
import com.tagcloud.messages.TwitterConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class TagCloudService {

    private final TwitterConnector twitterConnector;

    public TagCloudService(TwitterConnector twitterConnector) {
        this.twitterConnector = twitterConnector;
    }

    public List<WeightedWord> createTagCloud(String hashTag) {
        List<Message> messages = twitterConnector.getMessages(hashTag);

        if(messages.isEmpty()) {
            return emptyList();
        }

        List<String> words = messages.stream().flatMap(message -> message.getWords().stream()).collect(toList());
        Map<String, Integer> wordCount = new HashMap<>();

        for(String word: words) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count==null) ? 1 : count+1);
        }

        int maxCount = wordCount.entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Integer::compare)
                .get();

        return wordCount.entrySet()
                .stream()
                .map(e -> new WeightedWord(e.getKey(), (double)e.getValue()/maxCount))
                .sorted(comparing(WeightedWord::getWeight).reversed())
                .limit(100)
                .collect(toList());
    }

}
