package com.tagcloud.tagcloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagCloudController {

    private final TagCloudService tagCloudService;

    public TagCloudController(TagCloudService tagCloudService) {
        this.tagCloudService = tagCloudService;
    }

    @RequestMapping(value = "/tag-cloud")
    public List<WeightedWord> createTagCloud(@RequestParam(name = "source") String source) {
        return tagCloudService.createTagCloud(source);
    }

}
