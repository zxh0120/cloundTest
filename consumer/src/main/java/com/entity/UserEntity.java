package com.entity;

import lombok.Data;

@Data
public class UserEntity {
    private int id;
    private String userName;
    private String password;
    private int start;
    private String content;
}
