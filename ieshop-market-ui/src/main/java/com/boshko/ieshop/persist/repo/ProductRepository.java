package com.boshko.ieshop.persist.repo;

import com.boshko.ieshop.persist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
