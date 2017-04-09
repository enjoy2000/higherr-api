package com.higherr.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonSerializable;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseModel {

    private  @Id @GeneratedValue Long id;
    protected  @CreationTimestamp Date createdAt;
    protected  @UpdateTimestamp Date updatedAt;
}
