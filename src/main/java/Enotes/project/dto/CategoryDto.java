package Enotes.project.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
//    @NotNull
//    @Min(value = 8)
//    @Max(value = 100)
    private String name;
//    @NotNull
    private String description;
//    @NotNull
    private boolean isActive;
    private Long createdBy;
    private Long updatedBy;
}
