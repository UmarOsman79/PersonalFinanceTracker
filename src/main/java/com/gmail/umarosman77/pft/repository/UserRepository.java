package com.gmail.umarosman77.pft.repository;

import com.gmail.umarosman77.pft.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
