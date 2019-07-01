package com.boshko.IEShop.service;

import com.boshko.IEShop.controller.repr.ProductRepr;
import com.boshko.IEShop.persist.model.Picture;
import com.boshko.IEShop.persist.model.PictureData;
import com.boshko.IEShop.persist.model.Product;
import com.boshko.IEShop.persist.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService, Serializable {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductRepr> findAll() {
        return productRepository.findAll().stream()
                .map(ProductRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductRepr findById(Long id) {
        return new ProductRepr(productRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(ProductRepr productRepr) throws IOException {
        Product product = (productRepr.getId() != null) ? productRepository.findById(productRepr.getId()).get()
                : new Product();
        product.setName(productRepr.getName());
        product.setCategories(productRepr.getCategories());
        product.setBrand(productRepr.getBrand());
        product.setPrice(productRepr.getPrice());
        if (productRepr.getNewPictures() != null) {
            for (MultipartFile newPicture : productRepr.getNewPictures()) {
                logger.info("Product {} file {} size {}", product.getId(),
                        newPicture.getOriginalFilename(), newPicture.getSize());

                if (product.getPictures() == null) {
                    product.setPictures(new ArrayList<>());
                }

                product.getPictures().add(new Picture(newPicture.getOriginalFilename(),
                        newPicture.getContentType(), new PictureData(newPicture.getBytes())));
            }
        }
        productRepository.save(product);
    }
}
