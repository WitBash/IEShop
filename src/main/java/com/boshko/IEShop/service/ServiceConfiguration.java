package com.boshko.IEShop.service;

import com.boshko.IEShop.persist.repo.ProductRepository;
import com.boshko.IEShop.persist.repo.RoleRepository;
import com.boshko.IEShop.persist.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository,
                                   BCryptPasswordEncoder passwordEncoder) {
        return new UserServiceJpaImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
