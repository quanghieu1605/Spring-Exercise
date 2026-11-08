package com.springmasterclass.study.service.impl;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springmasterclass.study.dto.record.ProductResponse;
import com.springmasterclass.study.entity.Product;
import com.springmasterclass.study.mapper.ProductMapper;
import com.springmasterclass.study.repository.ProductRepository;
import com.springmasterclass.study.repository.specifications.ProductSpecification;
import com.springmasterclass.study.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getAllProducts(String name, String category, Pageable pageable) {

        // // Page<Product> products = productRepository.findAll(pageable);
        // Page<Product> products =
        // productRepository.findActiveByCategory(category,pageable);

        // Jpa Specification
        Page<Product> products = productRepository
                .findAll(ProductSpecification.filterProducts(name, BigDecimal.valueOf(10000), category), pageable);
        return products.map(productMapper::toResponse);
    }

}
