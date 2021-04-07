package com.example.springsocial.model;

import javax.persistence.*;

@Entity
//@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName="id")
    private User owner;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="post", referencedColumnName="id")
    private Post post;

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

    public Post getPhoto() {
        return post;
    }

    public void setPhoto(Post post) {
        this.post = post;
    }
}
