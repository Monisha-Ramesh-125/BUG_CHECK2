package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.ProductDTO;
import com.example.Ecommerce.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
  ProductDTO addProduct(int categoryId,Product product);
}
