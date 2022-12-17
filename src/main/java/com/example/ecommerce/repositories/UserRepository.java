package com.example.ecommerce.repositories;

import com.example.ecommerce.utils.Gender;
import com.example.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "update User set name=(:name), tel=(:tel), gender=(:gender), address=(:address) where id = (:id)")
    public void updateUser(Long id, String name, String tel, Gender gender, String address);

    public User findByTel(String tel);
}
