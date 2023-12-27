package com.ra.md03.model.service;

import com.ra.md03.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product saveOrUpdate(Product product);
    Product findById(Long id);
    void delete(Long id);
}
