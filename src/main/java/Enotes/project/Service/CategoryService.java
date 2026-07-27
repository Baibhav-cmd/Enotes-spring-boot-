package Enotes.project.Service;

import Enotes.project.Model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Boolean saveCategory(Category category);
    List<Category> getAll();
    Category getById(long id);
    Boolean deleteById(long id);
    Boolean updateById(long id,Category category);
}
