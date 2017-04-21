package com.higherr.api.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseModel {

    protected   @Id @GeneratedValue Long id;
    protected  @CreationTimestamp Date createdAt;
    protected  @UpdateTimestamp Date updatedAt;
}
