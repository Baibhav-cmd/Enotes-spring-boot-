package Enotes.project.Model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
@MappedSuperclass
public  abstract  class BaseModel {

    @CreatedBy
    @Column( updatable = false)
    private Long createdBy;
    @LastModifiedBy
    @Column(insertable = false)
    private Long updatedBy;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(insertable = false , name = "updated_date")
    private Instant updatedAt;
}
