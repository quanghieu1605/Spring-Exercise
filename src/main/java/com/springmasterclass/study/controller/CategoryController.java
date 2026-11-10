package com.springmasterclass.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmasterclass.study.common.ApiResponse;
import com.springmasterclass.study.common.BaseController;
import com.springmasterclass.study.dto.record.CategoryRequest;
import com.springmasterclass.study.entity.Category;
import com.springmasterclass.study.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor 
public class CategoryController extends BaseController{
  private final CategoryService categoryService;


  // 1 Tao moi category va danh sach cac products
  @PostMapping
  public ResponseEntity<ApiResponse<Category>> creatCategory(@RequestBody CategoryRequest rq){
    Category created = categoryService.createCategory(rq);
    return new ResponseEntity<>(createSuccessResponse(created), HttpStatus.CREATED);
  }

  // 2 Cap nhat category (them/sua/xoa product)
  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<Category>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest dto){
    Category updated = categoryService.updateCategory(id, dto);
    return ResponseEntity.ok(createSuccessResponse(updated));
  }
}
  

