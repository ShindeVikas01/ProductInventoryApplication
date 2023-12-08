package com.infinity.productinvmanager.service.impl;

import com.infinity.productinvmanager.entity.ProductEntity;
import com.infinity.productinvmanager.exception.ProductNotFoundException;
import com.infinity.productinvmanager.model.ProductModel;
import com.infinity.productinvmanager.repo.ProductRepo;
import com.infinity.productinvmanager.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductModel addProduct(ProductModel productModel) {
        ProductEntity productEntity = new ProductEntity(productModel);
        ProductModel productModel2 = modelMapper.map(productEntity,ProductModel.class);
        productRepo.save(productEntity);
        return productModel2;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public String updateProduct(Integer id,ProductModel productModel) {
        ProductEntity productEntity = productRepo.findById(id).get();
        if(productEntity != null) {
            productEntity.setName(productModel.getName());
            productEntity.setDescription(productModel.getDescription());
            productEntity.setPrice(productModel.getPrice());
            productEntity.setQuantity(productModel.getQuantity());
            productEntity.setStatus(productModel.getStatus());
            productRepo.save(productEntity);
            return "Product is Updated";
        } else {
            return "Product is Not Available";
        }
    }

    @Override
    public String deleteProduct(Integer id) {
        ProductEntity productEntity = productRepo.findById(id).get();
        if(productEntity != null) {
            productRepo.delete(productEntity);
            return "Product is Deleted";
        } else {
            return "Product is Not Available";
        }
    }

    @Override
    public ProductModel getProductById(Integer id) {
        ProductEntity productEntity = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
        ProductModel productModel = modelMapper.map(productEntity,ProductModel.class);
        return productModel;
//        Optional<ProductEntity> productEntity = productRepo.findById(id);
//        if(productEntity.isPresent()) {
//            ProductModel productModel = modelMapper.map(productEntity,ProductModel.class);
//            return productModel;
//        }
//        throw new ProductNotFoundException("Product Not Found");
    }
}
