package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.persist.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("from Role r where name = :name")
    Role findOneByName(String name);
}
