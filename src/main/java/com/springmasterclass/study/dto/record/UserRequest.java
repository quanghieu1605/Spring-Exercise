package com.springmasterclass.study.dto.record;

import com.springmasterclass.study.anotation.Cccd;

import jakarta.validation.constraints.*;

public record UserRequest(
        @NotEmpty(message = "Truong nay khong duco de trong") // Doi tuong quan tam khac null va do dai chuoi phai lon
                                                              // hon 0
        @NotBlank // Doi tuong no quan tam la khac null va sau khi bo het dau cach thi phai lon
                  // hon 0
        @NotNull(message = "Truong nay khong duoc null") // No chi quan tam den cac doi tuong bi null

        String name,
        @Size(min = 9, max = 11, message = "So dien thoai phai co 9-10 ki tu") String phone,
        @Email @NotBlank String email,
        String address,
        @Pattern(regexp = "")
        String username,
        String password,
        String fullName,
        @Cccd 
        String cccd
) {

}
