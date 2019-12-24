package com.example.betano.models;

public abstract class Entity {

    private String email;

    public Entity() {

    }

    public Entity(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
