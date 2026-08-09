package Enotes.project.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private long id;
    private String name;
    private String description;
    private Boolean isActive;
    private  long createdby;
    private Date createdDate;


}
