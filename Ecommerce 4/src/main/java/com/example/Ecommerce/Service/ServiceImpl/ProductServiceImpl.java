package com.example.Ecommerce.Service.ServiceImpl;

import com.example.Ecommerce.DTO.ProductDTO;
import com.example.Ecommerce.Entity.Product;
import com.example.Ecommerce.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDTO addProduct(int categoryId, Product product) {
        return null;
    }
//    @Override
//    public ProductDTO addProduct(int categoryId, Product product) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.
}
