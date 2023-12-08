package com.infinity.productinvmanager.controller;

import com.infinity.productinvmanager.model.ProductModel;
import com.infinity.productinvmanager.responses.Response;
import com.infinity.productinvmanager.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/addproduct")
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductModel productModel) {
        return new ResponseEntity<>(new Response("Product Added",HttpStatus.CREATED,productService.addProduct(productModel)), HttpStatus.CREATED) ;
    }

    @GetMapping("/getallproducts")
    public ResponseEntity<?> getallproducts() {
        return new ResponseEntity<>(new Response("All Products Listed",HttpStatus.FOUND,productService.getAllProducts()),HttpStatus.FOUND);
    }

    @GetMapping("/getproductbyid/{id}")
    public ResponseEntity<?> getproductbyid(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new Response("Product Search",HttpStatus.FOUND,productService.getProductById(id)),HttpStatus.FOUND);
    }

    @GetMapping("/updateproduct/{id}")
    public ResponseEntity<?> updateproduct(@PathVariable("id") Integer id,@RequestBody ProductModel productModel) {
        return new ResponseEntity<>(new Response("Product Updated.",HttpStatus.ACCEPTED,productService.updateProduct(id,productModel)),HttpStatus.ACCEPTED);
    }

    @GetMapping("/deleteproduct/{id}")
    public ResponseEntity<?> deleteproduct(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(new Response("Product Deleted",HttpStatus.ACCEPTED,productService.deleteProduct(id)),HttpStatus.ACCEPTED);
    }
}
