package com.example.moneymanager.controller;

import com.example.moneymanager.dao.CategoryDAO;
import com.example.moneymanager.dao.CategoryTypeDAO;
import com.example.moneymanager.dao.UserDAO;
import com.example.moneymanager.dto.CategoryDTO;
import com.example.moneymanager.dto.CategoryTypeDTO;
import com.example.moneymanager.model.Category;
import com.example.moneymanager.model.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    CategoryTypeDAO categoryTypeDAO;

    @Autowired
    UserDAO userDAO;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model){
        model.addAttribute("categories",categoryDAO.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("categoryDTO", new CategoryDTO());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        categoryDAO.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryDAO.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model){

        Optional<Category> category = categoryDAO.getCategoryById(id);

        if(category.isPresent()){
            CategoryDTO categoryDTO = new CategoryDTO();

            categoryDTO.setId(category.get().getId());
            categoryDTO.setName(category.get().getName());

            model.addAttribute("categoryDTO",categoryDTO);
            return "categoriesAdd";
        }
        else
            return "404";
    }

    // Type Section

    @GetMapping("/admin/categorytypes")
    public String products(Model model){
        model.addAttribute("categoryTypes", categoryTypeDAO.getAllCategoryType());
        return "categoryType";
    }

    @GetMapping("/admin/categorytypes/add")
    public String getCatTypeAdd(Model model){
        model.addAttribute("categoryTypeDTO", new CategoryTypeDTO());
        model.addAttribute("categories",categoryDAO.getAllCategory());
        return "categoryTypeAdd";
    }

    @PostMapping("/admin/categorytypes/add")
    public String postCatTypeAdd(@ModelAttribute("categoryTypeDTO") CategoryTypeDTO categoryTypeDTO){
        CategoryType categoryType = new CategoryType();

        categoryType.setId(categoryTypeDTO.getId());
        categoryType.setName(categoryTypeDTO.getName());
        categoryType.setCategory(categoryDAO.getCategoryById(categoryTypeDTO.getCategoryId()).get());
        categoryType.setUser(userDAO.getUserById (categoryTypeDTO.getUserId()).get());

        categoryTypeDAO.addCategoryType(categoryType);
        return "redirect:/admin/categorytypes";
    }

    @GetMapping("/admin/categoryType/delete/{id}")
    public String deleteCatType(@PathVariable int id){
        categoryTypeDAO.removeCategoryTypeById(id);
        return "redirect:/admin/categorytypes";
    }

    @GetMapping("/admin/categoryType/update/{id}")
    public String updateCatType(@PathVariable int id, Model model){
        CategoryType categoryType = categoryTypeDAO.getCategoryTypeById(id).get();


        CategoryTypeDTO categoryTypeDTO = new CategoryTypeDTO();

        categoryTypeDTO.setId(categoryType.getId());
        categoryTypeDTO.setName(categoryType.getName());
        categoryTypeDTO.setCategoryId(categoryType.getCategory().getId());
        categoryTypeDTO.setUserId(categoryType.getUser().getId());

        model.addAttribute("categories",categoryTypeDAO.getAllCategoryType());
        model.addAttribute("categoryTypeDTO",categoryTypeDTO);

        return "categoryTypeAdd";
    }

}
