package com.sapient.gotomovies.movies.data.helper;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public abstract class BaseEntity {

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    @LastModifiedDate
    private Date updatedAt;
}
