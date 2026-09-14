package com.smarthouse.house.repository;

import com.smarthouse.house.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmail(String email);
}