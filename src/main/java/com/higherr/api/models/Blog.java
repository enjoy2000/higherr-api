package com.higherr.api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Blog {

    private @Id @GeneratedValue Long id;

    private @ManyToOne(cascade={CascadeType.ALL}) User author;
    private String title;
    private String body; //uploading additional file from application
    private String thumnailImageLocation;

    private Blog() {}


    public Blog(User author, String title, String body, String thumnailImageLocation) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.thumnailImageLocation = thumnailImageLocation;
    }
}
