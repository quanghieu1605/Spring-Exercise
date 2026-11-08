package com.springmasterclass.study.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springmasterclass.study.dto.record.ProductResponse;

@Service 
public interface ProductService {
    Page<ProductResponse> getAllProducts(String name, String category, Pageable pageable);
}
