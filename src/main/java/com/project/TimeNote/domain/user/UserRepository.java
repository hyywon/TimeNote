package com.project.TimeNote.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByPassword(String password);
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
