package com.tagcloud;

import com.tagcloud.tagcloud.WeightedWord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TagCloudApplicationTests {

	@Value("${local.server.port}")
	private int serverPort;

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void getWeightedWordsUsingHashTag() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:" + serverPort)
				.path("/tag-cloud-twitter")
				.queryParam("source", "#fun")
				.build()
				.toUri();

		WeightedWordList weightedWords = restTemplate.getForObject(uri, WeightedWordList.class);

		assertThat(weightedWords.size(), is(4));
		assertThat(weightedWords.get(0), is(equalTo(new WeightedWord("four", 1.0D))));
		assertThat(weightedWords.get(1), is(equalTo(new WeightedWord("thrice", 0.75D))));
		assertThat(weightedWords.get(2), is(equalTo(new WeightedWord("twice", 0.5D))));
		assertThat(weightedWords.get(3), is(equalTo(new WeightedWord("twitter", 0.25D))));
	}

	@Test
	public void getWeightedWordsUsingRssUrl() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:" + serverPort)
				.path("/tag-cloud-rss")
				.queryParam("source", "https://www.avanza.se/forum/forum/rss/8")
				.build()
				.toUri();

		WeightedWordList weightedWords = restTemplate.getForObject(uri, WeightedWordList.class);

		assertThat(weightedWords.size(), is(4));
		assertThat(weightedWords.get(0), is(equalTo(new WeightedWord("four", 1.0D))));
		assertThat(weightedWords.get(1), is(equalTo(new WeightedWord("thrice", 0.75D))));
		assertThat(weightedWords.get(2), is(equalTo(new WeightedWord("twice", 0.5D))));
		assertThat(weightedWords.get(3), is(equalTo(new WeightedWord("rss", 0.25D))));
	}

	private static class WeightedWordList extends ArrayList<WeightedWord>{}

}
