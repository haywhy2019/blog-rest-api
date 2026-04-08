package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Category;
import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.repository.CategoryRepository;
import com.springboot.blog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    public CategoryServiceImpl( CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {
     Category category =  categoryRepository.findByName(categoryDto.getName());
     if (category != null) {
         throw new RuntimeException("Category already exists with name: " + categoryDto.getName());
     }
         Category newCategory = new Category();
         newCategory.setName(categoryDto.getName());
         newCategory.setDescription(categoryDto.getDescription());
        Category saveCategory =  categoryRepository.save(newCategory);
        mapToCategoryDto(saveCategory);

    }

    @Override
    public CategoryDto getCategory(long id) {
        return categoryRepository.findById(id).map(this::mapToCategoryDto)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        // Implementation for retrieving categories can be added here
        // For example, you can return a list of CategoryDto objects
        // by fetching all categories from the repository and mapping them to DTOs.
         List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::mapToCategoryDto).toList();
    }

    @Override
    public String updateCategory(CategoryDto categoryDto, long id) {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

            if(categoryDto.getName() != null) {
                category.setName(categoryDto.getName());
                category.setDescription(categoryDto.getDescription());
                Category updatedCategory = categoryRepository.save(category);
                  return "Category updated successfully with id: " + updatedCategory.getId();
            }
            return "Category name is required for update.";
    }

    @Override
    public void deleteCategory(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepository.delete(category);
    }

    private CategoryDto mapToCategoryDto(Category saveCategory) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(saveCategory.getId());
        categoryDto.setName(saveCategory.getName());
        categoryDto.setDescription(saveCategory.getDescription());
        return categoryDto;
    }
}
