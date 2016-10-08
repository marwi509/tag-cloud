package com.tagcloud.tagcloud;

import com.google.common.collect.Lists;
import com.tagcloud.messages.Message;
import com.tagcloud.messages.twitter.TwitterConnector;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class WeightedWordFactoryTest {

    private WeightedWordFactory weightedWordFactory;

    @Before
    public void setUp() {
        weightedWordFactory = new WeightedWordFactory();
    }

    @Test
    public void createTagCloud_noTweets_shouldReturnNoWords() throws Exception {
        List<WeightedWord> weightedWords = weightedWordFactory.createTagCloud(emptyList());

        assertThat(weightedWords.isEmpty(), is(true));
    }

    @Test
    public void createTagCloud_shouldCalculateWeightsCorrectly() {
        List<Message> messages = Lists.newArrayList(
                new Message("once twice four thrice"),
                new Message("twice four thrice thrice"),
                new Message("four four")
        );

        List<WeightedWord> weightedWords = weightedWordFactory.createTagCloud(messages);

        assertThat(weightedWords.size(), is(4));
        assertThat(weightedWords.get(0), is(equalTo(new WeightedWord("four", 1.0D))));
        assertThat(weightedWords.get(1), is(equalTo(new WeightedWord("thrice", 0.75D))));
        assertThat(weightedWords.get(2), is(equalTo(new WeightedWord("twice", 0.5D))));
        assertThat(weightedWords.get(3), is(equalTo(new WeightedWord("once", 0.25D))));

    }
}