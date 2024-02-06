package com.eugooti.restapi.controller;

import com.eugooti.restapi.entity.Categories;
import com.eugooti.restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/createCategory")
    public Categories createCategory(@RequestBody Categories categories){
        return categoryService.createCategory(categories);
    }

    @PostMapping("/createCategories")
    public List<Categories> createCategories(@RequestBody List<Categories> categories){
        return categoryService.createCategories(categories);
    }

    @GetMapping("/categories")
    public List<Categories> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public Categories getById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/categories/{user}")
    public List<Categories> getByUser(@PathVariable String user){
        return categoryService.getCategoriesByUser(user);
    }

    @PutMapping("/updateCategory")
    public Categories updateCategory(Categories categories){
        return categoryService.updateCategory(categories);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }

}
