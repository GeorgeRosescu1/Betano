package com.example.betano.models;

public abstract class User extends Entity {

    private String firstName;
    private int age;
    private String phone;
    private String lastName;
    private String userType;


    public User() {

    }

    public User(String firstName, int age, String phone, String lastName, String username, String userType) {
        super(username);
        this.firstName = firstName;
        this.age = age;
        this.phone = phone;
        this.lastName = lastName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
