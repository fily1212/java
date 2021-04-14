package com.example.springsocial.controller;

import com.example.springsocial.exception.ResourceNotFoundException;
import com.example.springsocial.model.Photo;
import com.example.springsocial.model.Post;
import com.example.springsocial.model.PostLike;
import com.example.springsocial.model.User;
import com.example.springsocial.payload.PostAddRequest;
import com.example.springsocial.payload.PostResponse;
import com.example.springsocial.repository.PhotoRepository;
import com.example.springsocial.repository.PostLikeRepository;
import com.example.springsocial.repository.PostRepository;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PostLikeRepository postLikeRepository;


    @GetMapping("/post/all")
//    @PreAuthorize("hasRole('USER')")
    public List<PostResponse> getPosts() {
        List<PostResponse> postResponses = new ArrayList<>();
        List<Post> posts = postRepository.findAll();
        for (Post p : posts) {
            PostResponse postResponse = new PostResponse(p);
            postResponses.add(postResponse);
        }
        return postResponses;
    }

    @GetMapping("/post/add/like/{id}")
    public boolean addPostLike(@CurrentUser UserPrincipal userPrincipal, @PathVariable Long id) {

        User currentUsers = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        boolean response = false;
        if (!postLikeRepository.existsByOwnerAndPost(currentUsers, post)) {
            response = true;
            PostLike postLike = new PostLike();
            postLike.setOwner(currentUsers);
            postLike.setPost(post);
            postLikeRepository.save(postLike);
            post.getPostLikes().add(postLike);
            postRepository.save(post);
        }

        return response;

    }


    @PostMapping("/post/add")
    public PostResponse addPost(@CurrentUser UserPrincipal userPrincipal, @RequestBody PostAddRequest postAddRequest) {

        User currentUsers = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        Post post = new Post();
        post.setOwner(currentUsers);
        post.setComments(new ArrayList<>());
        post.setDate(new Date());
        post.setPostLikes(new ArrayList<>());
        post.setDescription(postAddRequest.getDescription());

        Photo photo = photoRepository.findById(postAddRequest.getIdPhoto())
                .orElseThrow(() -> new ResourceNotFoundException("Photo", "id", postAddRequest.getIdPhoto()));

        photo.setOwner(currentUsers);

        post.setPhoto(photo);

        postRepository.save(post);

        PostResponse postResponse = new PostResponse(post);
        return postResponse;

    }

    @PostMapping("/post/photo/add")
    public Long addPhoto(@CurrentUser UserPrincipal userPrincipal, @RequestParam("file") MultipartFile file) {

        User currentUsers = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Users", "id", userPrincipal.getId()));

        Photo photo = new Photo();
        photo.setOwner(currentUsers);
        try {
            photo.setPicture(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photoRepository.save(photo).getId();

    }

    @GetMapping("post/photo/{id}")
    public ResponseEntity<Resource> getPhoto(@PathVariable Long id) {

        Photo photo = photoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Photo", "id", id));

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "1.png" + "\"")
                .body(new ByteArrayResource(photo.getPicture()));


    }
}