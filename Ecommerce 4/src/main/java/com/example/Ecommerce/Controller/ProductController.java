package com.example.Ecommerce.Controller;

import com.example.Ecommerce.DTO.ProductDTO;
import com.example.Ecommerce.Entity.Product;
import com.example.Ecommerce.Handler.ResponseHandler;
import com.example.Ecommerce.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    @PostMapping("/add/categories/{categoryId}/products")
    private ResponseEntity<Object> AddProduct(@Valid @RequestBody Product product, @PathVariable int categoryid){
        ProductDTO addedProduct=productService.addProduct(categoryid,product);
       return ResponseHandler.GenerateResponse(addedProduct ,"product is successfully added",HttpStatus.CREATED);
    }
    @GetMapping("/demo")
    public String Democontroller(){
        return "superb";
    }
}
