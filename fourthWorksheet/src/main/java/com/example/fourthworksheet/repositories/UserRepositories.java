package com.example.fourthworksheet.repositories;

import com.example.fourthworksheet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity,Long> {


}
