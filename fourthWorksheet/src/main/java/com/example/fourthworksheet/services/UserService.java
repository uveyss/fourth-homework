package com.example.fourthworksheet.services;

import com.example.fourthworksheet.dao.UserDao;
import com.example.fourthworksheet.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<UserEntity> findAll()
    {
        return userDao.findAll();
    }
    public UserEntity findById(Long id)
    {
        return  userDao.findUserById(id);
    }
    public UserEntity save(UserEntity userEntity)
    {
       return userDao.save(userEntity);
    }
    public void delete(Long id)
    {
        userDao.delete(id);
    }

}
