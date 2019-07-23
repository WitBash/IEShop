package com.boshko.IEShop.service;

import com.boshko.IEShop.service.model.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<SystemUser> findById(Long id);

    Optional<SystemUser> findByUserName(String username);

    boolean existsUserByEmail(String email);

    boolean save(SystemUser systemUser);

    List<SystemUser> findAll();

    void delete(Long id);
}
