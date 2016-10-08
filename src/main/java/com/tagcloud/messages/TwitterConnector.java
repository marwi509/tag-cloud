package com.tagcloud.messages;

import java.util.List;

public interface TwitterConnector {
    List<Message> getMessages(String hashtag);
}
