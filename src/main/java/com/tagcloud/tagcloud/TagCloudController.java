package com.tagcloud.tagcloud;

import com.tagcloud.messages.twitter.HashTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
public class TagCloudController {

    private final TagCloudService tagCloudService;

    @Autowired
    public TagCloudController(TagCloudService tagCloudService) {
        this.tagCloudService = tagCloudService;
    }

    @RequestMapping(value = "/tag-cloud-twitter")
    public List<WeightedWord> createTagCloudFromHashTag(@RequestParam(name = "source") HashTag source) {
        return tagCloudService.createTagCloudFromTwitter(source);
    }

    @RequestMapping(value = "/tag-cloud-rss")
    public List<WeightedWord> createTagCloudFromHashTag(@RequestParam(name = "source") URI uri) {
        return tagCloudService.createTagCloudFromRss(uri);
    }

}
