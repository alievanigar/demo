package com.example.moneymanager.dao;

import com.example.moneymanager.model.Category;
import com.example.moneymanager.model.User;

import java.util.List;
import java.util.Optional;

public interface CategoryDAO {

     List<Category> getAllCategory();

     void addCategory(Category category);

     void removeCategoryById(int id);

     Optional<Category> getCategoryById(int id);


}
