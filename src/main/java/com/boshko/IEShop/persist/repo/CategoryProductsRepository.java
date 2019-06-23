package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.persist.model.CategoryProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductsRepository extends JpaRepository<CategoryProducts, Long> {
}
