package com.springboot.blog.controller;

import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
     }

     @PostMapping
     @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<String> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
         return ResponseEntity.ok("Category created successfully");
     }

     @GetMapping
        public ResponseEntity<List<CategoryDto>> getAllCategories() {
         return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") long id) {
         return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
        public ResponseEntity<String> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable(name = "id") long id) {
            String response = categoryService.updateCategory(categoryDto, id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
