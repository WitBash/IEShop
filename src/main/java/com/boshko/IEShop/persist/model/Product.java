package com.boshko.IEShop.persist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "category_products_id")
    private CategoryProducts category_products_id;

    public Product() {

    }

    public Product(String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getCategory_products_id() {
//        return category_products_id;
//    }
//
//    public void setCategory_products_id(int category_products_id) {
//        this.category_products_id = category_products_id;
//    }

    public CategoryProducts getCategoryProducts() {
        return category_products_id;
    }

    public void setCategoryProducts(CategoryProducts category_products_id) {
        this.category_products_id = category_products_id;
    }
}