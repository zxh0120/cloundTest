package com.service.imp;

import com.entity.UserEntity;
import com.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private com.dao.IUserDao IUserDao;

    @Override
    public String findUserById() {
        return IUserDao.findUserById();
    }

    @Override
    public List<UserEntity> findUserAll() {
        return IUserDao.findUserAll();
    }
}
