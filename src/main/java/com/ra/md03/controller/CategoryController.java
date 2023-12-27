package com.ra.md03.controller;

import com.ra.md03.model.entity.Category;
import com.ra.md03.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String category(Model model){
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("category",categoryList);
        return "category/index";
    }
    @GetMapping("add-category")
    public String add(Model model){
        Category category=new Category();
        model.addAttribute("category",category);
        return "category/add-category";
    }
    @PostMapping("create-category")
    public String create(@ModelAttribute("category") Category category){
        if (category!=null){
            categoryService.saveOrUpdate(category);
            return "redirect:/category";
        }
        return "category/add-category";
    }
    @GetMapping("edit-category/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/edit-category";
    }

    @PostMapping("update-category")
    public String update(@ModelAttribute("category") Category category){
        if (category!=null){
            categoryService.saveOrUpdate(category);
            return "redirect:/category";
        }
        return "redirect:/edit-category/"+category.getId();
    }
    @GetMapping("delete-category/{id}")
    public String delete(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
