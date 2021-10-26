package com.example.moneymanager.service;

import com.example.moneymanager.dao.CategoryTypeDAO;
import com.example.moneymanager.model.CategoryType;
import com.example.moneymanager.model.User;
import com.example.moneymanager.repository.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategortTypeService implements CategoryTypeDAO {
    @Autowired
    CategoryTypeRepository categoryTypeRepository;

    @Override
    public List<CategoryType> getAllCategoryType() {
        return categoryTypeRepository.findAll();
    }

    @Override
    public void addCategoryType(CategoryType categoryType) {
        categoryTypeRepository.save(categoryType);
    }

    @Override
    public void removeCategoryTypeById(int id) {
        categoryTypeRepository.deleteById(id);
    }

    @Override
    public Optional<CategoryType> getCategoryTypeById(int id) {
        return categoryTypeRepository.findById(id);
    }


}
