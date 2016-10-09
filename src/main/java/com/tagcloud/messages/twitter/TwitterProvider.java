package com.tagcloud.messages.twitter;

import com.tagcloud.messages.Message;
import com.tagcloud.tagcloud.HashTag;

import java.util.List;

public interface TwitterProvider {
    List<Message> getMessages(HashTag hashTag);
}
