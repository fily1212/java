package com.example.springsocial.model;

import java.util.Date;
import java.util.List;

public class Photo {

    private Long id;

    private User owner;

    private byte[] picture;

    private String description;

    private List<PhotoLike> photoLikes;

    private List<Comment> comments;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PhotoLike> getPhotoLikes() {
        return photoLikes;
    }

    public void setPhotoLikes(List<PhotoLike> photoLikes) {
        this.photoLikes = photoLikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
