package com.example.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.models.Product;
import com.example.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
    public final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){ this.productRepository = productRepository;}

    public void addNewProduct(Product product){
//        Image image = new Image();
//        image.setImage("hinh");
//        image.setProduct(product);
//        product.setImages(Collections.singleton(image));
        productRepository.save(product);
    }
    public Optional<Product> getProductById(int id){
        return productRepository.findById(Long.valueOf(id));
    }
}