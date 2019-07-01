package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.controller.repr.CategoryRepr;
import com.boshko.IEShop.persist.model.CategoryProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryProductsRepository extends JpaRepository<CategoryProducts, Long> {
    @Query("select new com.boshko.IEShop.controller.repr.CategoryRepr(c.id, c.name, count(p.id)) " +
            "from CategoryProducts c " +
            "left join c.products p " +
            "group by c.id, c.name")
    List<CategoryRepr> getAllCategoryRepr();
}
