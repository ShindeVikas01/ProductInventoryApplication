package com.infinity.productinvmanager.entity;

import com.infinity.productinvmanager.model.ProductModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_inventorydb")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Please Enter the Product Name")
    private String name;
    @NotBlank(message = "Please Enter the Description")
    private String description;
    private Integer price;
    private Integer quantity;
    private String status;

    public ProductEntity(ProductModel productModel) {
        this.name = productModel.getName();
        this.description = productModel.getDescription();
        this.price = productModel.getPrice();
        this.quantity = productModel.getQuantity();
        this.status = productModel.getStatus();
    }
}
