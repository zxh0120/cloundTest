package com.dao;

import com.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {

    String findUserById();
    List<UserEntity> findUserAll();
}
