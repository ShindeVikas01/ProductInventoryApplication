package com.infinity.productinvmanager.model;

import lombok.Data;

@Data
public class ProductModel {     //DTO [Data Transfer Object]
    private String name;
    private String description;
    private Integer price;
    private Integer quantity;
    private String status;
}
