package Enotes.project.Service.serviceimpl;

import Enotes.project.Model.Category;
import Enotes.project.Repository.CategoryRepository;
import Enotes.project.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private final CategoryRepository categoryRepository;
    @Override
    public Boolean saveCategory(Category category) {
         category.setIsDelete(false);
         category.setIsActive(true);
        Category saved=categoryRepository.save(category);
        return true;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoryList=categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public Category getById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }
    @Override
    public Boolean deleteById(long id ) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
//        category.setIsDelete(true);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateById(long id, Category category) {

        if(category.getIsActive() && category.getIsDelete()==false) {
            Category existing = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("category is not found"));
            existing.setName(category.getName());
            existing.setDescription(category.getDescription());
            categoryRepository.save(existing);
            return true;
        }
        else {
            return false;
        }
    }
}
