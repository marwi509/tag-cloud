package com.tagcloud.messages.rss;

import com.tagcloud.messages.Message;

import java.net.URI;
import java.util.List;

public interface RssProvider {

    List<Message> getMessages(URI uri);

}
