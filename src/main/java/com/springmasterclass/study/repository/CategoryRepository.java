package com.springmasterclass.study.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmasterclass.study.entity.Category;
@Repository 
public interface CategoryRepository extends JpaRepository<Category, Long> {
  
}
