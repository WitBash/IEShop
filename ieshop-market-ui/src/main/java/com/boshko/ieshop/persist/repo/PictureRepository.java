package com.boshko.ieshop.persist.repo;

import com.boshko.ieshop.persist.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
