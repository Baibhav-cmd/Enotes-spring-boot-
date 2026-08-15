package Enotes.project.dto;

import Enotes.project.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private Long createdBy;
    private Instant createdAt;

}
