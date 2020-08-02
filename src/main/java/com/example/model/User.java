package com.example.model;

import org.springframework.context.annotation.Primary;

@Primary
public class User {

    private String name;
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public User() {
    }
}
