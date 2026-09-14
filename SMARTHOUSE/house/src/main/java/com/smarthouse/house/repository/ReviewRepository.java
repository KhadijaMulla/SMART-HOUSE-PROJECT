package com.smarthouse.house.repository;

import com.smarthouse.house.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}