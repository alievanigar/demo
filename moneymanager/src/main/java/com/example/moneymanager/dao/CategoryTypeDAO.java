package com.example.moneymanager.dao;

import com.example.moneymanager.model.Category;
import com.example.moneymanager.model.CategoryType;
import com.example.moneymanager.model.User;

import java.util.List;
import java.util.Optional;

public interface CategoryTypeDAO {

    List<CategoryType> getAllCategoryType();

    void addCategoryType(CategoryType categoryType);

     void removeCategoryTypeById(int id);

     Optional<CategoryType> getCategoryTypeById(int id);

}
