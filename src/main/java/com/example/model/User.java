package com.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//一定要序列化
@Data
public class User implements Serializable {

    private String id;
    private String username;
    private Date   birthday;
    private String sex;
    private String address;

    public User(String username, String sex) {
        this.username = username;
        this.sex = sex;
    }
}
