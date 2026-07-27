package Enotes.project.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
private long id;

private String name;
    @Column(nullable = false)

    @Size(min = 10, max = 1000, message = "Description must be 10-500 characters")
    private String description;
}
