package com.springmasterclass.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import com.springmasterclass.study.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product>{

  @Query(value = "SELECT p FROM Product p WHERE p.status = 'ACTIVE' AND p.category = :category", 
         countQuery = "SELECT count(p) FROM Product p WHERE p.status = 'ACTIVE' AND p.category = :category")
 Page<Product> findActiveByCategory(@Param("category") String category, Pageable pageab);
}
