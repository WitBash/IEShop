package com.boshko.IEShop.persist.repo;

import com.boshko.IEShop.persist.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
