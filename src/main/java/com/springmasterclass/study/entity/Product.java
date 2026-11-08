package com.springmasterclass.study.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor 
@Builder 
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private BigDecimal price;
  private String category;
  private String status;
}
