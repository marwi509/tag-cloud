package com.tagcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Import(TagCloudConfig.class)
public class TagCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagCloudApplication.class, args);
	}
}
