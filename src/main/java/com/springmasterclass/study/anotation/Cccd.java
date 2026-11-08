package com.springmasterclass.study.anotation;
import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CccdValidator.class)
public @interface Cccd {
  String message() default "Số cccd phải gồm 12 chữ số";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
