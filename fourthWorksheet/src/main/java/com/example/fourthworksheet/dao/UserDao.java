package com.example.fourthworksheet.dao;

import com.example.fourthworksheet.entity.UserEntity;
import com.example.fourthworksheet.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDao {

    @Autowired
    UserRepositories userRepositories;

    public List<UserEntity> findAll()
    {
        return  userRepositories.findAll();
    }

    public UserEntity findUserById(Long id)
    {
        Optional<UserEntity> userEntity= userRepositories.findById(id);
        return userEntity.orElse(null);
    }

    public UserEntity save(UserEntity userEntity)
    {
        userEntity=userRepositories.save(userEntity);
        return userEntity;
    }
    public void delete(Long id)
    {
        userRepositories.deleteById(id);
    }


}
