package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.persist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
