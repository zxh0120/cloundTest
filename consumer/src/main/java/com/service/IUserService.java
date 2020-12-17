package com.service;


import com.entity.UserEntity;

import java.util.List;

public interface IUserService {

    String findUserById();

    List<UserEntity> findUserAll();


}
