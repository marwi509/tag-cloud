package com.tagcloud.messages.rss;

import com.tagcloud.messages.Message;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RssProviderImpl implements RssProvider {

    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Message> getMessages(URI uri) {
        Rss rss = restTemplate.getForObject(uri, Rss.class);
        return rss.channel.items
                .stream()
                .map(item -> new Message(item.description))
                .collect(toList());
    }

    @SuppressWarnings("unused")
    @XmlRootElement
    private static class Rss {
        @XmlElement
        private Channel channel;
    }

    @SuppressWarnings({"unused", "MismatchedQueryAndUpdateOfCollection"})
    private static class Channel {
        @XmlElement(name = "item")
        private List<Item> items;
    }

    @SuppressWarnings("unused")
    private static class Item {
        @XmlElement
        private String description;
    }
}
