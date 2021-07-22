package com.mycomp.business.krishi.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.business.krishi.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
