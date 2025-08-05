package com.mycomp.krishi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycomp.krishi.persistence.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

