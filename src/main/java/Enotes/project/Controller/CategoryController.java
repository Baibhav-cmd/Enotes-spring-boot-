package Enotes.project.Controller;

import Enotes.project.Service.CategoryService;
import Enotes.project.dto.CategoryDto;
import Enotes.project.dto.CategoryResponse;
import Enotes.project.utils.CommonUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {

        List<CategoryResponse> categories = categoryService.getAll();

        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        }

        log.info("Categories found, count: {}", categories.size());
        return CommonUtils.createSuccessResponse(categories, HttpStatus.OK, "Categories fetched successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {

        CategoryResponse category = categoryService.getById(id);

        log.info("user found sucessdully");
        return CommonUtils.createBuilderResponse(category,HttpStatus.FOUND);

    }

    @PostMapping("/")
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDto categoryDto) {


        Boolean saved = categoryService.saveCategory(categoryDto);

        if (saved) {
            return CommonUtils.createBuilderResponseMessage(HttpStatus.CREATED,"saved success");
        }

        return CommonUtils.createdErrorResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR,"not saved");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @Valid @RequestBody CategoryDto categoryDto){

        Boolean updated = categoryService.updateById(id, categoryDto);

        if (updated) {
            return  CommonUtils.createBuilderResponseMessage(HttpStatus.CREATED,"update sucessfully");
        }

        return
                CommonUtils.createdErrorResponseMessage(HttpStatus.BAD_REQUEST,"failed top update");
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

        List<CategoryResponse> categories = categoryService.getActive();

        if (CollectionUtils.isEmpty(categories)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(categories);
    }

}
