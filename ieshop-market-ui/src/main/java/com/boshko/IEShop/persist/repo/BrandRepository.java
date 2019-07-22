package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.persist.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
