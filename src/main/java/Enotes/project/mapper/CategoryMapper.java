package Enotes.project.mapper;

import Enotes.project.Model.Category;
import Enotes.project.dto.CategoryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);

    List<CategoryDto> toDto(List<Category> categories);
    List<Category> toEntity(List<CategoryDto> categoryDtos);
}
