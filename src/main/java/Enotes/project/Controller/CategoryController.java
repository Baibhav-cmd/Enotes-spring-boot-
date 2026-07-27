package Enotes.project.Controller;

import Enotes.project.Model.Category;
import Enotes.project.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        List<Category> geetall=categoryService.getAll();
        if(CollectionUtils.isEmpty(geetall)){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(geetall);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Category category) {
        Boolean saveCategory=categoryService.saveCategory(category);
        if(saveCategory){
        return ResponseEntity.status(HttpStatus.CREATED).body("created Sucessfully");
    }
        else {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("it is  not veratrd");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @RequestBody Category category) {

        categoryService.updateById(id, category);
        return ResponseEntity.ok(true);
    }
}