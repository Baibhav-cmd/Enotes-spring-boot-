package Enotes.project.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Category extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

   private String name;

    private String description;
    private Boolean isActive;
    private Boolean isDelete;
    // In Category.java
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();
}
