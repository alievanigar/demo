package com.example.moneymanager.dto;


import lombok.Data;

@Data
public class CategoryTypeDTO {

    private int id;
    private String name;
    private int categoryId;
    private int userId;
}
