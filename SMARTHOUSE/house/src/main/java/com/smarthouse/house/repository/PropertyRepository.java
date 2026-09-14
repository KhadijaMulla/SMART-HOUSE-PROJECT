package com.smarthouse.house.repository;

import com.smarthouse.house.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {

}