package com.github.kartakusuma.springcrudjpamysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.kartakusuma.springcrudjpamysql.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
