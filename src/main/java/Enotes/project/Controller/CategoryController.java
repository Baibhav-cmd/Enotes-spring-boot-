package Enotes.project.Controller;

import Enotes.project.Model.Category;
import Enotes.project.Service.CategoryService;
import Enotes.project.dto.CategoryDto;
import Enotes.project.dto.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> getAll() {

        List<CategoryResponse> categories = categoryService.getAll();

        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable long id) {

        CategoryResponse category = categoryService.getById(id);

        return ResponseEntity.ok(category);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDto categoryDto) {


        Boolean saved = categoryService.saveCategory(categoryDto);

        if (saved) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Category created successfully");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to create category");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @Valid @RequestBody CategoryDto categoryDto) {

        Boolean updated = categoryService.updateById(id, categoryDto);

        if (updated) {
            return ResponseEntity.ok("Category updated successfully");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Failed to update category");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        Boolean deleted = categoryService.deleteById(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category not found");
    }

    // to show tfhe active category
    @GetMapping("/active")
    public ResponseEntity<List<CategoryResponse>> getActive() {

        List<CategoryResponse> categories = categoryService.getactive();

        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categories);
    }

}
