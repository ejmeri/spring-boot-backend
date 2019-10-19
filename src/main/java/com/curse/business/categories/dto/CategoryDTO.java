package com.curse.business.categories.dto;

import java.io.Serializable;

import com.curse.business.categories.entity.Category;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    @NotEmpty(message = "Preenchimento obrigatório.")
    @Length(min=3, max = 80, message = "Tamanho de caracteres deve estar entre 3 e 80")
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
}