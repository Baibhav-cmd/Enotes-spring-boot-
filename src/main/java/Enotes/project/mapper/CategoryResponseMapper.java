package Enotes.project.mapper;

import Enotes.project.Model.Category;
import Enotes.project.dto.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {
    List<Category> toEntity(List<CategoryResponse>categoryResponse);
    List<CategoryResponse> toDto(List<Category> category);
    Category toEntity(CategoryResponse categoryResponse);
    CategoryResponse toDto (Category category);
}
