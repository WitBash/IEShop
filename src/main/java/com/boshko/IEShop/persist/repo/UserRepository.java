package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.persist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUserName(String userName);

    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
