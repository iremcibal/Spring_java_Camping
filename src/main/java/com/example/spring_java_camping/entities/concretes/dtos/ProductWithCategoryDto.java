package com.example.spring_java_camping.entities.concretes.dtos;

//Dto-> Data Transformation Option

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;



}
