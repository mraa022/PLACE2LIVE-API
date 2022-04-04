package com.example.PLACE2LIVE;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String postCategory;
    private String postAddress;
    private Long posterId;
    public Post(){
        super();
    }
    public Post(@JsonProperty("id") Long id,
                @JsonProperty("postCategory") String postCategory,
                @JsonProperty("postAddress") String postAddress,
                @JsonProperty("posterId") Long posterId) {
        this.id = id;
        this.postCategory = postCategory;
        this.postAddress = postAddress;
        this.posterId = posterId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postCategory='" + postCategory + '\'' +
                ", postAddress='" + postAddress + '\'' +
                ", posterId=" + posterId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public Long getPosterId() {
        return posterId;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}
