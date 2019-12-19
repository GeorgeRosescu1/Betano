package com.example.betano.models;

public abstract class Entity {

    private String username;
    private String password;

    public Entity() {

    }

    public Entity(String username) {
        this.username = username;
    }

    public Entity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
