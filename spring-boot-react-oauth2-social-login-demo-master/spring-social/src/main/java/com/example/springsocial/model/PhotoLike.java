package com.example.springsocial.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
//@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PhotoLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName="id")
    private User owner;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="photo", referencedColumnName="id")
    private Photo photo;

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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
