package com.example.betano.models;

public class User {

    private String firstName;
    private int age;
    private String lastName;
    private String userType;
    private String email;


    public User() {

    }

    public User(String firstName, int age, String phone, String lastName, String userType) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
