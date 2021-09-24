package com.igt.reactivedemo.reactivestackserverdemo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    private String id;

    public Movie() {}

    public Movie(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
