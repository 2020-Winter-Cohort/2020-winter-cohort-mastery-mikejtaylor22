package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Populator implements CommandLineRunner {

    private TopicStorage topicStorage;
    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;


    public Populator(TopicStorage topicStorage, PostStorage postStorage, HashtagStorage hashtagStorage) {

        this.topicStorage = topicStorage;
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String... args) throws Exception {


//        hashtagStorage.saveHashtag(goodRead);
//        hashtagStorage.saveHashtag(fun);
//        hashtagStorage.saveHashtag(interesting);

        Topic topic1 = new Topic("Learning TDD");
        topicStorage.save(topic1);

        Post post1 = new Post("TDD For Fun and Profit","Arthur Dent", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.");
        post1.setDate(new Date());
        postStorage.save(post1);

        Post post2 = new Post("Test the Fear Away","James Funguy", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.");
        post2.setDate(new Date());
        postStorage.save(post2);
        Post post3 = new Post("Unit Tests and You","Janet Reno", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.");
        post3.setDate(new Date());
        postStorage.save(post3);
        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicStorage.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicStorage.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicStorage.save(topic4);

        Hashtag goodRead = new Hashtag("#GoodRead",post1);
        Hashtag fun = new Hashtag("#Fun",post2);
        Hashtag interesting = new Hashtag("#Interesting",post3);
        hashtagStorage.saveHashtag(goodRead);
        hashtagStorage.saveHashtag(fun);
        hashtagStorage.saveHashtag(interesting);

    }

}
