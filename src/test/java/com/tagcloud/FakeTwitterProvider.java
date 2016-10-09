package com.tagcloud;


import com.google.common.collect.Lists;
import com.tagcloud.messages.Message;
import com.tagcloud.messages.twitter.TwitterProvider;
import com.tagcloud.tagcloud.HashTag;

import java.util.List;

public class FakeTwitterProvider implements TwitterProvider {
    @Override
    public List<Message> getMessages(HashTag hashTag) {
        return Lists.newArrayList(
                new Message("twitter twice four thrice"),
                new Message("twice four thrice thrice"),
                new Message("four four")
        );
    }
}
