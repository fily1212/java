package com.example.springsocial.controller;

import com.example.springsocial.exception.ResourceNotFoundException;
import com.example.springsocial.model.Photo;
import com.example.springsocial.model.Post;
import com.example.springsocial.model.User;
import com.example.springsocial.payload.PostAddRequest;
import com.example.springsocial.payload.PostResponse;
import com.example.springsocial.repository.PostRepository;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/post/all")
//    @PreAuthorize("hasRole('USER')")
    public List<PostResponse> getPosts() {
        List<PostResponse> postResponses = new ArrayList<>();
        List<Post> posts = postRepository.findAll();
        for (Post p: posts ) {
            PostResponse postResponse = new PostResponse(p);
            postResponses.add(postResponse);
        }
        return postResponses;
    }

    @PostMapping("/post/add")
    public PostResponse addPost(@CurrentUser UserPrincipal userPrincipal, @RequestBody PostAddRequest postAddRequest){

        User currentUsers = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        Post post = new Post();
        post.setOwner(currentUsers);
        post.setComments(new ArrayList<>());
        post.setDate(new Date());
        post.setPostLikes(new ArrayList<>());
        post.setDescription(postAddRequest.getDescription());
        post.setPhoto(new Photo());

        postRepository.save(post);

        PostResponse postResponse = new PostResponse(post);
        return postResponse;

    }

}
