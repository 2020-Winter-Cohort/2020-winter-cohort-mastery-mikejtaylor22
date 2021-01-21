package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Comment;
import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import com.survivingcodingbootcamp.blog.storage.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    @Autowired
    private HashtagStorage hashtagStorage;
    @Autowired
    private TopicStorage topicStorage;
    @Autowired
    private CommentRepository commentRepository;

    public PostController(PostStorage postStorage) {

        this.postStorage = postStorage;

    }
@RequestMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        model.addAttribute("hashtags",postStorage.retrievePostById(id).getHashtags());
    model.addAttribute("commentList",postStorage.retrievePostById(id).getComments());
        return "single-post-template";
    }

@PostMapping("/addPost/{topicId}")
    public String addNewPost(Model model,@PathVariable Long topicId, @RequestParam String newTitle,@RequestParam String newAuthor,@RequestParam String newContent){
        Post newPost = new Post(newTitle,newAuthor,topicStorage.retrieveSingleTopic(topicId),newContent);
        newPost.setDate(new Date());
        postStorage.save(newPost);
        return "redirect:/topics/{topicId}";
}

@RequestMapping("/addcomment/{id}")
    public String addNewComment(@PathVariable Long id,@RequestParam String newComment,Model model){
    Comment addComment = new Comment(newComment,postStorage.retrievePostById(id));
    commentRepository.save(addComment);
//    model.addAttribute("commentList",postStorage.retrievePostById(id).getComments());
    System.out.println(postStorage.retrievePostById(id).getComments());
        return "redirect:/posts/{id}";

}

}
