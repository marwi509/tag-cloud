package com.tagcloud.messages;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Message {

    private final String text;

    public Message(String text) {
        this.text = text;
    }

    public List<String> getWords() {
        return Arrays.stream(text.split(" ")).collect(toList());
    }
}
