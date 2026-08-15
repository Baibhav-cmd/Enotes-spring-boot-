package Enotes.project.dto;

import Enotes.project.Model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
@AllArgsConstructor
 @NoArgsConstructor
public class NoteDto {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private Long createdBy;
    private Long updatedBy;
    private Instant createdAt;

    private Instant updatedAt;
}
