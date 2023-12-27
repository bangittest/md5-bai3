package com.ra.md03.controller;

import com.ra.md03.model.entity.Category;
import com.ra.md03.model.entity.Product;
import com.ra.md03.model.service.CategoryService;
import com.ra.md03.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/product")
    public String category(Model model){
        List<Product> products=productService.findAll();
        model.addAttribute("product",products);
        return"product/index";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("cate",categoryList);
        return "product/add-product";
    }
    @PostMapping("/create-product")
    public String create(@ModelAttribute("product") Product product){
        if (product!=null){
            productService.saveOrUpdate(product);
            return "redirect:/product";
        }
        return "product/add-product";
    }

    @GetMapping("edit-product/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        Product product=productService.findById(id);
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("cate",categoryList);
        model.addAttribute("product",product);
        return "product/edit-product";
    }
    @PostMapping("update-product")
    public String update(@ModelAttribute("product") Product product){
        if (product!=null){
            productService.saveOrUpdate(product);
            return "redirect:/product";
        }
        return "redirect:/edit-product/"+product.getId();
    }
    @GetMapping("delete-product/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.delete(id);
        return "redirect:/product";
    }
}
