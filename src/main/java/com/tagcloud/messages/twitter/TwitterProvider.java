package com.tagcloud.messages.twitter;

import com.tagcloud.messages.Message;

import java.util.List;

public interface TwitterProvider {
    List<Message> getMessages(HashTag hashTag);
}
