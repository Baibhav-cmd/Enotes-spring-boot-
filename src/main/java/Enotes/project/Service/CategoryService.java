package Enotes.project.Service;

import Enotes.project.Model.Category;
import Enotes.project.dto.CategoryDto;
import Enotes.project.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Boolean saveCategory(CategoryDto categoryDto);
    List<CategoryResponse> getAll();
    CategoryResponse getById(long id);
    Boolean deleteById(long id);
    Boolean updateById(long id,CategoryDto categoryDto);

    List<CategoryResponse> getActive();
}
