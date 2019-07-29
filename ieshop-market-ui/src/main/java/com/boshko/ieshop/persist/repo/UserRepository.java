package com.boshko.ieshop.persist.repo;

import com.boshko.ieshop.persist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUserName(String userName);

    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
