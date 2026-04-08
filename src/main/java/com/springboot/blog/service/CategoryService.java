package com.springboot.blog.service;

import com.springboot.blog.entity.Category;
import com.springboot.blog.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(long id);
    List<CategoryDto> getAllCategory();

    String updateCategory(CategoryDto categoryDto, long id);

void deleteCategory(long id);

}
