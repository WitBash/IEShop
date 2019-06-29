package com.boshko.IEShop.controller.repr;

import com.boshko.IEShop.persist.model.Brand;
import com.boshko.IEShop.persist.model.CategoryProducts;
import com.boshko.IEShop.persist.model.Picture;
import com.boshko.IEShop.persist.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductRepr {
    private Long id;

    private String name;

    private BigDecimal price;

    private Set<CategoryProducts> categories;

    private Brand brand;

    private List<PictureRepr> pictures;

    private MultipartFile[] newPictures;

    public ProductRepr() {
    }

    public ProductRepr(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.categories = product.getCategories();
        this.brand = product.getBrand();
        this.pictures = product.getPictures().stream()
                .map(PictureRepr::new)
                .collect(Collectors.toList());
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<CategoryProducts> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryProducts> categories) {
        this.categories = categories;
    }

    public String getCategoriesAsString() {
        return getCategories()
                .stream()
                .map(CategoryProducts::getName)
                .collect(Collectors.joining(", "));
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<PictureRepr> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureRepr> pictures) {
        this.pictures = pictures;
    }

    public MultipartFile[] getNewPictures() {
        return newPictures;
    }

    public void setNewPictures(MultipartFile[] newPictures) {
        this.newPictures = newPictures;
    }

}
