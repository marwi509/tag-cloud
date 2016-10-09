# tag-cloud


[![Build Status](https://travis-ci.org/marwi509/tag-cloud.svg?branch=master)](https://travis-ci.org/marwi509/tag-cloud)

# Instructions
* Install maven and java, if you don't already have it
* For twitter integration (since all twitter calls require authentication) you need to configure twitter4j per the instructions here: http://twitter4j.org/en/configuration.html
* Run the app with "mvn clean spring-boot:run" or with twitter4j config in the run command "mvn clean spring-boot:run -Dtwitter4j.oauth.consumerKey=********************* -Dtwitter4j.oauth.consumerSecret=****************************************** -Dtwitter4j.oauth.accessToken=************************************************** -Dtwitter4j.oauth.accessTokenSecret=******************************************"
* The API is now available at localhost:8080