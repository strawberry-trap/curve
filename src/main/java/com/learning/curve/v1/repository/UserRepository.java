package com.learning.curve.v1.repository;

import com.learning.curve.v1.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select user from UserEntity user where user.id = :userId")
    public Optional<UserEntity> findById(@RequestParam Long userId);

}
