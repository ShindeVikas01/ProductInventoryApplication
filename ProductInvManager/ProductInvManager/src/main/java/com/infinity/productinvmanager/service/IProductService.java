package com.infinity.productinvmanager.service;

import com.infinity.productinvmanager.entity.ProductEntity;
import com.infinity.productinvmanager.model.ProductModel;

import java.util.List;

public interface IProductService {

    public ProductModel addProduct(ProductModel productModel);

    public List<ProductEntity> getAllProducts();

    public String updateProduct(Integer id,ProductModel productModel);

    public String deleteProduct(Integer id);

    public ProductModel getProductById(Integer id);
}
