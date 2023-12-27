package com.ra.md03.model.service;

import com.ra.md03.model.entity.Category;
import com.ra.md03.repository.CategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryReponsitory categoryReponsitory;
    @Override
    public List<Category> findAll() {
        return categoryReponsitory.findAll();
    }

    @Override
    public Category saveOrUpdate(Category category) {
        return categoryReponsitory.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category>category=categoryReponsitory.findById(id);
        return category.orElse(null);
    }

    @Override
    public void delete(Long id) {
        categoryReponsitory.deleteById(id);
    }
}
