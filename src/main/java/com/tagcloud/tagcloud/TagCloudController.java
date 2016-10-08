package com.tagcloud.tagcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagCloudController {

    private final TagCloudService tagCloudService;

    @Autowired
    public TagCloudController(TagCloudService tagCloudService) {
        this.tagCloudService = tagCloudService;
    }

    @RequestMapping(value = "/tag-cloud-hash-tag")
    public List<WeightedWord> createTagCloudFromHashTag(@RequestParam(name = "source") HashTag source) {
        return tagCloudService.createTagCloudFromTwitter(source);
    }

}
