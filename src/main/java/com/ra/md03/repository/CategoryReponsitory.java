package com.ra.md03.repository;

import com.ra.md03.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReponsitory extends JpaRepository<Category,Long> {
}
