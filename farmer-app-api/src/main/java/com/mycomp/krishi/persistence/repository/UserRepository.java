package com.mycomp.krishi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.krishi.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
