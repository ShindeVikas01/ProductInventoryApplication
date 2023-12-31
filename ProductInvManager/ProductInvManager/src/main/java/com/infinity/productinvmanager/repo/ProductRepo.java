package com.infinity.productinvmanager.repo;

import com.infinity.productinvmanager.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
}
