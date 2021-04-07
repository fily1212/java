package com.example.springsocial.payload;

import com.example.springsocial.model.Post;

import java.util.Date;

public class PostResponse extends Post {

    public PostResponse(Post post){
        setComments(post.getComments());
        setDate(post.getDate());
        setDescription(post.getDescription());
        setId(post.getId());
        setOwner(post.getOwner());
        setPhotoLikes(post.getPhotoLikes());
    }

}
