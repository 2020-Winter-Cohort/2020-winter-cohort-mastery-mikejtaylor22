package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    @ManyToOne
    private Topic topic;
    @Lob
    private String content;

    private Date date;

    @ManyToMany(mappedBy = "hashtagPosts")
    private Collection<Hashtag> hashtags;
    @ManyToMany(mappedBy = "commentPost")
    private Collection<Comment>comments;

    protected Post() {
    }

    public Post(String title,String author, Topic topic, String content,Hashtag...hashtag) {
        this.title = title;
        this.author = author;
        this.topic = topic;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != null ? !id.equals(post.id) : post.id != null) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (topic != null ? !topic.equals(post.topic) : post.topic != null) return false;
        return content != null ? content.equals(post.content) : post.content == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
