package com.boshko.ieshop.persist.repo;

import com.boshko.ieshop.persist.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
