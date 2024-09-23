package com.vladproduction.fabric8app.repository;

import com.vladproduction.fabric8app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {




}
