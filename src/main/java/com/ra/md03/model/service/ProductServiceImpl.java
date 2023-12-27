package com.ra.md03.model.service;

import com.ra.md03.model.entity.Product;
import com.ra.md03.repository.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductReponsitory productReponsitory;
    @Override
    public List<Product> findAll() {
        return productReponsitory.findAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productReponsitory.save(product);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product=productReponsitory.findById(id);
        return product.orElse(null);
    }

    @Override
    public void delete(Long id) {
        productReponsitory.deleteById(id);
    }
}
