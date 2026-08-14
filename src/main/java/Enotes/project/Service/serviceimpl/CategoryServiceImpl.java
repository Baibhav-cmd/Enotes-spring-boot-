package Enotes.project.Service.serviceimpl;

import Enotes.project.Exception.CategoryNotFoundException;
import Enotes.project.Model.Category;
import Enotes.project.Repository.CategoryRepository;
import Enotes.project.Service.CategoryService;
import Enotes.project.dto.CategoryDto;
import Enotes.project.dto.CategoryResponse;
import Enotes.project.mapper.CategoryMapper;
import Enotes.project.mapper.CategoryResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl  implements CategoryService  {
  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;
  private  final CategoryResponseMapper categoryResponseMapper;


    @Override
    @Transactional
    public Boolean saveCategory(CategoryDto categoryDto) {
        if (categoryDto == null || !StringUtils.hasText(categoryDto.getName())) {
            throw new IllegalArgumentException("Category name is required");
        }

        Boolean existing=categoryRepository.existsByName(categoryDto.getName());
        if(existing){
            throw  new RuntimeException("categroy already exists");
        }
        else {}
            Category category = categoryMapper.toEntity(categoryDto);
            category.setIsActive(true);
            category.setIsDelete(false);

            try {
                categoryRepository.save(category);
                return true;
            } catch (DataIntegrityViolationException e) {
                // e.g. duplicate name, DB constraint violation
                System.out.println(e.getMessage());
                return false;
            }
        }
    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAll() {
        List<Category> categoryList=categoryRepository.findAll();

        return categoryResponseMapper.toDto(categoryList);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getById(long id) {
        Category existingCategory=categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    return categoryResponseMapper.toDto(existingCategory);
    }

    @Override
    @Transactional
    public Boolean deleteById(long id)  {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));

        if (Boolean.TRUE.equals(existing.getIsDelete())) {
            // already deleted, nothing to do
            return true;
        }

        existing.setIsDelete(true);
        existing.setIsActive(false);
        categoryRepository.save(existing);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateById(long id, CategoryDto categoryDto)  {
        if (categoryDto == null || !StringUtils.hasText(categoryDto.getName())) {
            throw new CategoryNotFoundException("Category name is required");
        }

        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        if (!Boolean.TRUE.equals(existing.getIsActive()) || Boolean.TRUE.equals(existing.getIsDelete())) {
            return false; // can't update an inactive or deleted category
        }

        existing.setName(categoryDto.getName());
        existing.setDescription(categoryDto.getDescription());
        categoryRepository.save(existing);
        return true;
    }
    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getActive() {

        List<Category> category=  categoryRepository.findByIsActiveTrueAndIsDeleteFalse();
        List<CategoryResponse> categoryResponse=categoryResponseMapper.toDto(category);
        return categoryResponse;
    }
}
