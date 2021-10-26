package com.example.moneymanager.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="money_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="category_id")
    private int id;

    private String name;
}
