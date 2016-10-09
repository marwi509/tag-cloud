package com.tagcloud.messages.twitter;

import java.util.regex.Pattern;

public class HashTag {

    private final String hashTag;
    private static final Pattern pattern = Pattern.compile("(^|\\s)#([A-Za-z_][A-Za-z0-9_]*)");

    private HashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    public static HashTag valueOf(String value) {
        if(pattern.matcher(value).matches()) {
            return new HashTag(value);
        } else {
            throw new InvalidHashTagException();
        }
    }

    public String asString() {
        return hashTag;
    }
}
