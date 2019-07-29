package com.boshko.ieshop.service.model;

import com.boshko.ieshop.controller.repr.ProductRepr;

import java.io.Serializable;
import java.util.Objects;

public class ProductInfo implements Serializable {
    private ProductRepr productRepr;

    private String size;

    private  String color;

    public ProductInfo(ProductRepr productRepr, String size, String color) {
        this.productRepr = productRepr;
        this.size = size;
        this.color = color;
    }

    public ProductRepr getProductRepr() {
        return productRepr;
    }

    public void setProductRepr(ProductRepr productRepr) {
        this.productRepr = productRepr;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return productRepr.equals(that.productRepr) &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepr, size, color);
    }
}
