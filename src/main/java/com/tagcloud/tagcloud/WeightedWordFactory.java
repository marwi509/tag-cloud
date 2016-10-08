package com.tagcloud.tagcloud;

import com.tagcloud.messages.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class WeightedWordFactory {

    public List<WeightedWord> createTagCloud(List<Message> messages) {

        List<String> words =
                messages.stream()
                .flatMap(message -> message.getWords().stream())
                .collect(toList());

        Map<String, Integer> wordCount = getWordCount(words);

        int maxCount = wordCount.entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Integer::compare)
                .orElse(0);

        return asWeightedWords(wordCount, maxCount);
    }

    private List<WeightedWord> asWeightedWords(Map<String, Integer> wordCount, int maxCount) {
        return wordCount.entrySet()
                .stream()
                .map(e -> new WeightedWord(e.getKey(), (double)e.getValue()/maxCount))
                .sorted(comparing(WeightedWord::getWeight).reversed())
                .limit(100)
                .collect(toList());
    }

    private Map<String, Integer> getWordCount(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word: words) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count==null) ? 1 : count+1);
        }
        return wordCount;
    }

}
