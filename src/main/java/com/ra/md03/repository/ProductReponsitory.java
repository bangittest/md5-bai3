package com.ra.md03.repository;

import com.ra.md03.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory  extends JpaRepository<Product,Long> {
}
