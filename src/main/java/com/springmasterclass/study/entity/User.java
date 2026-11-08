package com.springmasterclass.study.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity 
@Table (name = "tl_userq")
@Getter 
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder // Giup cho cac ban co the insert vao user mot cach de dang hon thay vi su dung constructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  @Column(name = "address", length = 30)
  private String address;
  @Column(name = "phone", length = 10)
  private String phone;
  @Column(unique = true)
  private String email;
  private String username;
  private String password;

  


  
}
