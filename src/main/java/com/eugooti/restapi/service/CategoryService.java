package com.eugooti.restapi.service;

import com.eugooti.restapi.entity.Categories;
import com.eugooti.restapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Categories createCategory(Categories categories){
        return categoryRepository.save(categories);
    }
    public List<Categories> createCategories(List<Categories> categories){
        return categoryRepository.saveAll(categories);
    }
    public List<Categories> getCategories(){
        return categoryRepository.findAll();
    }
    public Categories getCategoryById(int id){
        return categoryRepository.findById(id).orElse(null);
    }
    public List<Categories> getCategoriesByUser(String user){
        return categoryRepository.findByCreatedBy(user);
    }
    public Categories updateCategory(Categories categories){

        Categories categories1=categoryRepository.findById(categories.getId()).orElse(null);

        assert categories1 != null;
        categories1.setName(categories.getName());
        categories1.setDescription(categories.getDescription());
        categories1.setMaximumCost(categories.getMaximumCost());
        return categoryRepository.save(categories1);
    }
    public String deleteCategory(int id){
        categoryRepository.deleteById(id);

        return "Deleted successfully";
    }


}
