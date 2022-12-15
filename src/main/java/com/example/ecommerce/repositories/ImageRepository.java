package com.example.ecommerce.repositories;

import com.example.ecommerce.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Transactional
    @Modifying
    @Query("update Image set image=(:image) where id = (:id)")
    public void updateImage(Long id, String image);
}
