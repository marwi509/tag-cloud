package com.tagcloud;

import com.google.common.collect.Lists;
import com.tagcloud.messages.Message;
import com.tagcloud.messages.rss.RssProvider;

import java.net.URI;
import java.util.List;

public class FakeRssProvider implements RssProvider {

    @Override
    public List<Message> getMessages(URI uri) {
        return Lists.newArrayList(
                new Message("rss twice four thrice"),
                new Message("twice four thrice thrice"),
                new Message("four four")
        );
    }

}
